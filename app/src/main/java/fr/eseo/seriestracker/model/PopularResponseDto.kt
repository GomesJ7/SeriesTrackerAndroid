package fr.eseo.seriestracker.model

import com.google.gson.annotations.SerializedName

data class PopularResponseDto(
    @SerializedName("total") val total: String,
    @SerializedName("page") val page: Int,
    @SerializedName("pages") val pages: Int,
    @SerializedName("tv_shows") val tvShows: List<TvShowDto>
)