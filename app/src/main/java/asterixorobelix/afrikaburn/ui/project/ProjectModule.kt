package asterixorobelix.afrikaburn.ui.project

import asterixorobelix.afrikaburn.AfrikaburnRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val projectModule = module {
    viewModel { ProjectViewModel(get<ProjectRepository>()) }
    single { ProjectRepository(get<AfrikaburnRepository>()) }
}