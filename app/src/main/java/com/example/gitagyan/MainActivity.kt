package com.example.gitagyan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.gitagyan.navigation.AppNavigation
import com.example.gitagyan.ui.theme.GitaGyanTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GitaGyanTheme {
                AppNavigation()
            }
        }
    }
}
