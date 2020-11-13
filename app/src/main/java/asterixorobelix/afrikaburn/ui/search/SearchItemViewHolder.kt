package asterixorobelix.afrikaburn.ui.search

import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import asterixorobelix.afrikaburn.R
import asterixorobelix.afrikaburn.databinding.LayoutSearchItemBinding
import asterixorobelix.afrikaburn.determineFavouriteImage
import asterixorobelix.afrikaburn.getIcon
import asterixorobelix.afrikaburn.getSoundImage
import asterixorobelix.afrikaburn.models.Project
import asterixorobelix.afrikaburn.models.ProjectNavigationArguments
import asterixorobelix.afrikaburn.ui.project.ProjectFragment
import asterixorobelix.utilities.ui.loadImageFromIDSetVisibility
import asterixorobelix.utilities.ui.loadImageFromURLSetVisibility

class SearchItemViewHolder(private val layoutSearchItemBinding: LayoutSearchItemBinding) :
    RecyclerView.ViewHolder(layoutSearchItemBinding.root) {

    fun onBind(project: Project?) {
        project?.let {
            layoutSearchItemBinding.apply {
                title.text = project.title
                subtitle.text =
                    "${this.root.context.getString(R.string.collective)}: ${project.getCollective()}"

                project.getImageUrl()?.let {
                    icon.loadImageFromURLSetVisibility(it)
                }

                projectTypeImage.loadImageFromIDSetVisibility(project.getType().getIcon())
                soundImage.loadImageFromIDSetVisibility(getSoundImage(project.hasSound()))

                if (project.willBurn()) {
                    burnImage.loadImageFromIDSetVisibility(R.drawable.ic_burn)
                }

                favouriteIcon.loadImageFromIDSetVisibility(determineFavouriteImage(project.isFavourite))
                favouriteIcon.setOnClickListener {
                    project.isFavourite = !project.isFavourite
                    favouriteIcon.loadImageFromIDSetVisibility(determineFavouriteImage(project.isFavourite))
                }

                root.setOnClickListener {
                    val projectNavArgs = ProjectNavigationArguments(
                        projectId = project.nid,
                        projectType = project.getType()
                    )
                    it.findNavController()
                        .navigate(
                            R.id.projectFragment,
                            bundleOf(
                                Pair(
                                    ProjectFragment.PROJECT_NAV_BUNDLE_ARGS_KEY,
                                    projectNavArgs
                                )
                            )
                        )
                }
            }
        }

    }
}