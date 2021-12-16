package ru.spbstu_software_design_project.rickandmorty.data.source

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.spbstu_software_design_project.rickandmorty.domain.model.RickAndMortyResult

interface SafeCallDataSource {
    suspend fun <T> safeApiCal(
        apiCall: suspend () -> T
    ) : RickAndMortyResult<T> {
        return withContext(Dispatchers.IO) {
            try {
                RickAndMortyResult.Success(apiCall.invoke())
            } catch (e: Throwable) {
                RickAndMortyResult.Error(e.toString())
            }
        }
    }

}

