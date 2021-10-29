package ru.spbstu_software_design_project.rickandmorty.data.remote.source

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import ru.spbstu_software_design_project.rickandmorty.data.remote.api.RickAndMortyApiService
import ru.spbstu_software_design_project.rickandmorty.data.remote.model.toCharactersList
import ru.spbstu_software_design_project.rickandmorty.domain.model.Character
import ru.spbstu_software_design_project.rickandmorty.domain.repository.CharactersRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterPagingSource @Inject constructor(
    private val service: RickAndMortyApiService
) : PagingSource<Int, Character>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        val pageNumber = params.key ?: 1
        return try {
            val response = service.getCharacters(pageNumber)
            val pagedResponse = response.body()

            var nextPageNumber: Int? = null

            if (pagedResponse?.info?.next != null) {
                val uri = Uri.parse(pagedResponse.info.next)
                val nextPageQuery = uri.getQueryParameter("page")
                nextPageNumber = nextPageQuery?.toInt()
            }

            LoadResult.Page(
                data = pagedResponse?.toCharactersList().orEmpty(),
                prevKey = null,
                nextKey = nextPageNumber
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Character>): Int? = null


}