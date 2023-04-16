package com.example.gitagyan.screens.save

import android.annotation.SuppressLint
import androidx.compose.animation.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Sort
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.gitagyan.navigation.AppScreens
import com.example.gitagyan.screens.components.bottombar.BottomNavigationBar
import com.example.gitagyan.screens.save.presentation.verses.VersesEvent
import com.example.gitagyan.screens.save.presentation.verses.VersesViewModel
import com.example.gitagyan.screens.save.presentation.verses.components.OrderSection
import com.example.gitagyan.screens.save.presentation.verses.components.VerseItem
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SaveScreen(navController: NavController,
               viewModel: VersesViewModel = hiltViewModel()
){

    val state = viewModel.state.value
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(backgroundColor = Color(0xFFFFFFFF)) {
                Row(modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Gita Gyan",
                        color = Color(0xFF000000),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif,
                        style = MaterialTheme.typography.caption
                    )
                }
            }
        },
        bottomBar = {
            BottomNavigationBar(navController = navController)
        },
        backgroundColor = Color(0xFFFFFFFF)
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)) {
            Row(modifier = Modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Saved Verses",
                    style = MaterialTheme.typography.h4
                )
                IconButton(onClick = {
                    viewModel.onEvent(VersesEvent.ToggleOrderSection)
                }) {
                    Icon(imageVector = Icons.Default.Sort,
                        contentDescription = "Sort")
                }
            }
        }
        AnimatedVisibility(
            visible = state.isOrderSectionVisible,
            enter = fadeIn() + slideInVertically(),
            exit = fadeOut() + slideOutVertically()
        ) {
            OrderSection(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                verseOrder = state.verseOrder,
                onOrderChange = {
                    viewModel.onEvent(VersesEvent.Order(it))
                }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(modifier = Modifier.fillMaxSize()){
            items(state.verses){
                VerseItem(modifier = Modifier
                    .fillMaxWidth()
                    .clickable(onClick = {
                        navController.navigate(route = AppScreens.VerseScreen.name + "/${it.chapterId}" + "/${it.verseId}")
                    }),
                    verse = it,
                    onDeleteClick = {
                        viewModel.onEvent(VersesEvent.DeleteVerse(it))
                        scope.launch {
                            val result = scaffoldState.snackbarHostState.showSnackbar(
                                message = "Verse deleted",
                                actionLabel = "Undo"
                            )
                            if (result == SnackbarResult.ActionPerformed){
                                viewModel.onEvent(VersesEvent.RestoreVerse)
                            }
                        }
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}