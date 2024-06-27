package org.d3if3121.telkomuniversitylink.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import org.d3if3121.telkomuniversitylink.ui.screen.user.CareerPage
import org.d3if3121.telkomuniversitylink.ui.screen.user.ConfirmCareerPage
import org.d3if3121.telkomuniversitylink.ui.screen.user.LoginPage
import org.d3if3121.telkomuniversitylink.ui.screen.user.MenuPage
import org.d3if3121.telkomuniversitylink.ui.screen.user.ProfilePage
import org.d3if3121.telkomuniversitylink.ui.screen.user.RegisterPage
import org.d3if3121.telkomuniversitylink.ui.screen.user.SkillPage
import org.d3if3121.telkomuniversitylink.viewmodel.ContentViewModel
import org.d3if3121.telkomuniversitylink.viewmodel.ProfileViewModel
import org.d3if3121.telkomuniversitylink.viewmodel.UserViewModel

//import org.d3if3121.wordz3.ui.screen.DetailScreen
//import org.d3if3121.wordz3.ui.screen.KEY_ID_CATATAN
//import org.d3if3121.wordz3.ui.screen.MainScreen
//import org.d3if3121.wordz3.ui.screen.QuizScreen2


@Composable
fun SetupNavGraph(navController: NavHostController = rememberNavController()){

    val viewModel: UserViewModel = viewModel()
    val viewModelContent: ContentViewModel = viewModel()
    val viewModelProfile: ProfileViewModel = viewModel()


    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ){
        composable(route = Screen.Login.route){
            LoginPage(navController, viewModel)
        }

        composable(route = Screen.Register.route){
            RegisterPage(navController, viewModel)
        }

        composable(route = Screen.MenuPage.route){
            MenuPage(navController, viewModel)
        }

        composable(route = Screen.ProfilePage.route){
            ProfilePage(navController, viewModelProfile, viewModel)
        }

        composable(route = Screen.CareerPage.route){
            CareerPage(navController, )
        }
        composable(route = Screen.SkillPage.route){
            SkillPage(navController, viewModelContent)
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
            ConfirmCareerPage(navController, id.toString()!!, )
        }

        //BottomBar
        composable(route = BottomBarScreen.BottomMenuPage.route){
            MenuPage(navController, viewModel)
        }
        composable(route = BottomBarScreen.BottomCareerPage.route){
            CareerPage(navController)
        }
        composable(route = BottomBarScreen.BottomSkillPage.route){
            SkillPage(navController, viewModelContent)
        }
        composable(route = BottomBarScreen.BottomProfilePage.route){
            ProfilePage(navController, viewModelProfile, viewModel)
        }



    }
}