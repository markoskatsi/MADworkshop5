package com.example.madworkshop5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.example.madworkshop5.ui.theme.MADworkshop5Theme
import com.example.nv1.Screens.FirstScreenShow
import com.example.nv1.Screens.SecondScreenShow
import com.example.nv1.Screens.ThirdScreenShow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MADworkshop5Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NVDisplay(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun NVDisplay(modifier: Modifier = Modifier) {
    // Initialize the backstack with the Home object
    val backStack = remember { mutableStateListOf<Any>(NavObjects.Home) }

    // Logic to clear the stack and return to the starting screen
    fun goHome() {
        backStack.clear()
        backStack.add(NavObjects.Home)
    }

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { key ->
            when (key) {
                is NavObjects.Home -> NavEntry(key) {
                    HomeScreenShow(
                        modifier = modifier,
                        onOpenFirstScreen = { backStack.add(NavObjects.FirstScreen) },
                        onOpenSecondScreen = { backStack.add(NavObjects.SecondScreen) },
                        onOpenThirdScreen = { backStack.add(NavObjects.ThirdScreen) }
                    )
                }

                is NavObjects.FirstScreen -> NavEntry(key) {
                    FirstScreenShow(
                        modifier = modifier,
                        onBackToHome = ::goHome,
                        onUp = { backStack.removeLastOrNull() }
                    )
                }

                is NavObjects.SecondScreen -> NavEntry(key) {
                    SecondScreenShow(
                        modifier = modifier,
                        onBackToHome = ::goHome,
                        onUp = { backStack.removeLastOrNull() }
                    )
                }

                is NavObjects.ThirdScreen -> NavEntry(key) {
                    ThirdScreenShow(
                        modifier = modifier,
                        onBackToHome = ::goHome,
                        onUp = { backStack.removeLastOrNull() }
                    )
                }

                else -> error("Unknown route: $key")
            }
        }
    )
}
