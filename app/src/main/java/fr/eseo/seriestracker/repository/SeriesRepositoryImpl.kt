package fr.eseo.seriestracker.repository

import fr.eseo.seriestracker.data.PreferencesManager
import fr.eseo.seriestracker.data.local.dao.TvShowDao
import fr.eseo.seriestracker.data.local.entity.toDomain
import fr.eseo.seriestracker.data.local.entity.toEntity
import fr.eseo.seriestracker.model.TvShow
import fr.eseo.seriestracker.model.toDomain
import fr.eseo.seriestracker.network.SeriesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SeriesRepositoryImpl @Inject constructor(
    private val seriesApi: SeriesApi,
    private val tvShowDao: TvShowDao,
    private val preferencesManager: PreferencesManager
) : SeriesRepository {

    override fun observePopulaires(): Flow<List<TvShow>> {
        return tvShowDao.getAllShows().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override suspend fun refreshPopulaires(): Result<Unit> {
        return try {
            val shows = seriesApi.getMostPopular().tvShows.map { it.toDomain() }
            tvShowDao.deleteAll()
            tvShowDao.insertAll(shows.map { it.toEntity() })
            preferencesManager.saveLastRefreshTimestamp(System.currentTimeMillis())
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
