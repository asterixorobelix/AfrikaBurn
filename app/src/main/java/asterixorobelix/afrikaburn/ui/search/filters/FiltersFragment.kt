package asterixorobelix.afrikaburn.ui.search.filters

import asterixorobelix.afrikaburn.R
import asterixorobelix.afrikaburn.databinding.FiltersFragmentBinding
import asterixorobelix.utilities.base.BaseViewModelFragment
import asterixorobelix.utilities.ui.obtainStringFromResourceId
import org.koin.android.ext.android.inject

class FiltersFragment : BaseViewModelFragment<FiltersFragmentBinding, FiltersViewModel>() {
    override val layout: Int = R.layout.filters_fragment
    override val viewModel: FiltersViewModel by inject()
    override val optionsMenuId: Int? = null

    override fun loadFragment() {
        setTitleAndRecycler()
        binding?.apply {

        }

        viewModel.apply {

        }
    }

    override fun setTitleAndRecycler() {
        toolbarTitle = obtainStringFromResourceId(R.string.filters)
    }
}
