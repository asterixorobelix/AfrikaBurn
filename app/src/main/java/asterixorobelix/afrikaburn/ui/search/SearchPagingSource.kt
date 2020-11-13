package asterixorobelix.afrikaburn.ui.search

import androidx.paging.PagingSource
import asterixorobelix.afrikaburn.models.Project

class SearchPagingSource(
    private val searchRepository: SearchRepository
) : PagingSource<Int, Project>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Project> {
        val startingIndex = params.key ?: 0
        return LoadResult.Page(
            data = searchRepository.getProjects(
                startingIndex,
                startingIndex + 1
            ), prevKey = null, nextKey = startingIndex + 1
        )
    }
}