package asterixorobelix.afrikaburn.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import kotlinx.coroutines.launch

class SearchViewModel(private val searchRepository: SearchRepository) :
    ViewModel() {
    private val projectCount: MutableLiveData<Int> = MutableLiveData()
    val numberOfProjects: LiveData<Int> = projectCount

    init {
        viewModelScope.launch {
            projectCount.postValue(searchRepository.getProjects().count())
        }
    }

    val searchProjects = Pager(
        PagingConfig(pageSize = 20)
    ) {
        SearchPagingSource(searchRepository)
    }.flow
        .cachedIn(viewModelScope)
}