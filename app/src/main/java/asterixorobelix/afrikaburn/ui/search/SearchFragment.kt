package asterixorobelix.afrikaburn.ui.search

import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import asterixorobelix.afrikaburn.R
import asterixorobelix.afrikaburn.databinding.FragmentSearchBinding
import asterixorobelix.afrikaburn.getColor
import asterixorobelix.afrikaburn.models.Project
import asterixorobelix.afrikaburn.ui.search.filters.FiltersViewModel
import asterixorobelix.utilities.base.BaseViewModelFragment
import asterixorobelix.utilities.ui.obtainStringFromResourceId
import asterixorobelix.utilities.ui.setVisibleOrGone
import com.google.android.material.chip.Chip
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class SearchFragment : BaseViewModelFragment<FragmentSearchBinding, SearchViewModel>() {

    override val layout: Int = R.layout.fragment_search
    override val optionsMenuId: Int? = null
    override val viewModel: SearchViewModel by inject()

    private val searchAdapter = SearchItemAdapter(ProjectComparator())
    private val filtersViewModel: FiltersViewModel by sharedViewModel()

    override fun loadFragment() {
        binding?.apply {
            recyclerView?.adapter = searchAdapter
            viewModel.numberOfProjects.observe(viewLifecycleOwner, Observer {
                toolbarTitle =
                    "$it ${obtainStringFromResourceId(R.string.projects)}"
                toggleShimmer(this)
            })
            fab.setOnClickListener {
                viewModel.searchProjects = null
                findNavController().navigate(R.id.filtersFragment)
            }
        }

        val filterProjectType = filtersViewModel.getProjectFilterType()
        if(viewModel.searchProjects == null)
            viewModel.updateProjectCount(filterProjectType)

        binding?.apply {
            filterChipsScroll.setVisibleOrGone(filterProjectType != Project.ProjectType.Unknown)
            filtersChips.addView(Chip(context).apply {
                text = filtersViewModel.getProjectFilterType().name
                isClickable = false
                setChipBackgroundColorResource(filterProjectType.getColor())
            })
        }

        lifecycleScope.launch {
            viewModel.searchProjects?.collectLatest {
                searchAdapter.submitData(it)
            }
        }
    }

    override fun setTitleAndRecycler() {
        recyclerView = binding?.searchItemsRecycler
    }

    private fun toggleShimmer(binding: FragmentSearchBinding) {
        binding.apply {
            searchItemsRecycler.setVisibleOrGone(visible = true)
            shimmerViewContainer.setVisibleOrGone(visible = false)
        }
    }
}