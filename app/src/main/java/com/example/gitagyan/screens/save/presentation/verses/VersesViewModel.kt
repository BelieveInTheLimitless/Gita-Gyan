package com.example.gitagyan.screens.save.presentation.verses

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gitagyan.database.domain.model.Verse
import com.example.gitagyan.database.domain.use_case.VerseUseCases
import com.example.gitagyan.database.domain.util.OrderType
import com.example.gitagyan.database.domain.util.VerseOrder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class VersesViewModel @Inject constructor(
    private val verseUseCases: VerseUseCases
) : ViewModel(){

    private val _state = mutableStateOf(VersesState())
    val state: State<VersesState> = _state

    private var recentlyDeletedVerse: Verse? = null

    private var getVersesJob: Job? = null

    init {
        getVerses(VerseOrder.Date(OrderType.Descending))
    }

    fun onEvent(event: VersesEvent){
        when(event){
            is VersesEvent.Order -> {
                if (state.value.verseOrder::class == event.verseOrder::class &&
                    state.value.verseOrder.orderType == event.verseOrder.orderType){
                    return
                }
                getVerses(event.verseOrder)
            }
            is VersesEvent.DeleteVerse -> {
                viewModelScope.launch {
                    verseUseCases.deleteVerse(event.verse)
                    recentlyDeletedVerse = event.verse
                }
            }
            is VersesEvent.RestoreVerse -> {
                viewModelScope.launch {
                    verseUseCases.addVerse(recentlyDeletedVerse ?: return@launch)
                    recentlyDeletedVerse = null
                }
            }
            is VersesEvent.ToggleOrderSection -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }
        }
    }

    private fun getVerses(verseOrder: VerseOrder){
        getVersesJob?.cancel()
        getVersesJob = verseUseCases.getVerses(verseOrder)
            .onEach { verses ->
                _state.value = state.value.copy(
                    verses = verses,
                    verseOrder = verseOrder)
            }.launchIn(viewModelScope)
    }
}