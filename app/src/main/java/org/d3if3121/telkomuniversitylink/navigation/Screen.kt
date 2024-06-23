package org.d3if3121.telkomuniversitylink.navigation


//import org.d3if3121.wordz3.ui.screen.KEY_ID_CATATAN

const val KEY_ID_PROJECT = "idType"

sealed class Screen(val route: String) {
    data object Login: Screen("loginPage")
    data object LandingPage: Screen("landingPage")
    data object Register: Screen("registerPage")
    data object MenuPage: Screen("menuPage")

//    data object FormUbah: Screen("detailScreen/{$KEY_ID_CATATAN}") {
//        fun withId(id: Long) = "detailScreen/$id"
//    }
    data object CareerPage: Screen("careerPage")
    data object SkillPage: Screen("skillPage")

    data object ProfilePage: Screen("profilePage")

    data object ConfirmCareerPage: Screen("confirmCareerPage/{$KEY_ID_PROJECT}") {
        fun withId(id: Int) = "confirmCareerPage/$id"
    }
    data object ConfirmSkillPage: Screen("confirmSkillPage")
}