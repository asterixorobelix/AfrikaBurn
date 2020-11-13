package asterixorobelix.afrikaburn.ui.slideshow

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val slideshowModule = module {
    viewModel { SlideshowViewModel() }
}