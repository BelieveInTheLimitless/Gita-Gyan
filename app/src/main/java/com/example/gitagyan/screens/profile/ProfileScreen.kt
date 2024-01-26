package com.example.gitagyan.screens.profile

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gitagyan.R
import com.example.gitagyan.model.Language
import com.example.gitagyan.model.Languages
import com.example.gitagyan.screens.components.TopBar

@Composable
fun ProfileNavHost(rootNavController: NavController) {

    val profileNavController = rememberNavController()

    Scaffold(
        topBar = {
            TopBar {
                rootNavController.popBackStack()
            }
        },
        containerColor = Color(0xFFFD950E)
    ) {
        NavHost(navController = profileNavController,
            startDestination = "profileContent",
            modifier = Modifier.padding(it)
        ) {
            composable("profileContent") {
                Profile()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profile(languageViewModel: LanguageViewModel = hiltViewModel()){
    Column(modifier = Modifier
        .padding(15.dp)
        .fillMaxSize()
        .background(
            color = Color.White,
            shape = RoundedCornerShape(corner = CornerSize(40.dp))
        ),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Column(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.main_icon),
                contentDescription = "Main Image",
                modifier = Modifier
                    .padding(top = 50.dp, start = 50.dp, end = 50.dp)
                    .aspectRatio(640.dp / 640.dp),
                contentScale = ContentScale.FillWidth
            )

            val context = LocalContext.current
            val languages = arrayOf("English", "हिंदी")
            var expanded by remember { mutableStateOf(false) }
            val selectionLanguage = if (Languages.selectedLanguage == "English") "Selected language" else "भाषा चुनें"

            Text(
                text = selectionLanguage,
                modifier = Modifier.padding(10.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily.Default,
                style = MaterialTheme.typography.titleMedium
            )

            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = {
                    expanded = !expanded
                }
            ) {
                OutlinedTextField(
                    value = Languages.selectedLanguage,
                    onValueChange = {
                        Languages.selectedLanguage = it
                    },
                    modifier = Modifier
                        .menuAnchor(),
                    readOnly = true,
                    textStyle = TextStyle(color = Color.White, fontSize = 15.sp),
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                    },
                    shape = RoundedCornerShape(size = 15.dp),
                    colors = ExposedDropdownMenuDefaults
                        .outlinedTextFieldColors(focusedTextColor = Color.White, unfocusedTextColor = Color.White,
                            focusedContainerColor = Color(0xFFFD950E), unfocusedContainerColor = Color(0xFFFD950E),
                            focusedBorderColor = Color.White, unfocusedBorderColor = Color.White,
                            focusedTrailingIconColor = Color.White, unfocusedTrailingIconColor = Color.White,

                        )
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier
                        .background(
                            Color(0xFFFD950E)
                        )
                ) {
                    languages.forEach { item ->
                        DropdownMenuItem(
                            text = { Text(text = item, color = Color.White, fontSize = 15.sp) },
                            onClick = {
                                Languages.selectedLanguage = item
                                expanded = false

                                languageViewModel.deleteAllLanguages()
                                languageViewModel.insertLanguage(Language(language = item))

                                Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                            }
                        )
                    }
                }
            }

            Divider(modifier = Modifier.padding(15.dp),
                color = Color.LightGray)

            Column(modifier = Modifier
                .padding(5.dp)
                .verticalScroll(state = ScrollState(0)),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = if(Languages.selectedLanguage == "English") TheGreatnessOfTheGIta.englishTitle else TheGreatnessOfTheGIta.hindiTitle,
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center)
                Text(
                    text = if (Languages.selectedLanguage == "English") TheGreatnessOfTheGIta.englishContent else TheGreatnessOfTheGIta.hindiContent,
                    modifier = Modifier.padding(5.dp),
                    fontSize = 15.sp,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Justify
                )
            }
        }
    }
}