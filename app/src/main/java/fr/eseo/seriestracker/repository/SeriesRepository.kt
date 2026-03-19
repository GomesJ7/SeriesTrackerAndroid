package fr.eseo.seriestracker.repository

import fr.eseo.seriestracker.model.TvShow
import fr.eseo.seriestracker.model.toDomain
import fr.eseo.seriestracker.network.SeriesApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SeriesRepository @Inject constructor(
    private val seriesApi: SeriesApi
) {
    suspend fun getPopulaires(): List<TvShow> {
        return seriesApi.getMostPopular().tvShows.map { it.toDomain() }
    }
}