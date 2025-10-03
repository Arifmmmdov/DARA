package org.dara.project.presentation.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun MainScreen() {
    val navController = rememberNavController()
    var selectedTab by remember { mutableStateOf(0) }

    LaunchedEffect(selectedTab, navController) {
        when (selectedTab) {
            0 -> {
                navController.navigate(MainScreenNavGraph.Home) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }

            1 -> {
                navController.navigate(MainScreenNavGraph.Settings) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }

            2 -> {
                navController.navigate(MainScreenNavGraph.Loved) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }

            3 -> {
                navController.navigate(MainScreenNavGraph.Profile) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        }
    }

    MaterialTheme {
        Scaffold(
            bottomBar = {
                BottomNavigationBar(
                    selectedTab = selectedTab,
                    onTabSelected = {
                        selectedTab = it
                    }
                )
            }
        ) {
            NavHost(
                navController = navController,
                startDestination = MainScreenNavGraph.Home
            ) {
                composable<MainScreenNavGraph.Home> {
                    MyText(MainScreenNavGraph.Home.toString())
                }
                composable<MainScreenNavGraph.Settings> {
                    MyText(MainScreenNavGraph.Settings.toString())
                }
                composable<MainScreenNavGraph.Loved> {
                    MyText(MainScreenNavGraph.Loved.toString())
                }
                composable<MainScreenNavGraph.Profile> {
                    MyText(MainScreenNavGraph.Profile.toString())
                }
            }
        }
    }
}

@Composable
fun MyText(text: String){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = text)
    }
}

sealed interface MainScreenNavGraph{
    @Serializable
    data object Home: MainScreenNavGraph
    @Serializable
    data object Settings: MainScreenNavGraph
    @Serializable
    data object Loved: MainScreenNavGraph
    @Serializable
    data object Profile: MainScreenNavGraph
}