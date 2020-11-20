package asterixorobelix.afrikaburn.ui.project

import asterixorobelix.afrikaburn.AfrikaburnRepository
import asterixorobelix.afrikaburn.database.ProjectDao
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val projectModule = module {
    viewModel { ProjectViewModel(get<ProjectRepository>(), get<ProjectDao>()) }
    single { ProjectRepository(get<AfrikaburnRepository>()) }
}