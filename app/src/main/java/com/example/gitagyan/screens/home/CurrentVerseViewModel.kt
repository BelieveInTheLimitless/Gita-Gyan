package com.example.gitagyan.screens.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gitagyan.model.CurrentVerse
import com.example.gitagyan.repository.GitaDbRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrentVerseViewModel @Inject constructor(
    private val repository: GitaDbRepository
): ViewModel() {

    private val _currentVerseList = MutableStateFlow<List<CurrentVerse>>(emptyList())
    val currentVerseList = _currentVerseList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getCurrentVerse().distinctUntilChanged().collect{ listOfCurrentVerses ->
                if(listOfCurrentVerses.isEmpty()){
                    Log.d("Current Verse", ": Empty")
                }
                else{
                    _currentVerseList .value= listOfCurrentVerses
                }
            }
        }
    }

    fun insertCurrentVerse(currentVerse: CurrentVerse) = viewModelScope.launch {
        repository.insertCurrentVerse(currentVerse)
    }

    fun updateCurrentVerse(currentVerse: CurrentVerse) = viewModelScope.launch {
        repository.updateCurrentVerse(currentVerse)
    }

    fun  deleteCurrentVerse(currentVerse: CurrentVerse) = viewModelScope.launch {
        repository.deleteCurrentVerse(currentVerse)
    }

    fun deleteAllCurrentVerses() = viewModelScope.launch {
        repository.deleteAllCurrentVerses()
    }
}