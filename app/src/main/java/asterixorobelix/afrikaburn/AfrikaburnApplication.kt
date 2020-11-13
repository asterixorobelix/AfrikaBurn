package asterixorobelix.afrikaburn

import asterixorobelix.afrikaburn.ui.home.homeModule
import asterixorobelix.afrikaburn.ui.project.projectModule
import asterixorobelix.afrikaburn.ui.search.filters.filtersModule
import asterixorobelix.afrikaburn.ui.search.searchModule
import asterixorobelix.afrikaburn.ui.slideshow.slideshowModule
import asterixorobelix.utilities.KoinApplication
import org.koin.core.module.Module

class AfrikaburnApplication : KoinApplication() {
    override val koinModules: List<Module> =
        listOf(afrikaburnModule, homeModule, searchModule, slideshowModule, filtersModule, projectModule)
}