package asterixorobelix.afrikaburn.ui.search.filters

import androidx.core.view.children
import asterixorobelix.afrikaburn.R
import asterixorobelix.afrikaburn.databinding.FiltersFragmentBinding
import asterixorobelix.afrikaburn.models.Project
import asterixorobelix.utilities.base.BaseViewModelFragment
import asterixorobelix.utilities.ui.obtainStringFromResourceId
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class FiltersFragment : BaseViewModelFragment<FiltersFragmentBinding, FiltersViewModel>() {
    override val layout: Int = R.layout.filters_fragment
    override val viewModel: FiltersViewModel by sharedViewModel()
    override val optionsMenuId: Int? = null

    override fun loadFragment() {
        setTitleAndRecycler()
        binding?.apply {
            projectTypeGroup.children.forEach {
                it.setOnClickListener {
                    getFilters(projectTypeGroup.checkedChipIds, otherFiltersGroup.checkedChipIds)
                }
            }

        }

        viewModel.apply {
            setChipToChecked(getProjectFilterType())
        }
    }

    override fun setTitleAndRecycler() {
        toolbarTitle = obtainStringFromResourceId(R.string.filters)
    }

    private fun setChipToChecked(projectType: Project.ProjectType) {
        when (projectType) {
            Project.ProjectType.Artwork -> binding?.artworkChip?.isChecked = true
            Project.ProjectType.Event -> binding?.eventChip?.isChecked = true
            Project.ProjectType.Vehicle -> binding?.vehicleChip?.isChecked = true
            Project.ProjectType.Camp -> binding?.campChip?.isChecked = true
            else -> null
        }
    }

    private fun getFilters(projectTypeFilters: List<Int>, otherFilters: List<Int>) {
        projectTypeFilters.forEach {
            when (it) {
                binding?.vehicleChip?.id -> viewModel.setProjectFilterType(Project.ProjectType.Vehicle)
                binding?.campChip?.id -> viewModel.setProjectFilterType(Project.ProjectType.Camp)
                binding?.eventChip?.id -> viewModel.setProjectFilterType(Project.ProjectType.Event)
                binding?.artworkChip?.id -> viewModel.setProjectFilterType(Project.ProjectType.Artwork)
                else -> viewModel.setProjectFilterType(Project.ProjectType.Unknown)
            }
        }

        otherFilters.forEach {

        }
    }
}
