package fr.eseo.seriestracker.model

import com.google.gson.annotations.SerializedName

data class TvShowDto(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("permalink") val permalink: String,
    @SerializedName("start_date") val startDate: String?,
    @SerializedName("country") val country: String?,
    @SerializedName("network") val network: String?,
    @SerializedName("status") val status: String,
    @SerializedName("image_thumbnail_path") val imageThumbnailPath: String
)