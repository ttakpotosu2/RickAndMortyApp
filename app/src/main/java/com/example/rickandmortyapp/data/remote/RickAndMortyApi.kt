package com.example.rickandmortyapp.data.remote

import com.example.rickandmortyapp.data.PagedData
import com.example.rickandmortyapp.data.dtos.characters_dtos.CharacterDto
import com.example.rickandmortyapp.data.dtos.episoes_dtos.EpisodeDto
import com.example.rickandmortyapp.data.dtos.locations_dtos.LocationDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyApi {

    @GET("character/")
    suspend fun getAllCharacters(@Query("page") page: String): PagedData<CharacterDto>

    @GET("character/{characterId}")
    suspend fun getCharacterById(@Path("characterId") characterId: String): CharacterDto

    @GET("location")
    suspend fun getAllLocations(): PagedData<LocationDto>

    @GET("location/{locationId}")
    suspend fun getLocationById(@Path("locationId") locationId: String): LocationDto

    @GET("episode")
    suspend fun getAllEpisodes(): PagedData<EpisodeDto>

    @GET("episode/{episodeId}")
    suspend fun getEpisodeById(@Path("episodeId") episodeId: String): EpisodeDto

    @GET("episode/{episode}")
    suspend fun getMultipleEpisodes(@Path("episode") episode: String): List<EpisodeDto>
}