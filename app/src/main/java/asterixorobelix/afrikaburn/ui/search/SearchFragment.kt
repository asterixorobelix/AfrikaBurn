package asterixorobelix.afrikaburn.ui.search

import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import asterixorobelix.afrikaburn.R
import asterixorobelix.afrikaburn.databinding.FragmentSearchBinding
import asterixorobelix.utilities.base.BaseViewModelFragment
import asterixorobelix.utilities.ui.obtainStringFromResourceId
import asterixorobelix.utilities.ui.setVisibleOrGone
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class SearchFragment : BaseViewModelFragment<FragmentSearchBinding, SearchViewModel>() {

    private val searchViewModel: SearchViewModel by inject()

    override val layout: Int = R.layout.fragment_search
    override val optionsMenuId: Int? = null
    override val viewModel: SearchViewModel by inject()

    private val searchAdapter = SearchItemAdapter(ProjectComparator())

    override fun loadFragment() {
        binding?.apply {
            recyclerView?.adapter = searchAdapter
            viewModel.numberOfProjects.observe(viewLifecycleOwner, Observer {
                toolbarTitle =
                    "$it ${obtainStringFromResourceId(R.string.projects)}"
                toggleShimmer(this)
            })
            fab.setOnClickListener {
                findNavController().navigate(R.id.filtersFragment)
            }
        }

        lifecycleScope.launch {
            searchViewModel.searchProjects.collectLatest {
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