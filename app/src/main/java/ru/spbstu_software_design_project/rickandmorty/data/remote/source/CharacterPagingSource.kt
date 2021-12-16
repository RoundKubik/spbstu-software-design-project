package ru.spbstu_software_design_project.rickandmorty.data.remote.source

import android.net.Uri
import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import ru.spbstu_software_design_project.rickandmorty.BuildConfig
import ru.spbstu_software_design_project.rickandmorty.data.remote.api.RickAndMortyApiService
import ru.spbstu_software_design_project.rickandmorty.data.remote.model.toCharactersList
import ru.spbstu_software_design_project.rickandmorty.data.remote.model.toListCharacters
import ru.spbstu_software_design_project.rickandmorty.data.source.FavouriteCharactersDataSource
import ru.spbstu_software_design_project.rickandmorty.domain.model.Character
import ru.spbstu_software_design_project.rickandmorty.domain.repository.CharactersRepository
import ru.spbstu_software_design_project.rickandmorty.utill.setLikes
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterPagingSource @Inject constructor(
    private val service: RickAndMortyApiService,
    private val favouriteCharactersDataSource: FavouriteCharactersDataSource
) : PagingSource<Int, Character>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        val pageNumber = params.key ?: 1
        return try {
            val response = service.getCharacters(pageNumber)

            var nextPageNumber: Int? = null

            if (response.info.next != null) {
                val uri = Uri.parse(response.info.next)
                val nextPageQuery = uri.getQueryParameter("page")
                nextPageNumber = nextPageQuery?.toInt()
            }
            val favouriteCharacters = favouriteCharactersDataSource.getFavouriteCharacters()
            LoadResult.Page(
                data = response.results.toListCharacters().apply {
                    setLikes(favouriteCharacters)
                },
                prevKey = null,
                nextKey = nextPageNumber
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Character>): Int? = null
}