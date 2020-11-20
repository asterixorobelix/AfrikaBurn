package asterixorobelix.afrikaburn.ui.project

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import asterixorobelix.afrikaburn.database.ProjectDao
import asterixorobelix.afrikaburn.models.DatabaseProject
import asterixorobelix.afrikaburn.models.Project
import asterixorobelix.afrikaburn.models.ProjectNavigationArguments
import asterixorobelix.utilities.base.BaseBusyIndicatorViewModel
import kotlinx.coroutines.launch

class ProjectViewModel(
    private val projectRepository: ProjectRepository,
    private val projectDao: ProjectDao
) :
    BaseBusyIndicatorViewModel() {
    private val projectData: MutableLiveData<Project> = MutableLiveData()
    val project: LiveData<Project> = projectData
    fun setNavArgs(projectNavigationArguments: ProjectNavigationArguments?) {
        projectNavigationArguments?.let {
            viewModelScope.launch {
                projectData.value = projectRepository.getProject(it.projectId, it.projectType)
            }
        }
    }
}
