package com.example.gitagyan.screens.profile

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gitagyan.model.Language
import com.example.gitagyan.repository.GitaDbRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LanguageViewModel @Inject constructor(
    private val repository: GitaDbRepository
): ViewModel() {

    private val _languageList = MutableStateFlow<List<Language>>(emptyList())
    val languageList = _languageList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getLanguages().distinctUntilChanged().collect { listOfLanguages ->
                if (listOfLanguages.isEmpty()) {
                    Log.d("Languages", "Languages List Empty")
                } else {
                    _languageList.value = listOfLanguages
                }
            }
        }
    }

    fun insertLanguage(language: Language) =
        viewModelScope.launch { repository.insertLanguage(language) }

    fun updateLanguage(language: Language) =
        viewModelScope.launch { repository.updateLanguage(language) }

    fun deleteLanguage(language: Language) =
        viewModelScope.launch { repository.deleteLanguage(language) }

    fun deleteAllLanguages() = viewModelScope.launch { repository.deleteAllLanguages() }

}
