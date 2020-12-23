package asterixorobelix.afrikaburn.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import asterixorobelix.afrikaburn.models.Project
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class SearchViewModel(private val searchRepository: SearchRepository) :
    ViewModel() {
    private val projectCount: MutableLiveData<Int> = MutableLiveData()
    val numberOfProjects: LiveData<Int> = projectCount

    init {
        viewModelScope.launch {

        }
    }

    fun updateProjectCount(projectType: Project.ProjectType) {
        viewModelScope.launch {
            if (projectType != Project.ProjectType.Unknown) {
                projectCount.postValue(searchRepository.getProjectsByType(projectType).count())
                searchProjects = Pager(
                    PagingConfig(pageSize = 20)
                ) {
                    SearchFilteredPagingSource(searchRepository, projectType)
                }.flow
                    .cachedIn(viewModelScope)
            }
            else{
                projectCount.postValue(searchRepository.getProjects().count())
                searchProjects = Pager(
                    PagingConfig(pageSize = 20)
                ) {
                    SearchPagingSource(searchRepository)
                }.flow
                    .cachedIn(viewModelScope)
            }
        }
    }

    var searchProjects: Flow<PagingData<Project>>? = null
}