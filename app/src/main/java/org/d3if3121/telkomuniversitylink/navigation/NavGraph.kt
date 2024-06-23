package org.d3if3121.telkomuniversitylink.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import org.d3if3121.telkomuniversitylink.ui.screen.user.CareerPage
import org.d3if3121.telkomuniversitylink.ui.screen.user.ConfirmCareerPage
import org.d3if3121.telkomuniversitylink.ui.screen.user.LandingPage

import org.d3if3121.telkomuniversitylink.ui.screen.user.LoginPage
import org.d3if3121.telkomuniversitylink.ui.screen.user.MenuPage
import org.d3if3121.telkomuniversitylink.ui.screen.user.ProfilePage
import org.d3if3121.telkomuniversitylink.ui.screen.user.RegisterPage
import org.d3if3121.telkomuniversitylink.ui.screen.user.SkillPage

//import org.d3if3121.wordz3.ui.screen.DetailScreen
//import org.d3if3121.wordz3.ui.screen.KEY_ID_CATATAN
//import org.d3if3121.wordz3.ui.screen.MainScreen
//import org.d3if3121.wordz3.ui.screen.QuizScreen2


@Composable
fun SetupNavGraph(navController: NavHostController = rememberNavController()){
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ){
        composable(route = Screen.Login.route){
            LoginPage(navController)
        }

        composable(route = Screen.LandingPage.route){
            LandingPage(navController)
        }

        composable(route = Screen.Register.route){
            RegisterPage(navController)
        }

        composable(route = Screen.MenuPage.route){
            MenuPage(navController)
        }

        composable(route = Screen.ProfilePage.route){
            ProfilePage(navController)
        }

//        composable(
//            route = Screen.FormUbah.route,
//            arguments = listOf(
//                navArgument(KEY_ID_CATATAN){
//                    type = NavType.LongType
//                }
//            )
//        ){ navBackStackEntry ->
//            val id = navBackStackEntry.arguments?.getLong(KEY_ID_CATATAN)
//            DetailScreen(navController, id)
//        }

        composable(route = Screen.CareerPage.route){
            CareerPage(navController)
        }
        composable(route = Screen.SkillPage.route){
            SkillPage(navController)
        }

        composable(route = Screen.ConfirmSkillPage.route){
//            ConfirmSkillPage(navController)
        }
        composable(route = Screen.ConfirmCareerPage.route,
            arguments = listOf(
                navArgument(KEY_ID_PROJECT){
                    type = NavType.IntType
                }
            )
        ){ navBackStackEntry ->
            val id = navBackStackEntry.arguments?.getInt(KEY_ID_PROJECT)
            ConfirmCareerPage(navController, id!!)
        }

        //BottomBar
        composable(route = BottomBarScreen.BottomMenuPage.route){
            MenuPage(navController)
        }
        composable(route = BottomBarScreen.BottomCareerPage.route){
            CareerPage(navController)
        }
        composable(route = BottomBarScreen.BottomSkillPage.route){
            SkillPage(navController)
        }
        composable(route = BottomBarScreen.BottomProfilePage.route){
            ProfilePage(navController)
        }



    }
}