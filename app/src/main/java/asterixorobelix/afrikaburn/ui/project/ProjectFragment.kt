package asterixorobelix.afrikaburn.ui.project

import android.content.Context
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import asterixorobelix.afrikaburn.*
import asterixorobelix.afrikaburn.databinding.ProjectFragmentBinding
import asterixorobelix.afrikaburn.models.Project
import asterixorobelix.afrikaburn.models.ProjectNavigationArguments
import asterixorobelix.utilities.base.BaseViewModelFragment
import asterixorobelix.utilities.fromHTMLString
import asterixorobelix.utilities.ui.loadImageFromIDSetVisibility
import asterixorobelix.utilities.ui.loadImageFromURLSetVisibility
import asterixorobelix.utilities.ui.obtainStringFromResourceId
import asterixorobelix.utilities.ui.setVisibleOrGone
import com.google.android.material.navigation.NavigationView
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.camera.CameraPosition
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.maps.Style
import com.mapbox.mapboxsdk.plugins.annotation.CircleManager
import com.mapbox.mapboxsdk.plugins.annotation.CircleOptions
import com.mapbox.mapboxsdk.utils.ColorUtils
import org.koin.android.ext.android.inject

class ProjectFragment : BaseViewModelFragment<ProjectFragmentBinding, ProjectViewModel>() {
    //todo clicking map icon opens navigate me there page
    //todo burn scheduled time, project image, mark project as favourite
    private var mapMarkerCircleManager: CircleManager? = null

    override val layout: Int = R.layout.project_fragment
    override val viewModel: ProjectViewModel by inject()
    override val optionsMenuId: Int? = null

    override fun onAttach(context: Context) {
        Mapbox.getInstance(
            requireActivity().applicationContext,
            requireActivity().applicationContext.getString(R.string.mapbox_api_key)
        )
        super.onAttach(context)
    }

    override fun loadFragment() {
        hideToolbar()
//        val host = activity?.findNavController(R.id.nav_host_fragment) ?: return
//        val mainToolbar: Toolbar = view?.findViewById(R.id.project_toolbar) ?: return
//        val navView: NavigationView = view?.findViewById(R.id.nav_view) ?: return
//        mainToolbar.apply {
//            navView.setupWithNavController(host)
//        }
        binding?.apply {
            mapView.getMapAsync { mapboxMap ->
                mapboxMap.setStyle(Style.DARK) {
                }
            }
        }

        viewModel.apply {
            setNavArgs(arguments?.get(PROJECT_NAV_BUNDLE_ARGS_KEY) as? ProjectNavigationArguments)

            project.observe(viewLifecycleOwner, Observer { projectData ->
                setProjectToBinding(projectData)

                binding?.mapView?.apply {
                    getMapAsync { mapboxMap ->
                        mapboxMap.getStyle {
                            mapMarkerCircleManager = CircleManager(this, mapboxMap, it)
                            CircleOptions().run {
                                projectData.latitude?.toDoubleOrNull()?.let { lat ->
                                    projectData.longitude?.toDoubleOrNull()?.let { long ->
                                        withLatLng(LatLng(lat, long))

                                        val position =
                                            CameraPosition.Builder().target(LatLng(lat, long))
                                                .build()
                                        mapboxMap.animateCamera(
                                            CameraUpdateFactory.newCameraPosition(
                                                position
                                            )
                                        )

                                        //todo - move to utilities
                                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                                            withCircleColor(
                                                ColorUtils.colorToRgbaString(
                                                    resources.getColor(
                                                        projectData.getType().getColor(),
                                                        context.theme
                                                    )
                                                )
                                            )
                                        } else {
                                            ColorUtils.colorToRgbaString(
                                                resources.getColor(projectData.getType().getColor())
                                            )
                                        }
                                        withCircleRadius(10f)
                                        mapMarkerCircleManager?.create(this)
                                    }
                                }
                            }
                        }
                    }
                }
            })
        }
    }

    override fun setTitleAndRecycler() {
        toolbarTitle = ""
    }

    private fun toggleShimmer(binding: ProjectFragmentBinding) {
        binding.apply {
            projectInfoBodyLayout.setVisibleOrGone(visible = true)
            shimmerViewContainer.setVisibleOrGone(visible = false)
        }
    }

    private fun setProjectToBinding(project: Project) {
        binding?.apply {
            projectTitle.text = project.title
            projectFavouriteFab.loadImageFromIDSetVisibility(determineFavouriteImage(project.isFavourite))

            projectFavouriteFab.setOnClickListener {
                project.isFavourite = !project.isFavourite
                projectFavouriteFab.loadImageFromIDSetVisibility(determineFavouriteImage(project.isFavourite))
            }

            collectiveText.text =
                "${obtainStringFromResourceId(R.string.collective)}: ${project.getCollective()}"

            projectTypeImage.loadImageFromIDSetVisibility(project.getType().getIcon())
            soundImage.loadImageFromIDSetVisibility(getSoundImage(project.hasSound()))

            detailImage.loadImageFromURLSetVisibility(project.getImageUrl())

            if (project.hasSound()) {
                level.text = project.getSoundLevel().name
                soundLevelLayout.setVisibleOrGone(project.hasSound())
            }

            if (project.willBurn()) {
                burnImage.loadImageFromIDSetVisibility(R.drawable.ic_burn)
            }

            bodyTextview.text = project.longDescription?.fromHTMLString()

            toggleShimmer(this)

            if (project.getWebsites().isNotEmpty()) {
                projectItemsRecycler.adapter = ProjectWebsitesAdapter(project.getWebsites().filter {
                    !it.isNullOrEmpty()
                })
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        showToolbar()
    }

    companion object {
        const val PROJECT_NAV_BUNDLE_ARGS_KEY = "ProjectNavBundleArgsKey"
    }
}
