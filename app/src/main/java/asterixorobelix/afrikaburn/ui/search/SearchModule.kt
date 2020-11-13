package asterixorobelix.afrikaburn.ui.search

import asterixorobelix.afrikaburn.AfrikaburnRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val searchModule = module {
    viewModel { SearchViewModel(get<SearchRepository>()) }
    single { SearchRepository(get<AfrikaburnRepository>()) }
}
