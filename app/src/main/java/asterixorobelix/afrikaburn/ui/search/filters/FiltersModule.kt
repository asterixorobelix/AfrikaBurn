package asterixorobelix.afrikaburn.ui.search.filters

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val filtersModule = module {
    viewModel { FiltersViewModel() }
}