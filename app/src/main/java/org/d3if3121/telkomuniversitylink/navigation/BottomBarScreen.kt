package org.d3if3121.telkomuniversitylink.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen (
    val route: String,
    val title: String,
    val icon: ImageVector,
){
    object BottomMenuPage : BottomBarScreen(
        route = "menuPage",
        title = "Menu",
        icon = Icons.Default.Home
    )
    object BottomProfilePage : BottomBarScreen(
        route = "profilePage",
        title = "Profile",
        icon = Icons.Default.Person
    )
    object BottomSkillPage : BottomBarScreen(
        route = "skillPage",
        title = "Skill",
        icon = Icons.Default.Build
    )
    object BottomCareerPage : BottomBarScreen(
        route = "careerPage",
        title = "Career",
        icon = Icons.Default.Star
    )
}