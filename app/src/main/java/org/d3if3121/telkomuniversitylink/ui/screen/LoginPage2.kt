//package org.d3if3121.telkomuniversitylink.ui.screen
//
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.material3.TopAppBar
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.tooling.preview.Preview
//import org.d3if3121.telkomuniversitylink.ui.theme.TelkomUniversityLinkTheme
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    CobaLoginPage()
//}
//
//@Composable
//fun CobaLoginPage() {
//    LoginPage { modifier ->
//        Text(
//            text = "Hehe",
//            modifier = modifier
//        )
//    }
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun LoginPage(content: @Composable (Modifier) -> Unit) {
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = {
//                    Text(text = "helow")
//                }
//            )
//        },
//        modifier = Modifier.fillMaxWidth()
//    )
//    { padding ->
//        content(Modifier.padding(padding))
//    }
//}
//@Composable
//fun Content(modifier: Modifier){
//
//
//}