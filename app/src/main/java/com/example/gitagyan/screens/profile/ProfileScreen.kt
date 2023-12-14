package com.example.gitagyan.screens.profile

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.ListItemDefaults.containerColor
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.gitagyan.R
import com.example.gitagyan.model.Language
import com.example.gitagyan.model.Languages
import com.example.gitagyan.screens.components.topbar.TopBottomBar

@Composable
fun ProfileScreen(navController: NavController){
    TopBottomBar(navController = navController)
    Box(modifier = Modifier.padding(top = 60.dp, bottom = 60.dp)) {
        Profile()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profile(languageViewModel: LanguageViewModel = hiltViewModel()){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFFD950E)
    ) {
        Surface(
            modifier = Modifier
                .padding(start = 15.dp, top = 15.dp, end = 15.dp, bottom = 15.dp)
                .width(1000.dp)
                .height(500.dp),
            shape = RoundedCornerShape(corner = CornerSize(40.dp)),
            color = Color.White,
            contentColor = Color.Black
        ) {
            Row(
                Modifier.padding(top = 45.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Box {
                    Column(
                        modifier = Modifier.padding(10.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.krishna_arjuna),
                            contentDescription = null,
                            contentScale = ContentScale.FillBounds
                        )

                        val context = LocalContext.current
                        val languages = arrayOf("English", "हिंदी")
                        var expanded by remember { mutableStateOf(false) }
                        val selectionLanguage = if (Languages.selectedLanguage == "English") "Select a language" else "भाषा चुनें"

                        Text(
                            text = selectionLanguage,
                            modifier = Modifier.padding(top = 10.dp, bottom = 10.dp),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Medium,
                            fontFamily = FontFamily.Serif,
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
                                modifier = Modifier.menuAnchor(),
                                readOnly = true,
                                trailingIcon = {
                                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                                },
                                colors = TextFieldDefaults.colors(
                                    focusedContainerColor = containerColor,
                                    unfocusedContainerColor = containerColor,
                                    disabledContainerColor = containerColor,
                                )
                            )

                            ExposedDropdownMenu(
                                expanded = expanded,
                                onDismissRequest = { expanded = false },
                                modifier = Modifier
                                    .background(
                                        Color(0xFFFFFFFF)
                                    )
                            ) {
                                languages.forEach { item ->
                                    DropdownMenuItem(
                                        text = { Text(text = item, color = Color.Black, fontSize = 15.sp) },
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
                                modifier = Modifier.padding(5.dp),
                                fontSize = 20.sp,
                                style = MaterialTheme.typography.titleMedium,
                                textAlign = TextAlign.Center)
                            Text(
                                text = if (Languages.selectedLanguage == "English") TheGreatnessOfTheGIta.englishContent else TheGreatnessOfTheGIta.hindiContent,
                                modifier = Modifier.padding(5.dp),
                                fontSize = 15.sp,
                                style = androidx.compose.material.MaterialTheme.typography.caption,
                                textAlign = TextAlign.Justify
                            )
                        }
                    }
                }
            }
        }
    }
}