package com.example.gitagyan.screens.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gitagyan.R
import com.example.gitagyan.model.Languages
import com.example.gitagyan.navigation.AppScreens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController){

    val scale = remember {
        Animatable(1f)
    }

    LaunchedEffect(key1 = true, block = {
        scale.animateTo(targetValue = 2f,
            animationSpec = tween(durationMillis = 1000,
                easing = {
                    OvershootInterpolator(2f)
                        .getInterpolation(it)
                })
        )
        delay(1500L)
        navController.navigate(AppScreens.HomeScreen.name)
    })

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color(0xFFFD950E)
    ) {
        Column(modifier = Modifier.scale(scale.value),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Image(painter = painterResource(id = R.drawable.photo3), contentDescription = "sunny icon",
                modifier = Modifier.size(125.dp)
            )
            Text(
                text = if (Languages.selectedLanguage == "English")  "Gita Gyan" else "गीता ज्ञान",
                fontFamily = FontFamily.Cursive,
                fontWeight = FontWeight.ExtraBold
            )
        }
    }
}