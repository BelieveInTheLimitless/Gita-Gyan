package com.example.gitagyan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gitagyan.model.Languages
import com.example.gitagyan.screens.profile.LanguageViewModel
import com.example.gitagyan.screens.splash.SplashNavHost
import com.example.gitagyan.ui.theme.GitaGyanTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GitaGyanTheme {
                GitaGyanApplication()
            }
        }
    }
}

@Composable
fun GitaGyanApplication(languageViewModel: LanguageViewModel = hiltViewModel()){

    val language = languageViewModel.languageList.collectAsState().value

    if (language.isNotEmpty()){
        Languages.selectedLanguage = language[0].language
    }

    SplashNavHost()
}
