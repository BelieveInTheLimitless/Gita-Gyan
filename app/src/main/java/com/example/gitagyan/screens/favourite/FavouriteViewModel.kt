package com.example.gitagyan.screens.favourite

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gitagyan.model.Favourite
import com.example.gitagyan.repository.GitaDbRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class FavouriteViewModel @Inject constructor(private val repository: GitaDbRepository)
    : ViewModel(){
    private val _favList = MutableStateFlow<List<Favourite>>(emptyList())
    val favList = _favList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO){
            repository.getFavourites().distinctUntilChanged()
                .collect{ listOfFavourites ->
                    if(listOfFavourites.isEmpty()){
                        Log.d("Favourites", ": Favourites list Empty ")
                    }else{
                        _favList.value = listOfFavourites
                    }
                }
        }
    }

    fun insertFavourite(favourite: Favourite) = viewModelScope.launch {
        repository.insertFavourite(favourite)
    }

    fun deleteFavourite(favourite: Favourite) = viewModelScope.launch {
        repository.deleteFavourite(favourite)
    }

}