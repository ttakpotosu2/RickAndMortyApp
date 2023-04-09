package com.example.rickandmortyapp.data.dtos.locations_dtos

import com.example.rickandmortyapp.domain.model.LocationResultEntity
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class LocationDto(
    val created: String,
    val dimension: String,
    val id: Int,
    @SerializedName("name") val locationName: String,
    val residents: List<String>,
    val type: String,
    @SerializedName("url")val locationUrl: String
){
    fun toLocationEntity(): LocationResultEntity {
        return LocationResultEntity(
            created, dimension, id, locationName, type, locationUrl
        )
    }
}