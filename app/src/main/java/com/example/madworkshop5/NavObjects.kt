package com.example.madworkshop5
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.serialization.NavKeySerializer
import kotlinx.serialization.Serializable


sealed interface NavObjects: NavKey {
    @Serializable
    data object Home : NavObjects, NavKey

    @Serializable
    data object FirstScreen : NavObjects, NavKey

    @Serializable
    data object SecondScreen : NavObjects, NavKey

    @Serializable
    data object ThirdScreen : NavObjects, NavKey

}