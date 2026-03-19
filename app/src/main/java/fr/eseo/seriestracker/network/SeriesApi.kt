package fr.eseo.seriestracker.network

import fr.eseo.seriestracker.model.PopularResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface SeriesApi {
    @GET("most-popular")
    suspend fun getMostPopular(
        @Query("page") page: Int = 1
    ): PopularResponseDto

    companion object {
        const val BASE_URL = "https://www.episodate.com/api/"
    }
}