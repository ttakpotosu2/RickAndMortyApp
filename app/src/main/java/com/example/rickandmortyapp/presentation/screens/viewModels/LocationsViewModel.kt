package com.example.rickandmortyapp.presentation.screens.viewModels

import androidx.lifecycle.ViewModel
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.rickandmortyapp.data.local.LocationsResultsDatabase
import com.example.rickandmortyapp.domain.model.LocationResultEntity
import com.example.rickandmortyapp.data.paging.LocationsRemoteMediator
import com.example.rickandmortyapp.data.remote.RickAndMortyApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
@HiltViewModel
class LocationsViewModel @Inject constructor(
    rickAndMortyApi: RickAndMortyApi,
    private val locationsResultsDatabase: LocationsResultsDatabase
): ViewModel(){
    private val pagingSourceFactory = {
        locationsResultsDatabase.locationsResultDao().getLocations()
    }

    val getAllLocations: Flow<PagingData<LocationResultEntity>> = Pager(
        config = PagingConfig(
            pageSize = 50
        ),
        remoteMediator = LocationsRemoteMediator(
            rickAndMortyApi = rickAndMortyApi,
            locationsResultsDatabase = locationsResultsDatabase
        ),
        pagingSourceFactory = pagingSourceFactory
    ).flow
}