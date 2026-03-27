package fr.eseo.seriestracker.repository

import fr.eseo.seriestracker.model.TvShow
import kotlinx.coroutines.flow.Flow

interface SeriesRepository {
    fun observePopulaires(): Flow<List<TvShow>>
    suspend fun refreshPopulaires(): Result<Unit>
}
