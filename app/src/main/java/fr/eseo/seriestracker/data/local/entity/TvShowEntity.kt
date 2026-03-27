package fr.eseo.seriestracker.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import fr.eseo.seriestracker.model.TvShow

@Entity(tableName = "tv_shows")
data class TvShowEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val network: String,
    val country: String,
    val status: String,
    val imageUrl: String
)

fun TvShowEntity.toDomain(): TvShow = TvShow(
    id = id,
    name = name,
    network = network,
    country = country,
    status = status,
    imageUrl = imageUrl
)

fun TvShow.toEntity(): TvShowEntity = TvShowEntity(
    id = id,
    name = name,
    network = network,
    country = country,
    status = status,
    imageUrl = imageUrl
)
