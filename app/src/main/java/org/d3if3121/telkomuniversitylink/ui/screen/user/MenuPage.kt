package org.d3if3121.telkomuniversitylink.ui.screen.user


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import org.d3if3121.telkomuniversitylink.navigation.BottomBarScreen
import org.d3if3121.telkomuniversitylink.R
import org.d3if3121.telkomuniversitylink.ui.theme.Warna



@Preview(showBackground = true)
@Composable
fun MenuPreview() {
    CobaMenuPage()
}

@Composable
fun CobaMenuPage() {
    MenuPage(rememberNavController())
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuPage(navController: NavHostController){


    Scaffold (
        topBar = {
            Column(){
                TopAppBar(
                    navigationIcon = {

                    },
                    title = {
                        Row(
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo),
                                contentDescription = "App logo",
                                modifier = Modifier
                                    .size(60.dp)
                                    .padding(10.dp)
                            )

                            Text(
                                color = Warna.PutihNormal,
                                fontWeight = FontWeight.Bold,
                                text = stringResource(id = R.string.welcome)
                            )
                        }

                    },
                    colors = TopAppBarDefaults.mediumTopAppBarColors(
                        containerColor = Warna.MerahNormal,
                        titleContentColor = Warna.PutihNormal
                    ),
                )

                Box(
                    modifier = Modifier
                        .background(
                            color = Warna.AbuNormal
                        )
                        .fillMaxWidth()
                        .size(5.dp)
                        .padding(0.dp)


                )
            }



        },
        bottomBar = {
            BottomBar(navController = navController)
        },


    ){ topbarpadding ->
        Menu(topbarpadding)
    }
}

@Composable
fun Menu(
    topbarpadding :  PaddingValues
){

    //MainColumn
    Column(
        modifier = Modifier
            .padding(topbarpadding)
            .verticalScroll(rememberScrollState())

    ){

        //ImageColumn
        Row (
            modifier = Modifier
                .fillMaxWidth()

        ){
            Image(
                painter = painterResource(id = R.drawable.mentor_2),
                contentDescription = "App logo",
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ){
            RedBubble(size = 160) {
                Text(
                    color = Warna.PutihNormal,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    text = stringResource(id = R.string.recenty)
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp)
        ){
            SlideCard()
        }




        Spacer(modifier = Modifier.height(40.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
        ) {
            RedBubble(size = 300) {
                Text(
                    color = Warna.PutihNormal,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    text = stringResource(id = R.string.why)
                )
            }
        }

        PictureWithText()


        Spacer(modifier = Modifier.height(40.dp))

        GrayBox(height = 280) {
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ){

                Text(
                    color = Warna.MerahNormal,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    text = stringResource(id = R.string.facts),
                    textAlign = TextAlign.Center
                )
                Row(){
                    Box(
                        modifier = Modifier
                            .height(90.dp)
                            .width(155.dp),
                        contentAlignment = Alignment.Center
                    ){
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        )
                        {
                            Text(
                                color = Warna.MerahTua,
                                fontSize = 27.sp,
                                fontWeight = FontWeight.ExtraBold,
                                text = "34052",
                                textAlign = TextAlign.Center
                            )
                            Text(
                                color = Warna.MerahTua,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                text = "Student",
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                    Box(
                        modifier = Modifier
                            .height(90.dp)
                            .width(155.dp),
                        contentAlignment = Alignment.Center
                    ){
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        )
                        {
                            Text(
                                color = Warna.MerahTua,
                                fontSize = 27.sp,
                                fontWeight = FontWeight.ExtraBold,
                                text = "65355",
                                textAlign = TextAlign.Center
                            )
                            Text(
                                color = Warna.MerahTua,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                text = "Alumni",
                                textAlign = TextAlign.Center
                            )
                        }
                    }

                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    color = Warna.HitamNormal,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Normal,
                    text = "Universitas Telkom atau Telkom University (Tel-U) adalah sebuah perguruan tinggi swasta milik BUMN yang terletak di Bandung, Jawa Barat. Berdiri pada 14 Agustus 2013, Tel-U merupakan salah satu perguruan tinggi swasta yang pertama meraih akreditasi Unggul oleh BAN-PT serta merupakan salah satu Perguruan Tinggi Terbaik di Indonesia.",
                    textAlign = TextAlign.Justify
                )

            }
        }

        Spacer(modifier = Modifier.height(40.dp))







    }
}

@Composable
fun PictureWithText(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ){
        Column {
            Box(
                modifier = Modifier.height(220.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.orang_kerja_1),
                    contentDescription = "App logo",
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
            ){
                Text(
                    color = Warna.MerahNormal,
                    fontWeight = FontWeight.Normal,
                    fontSize = 13.sp,
                    text = stringResource(id = R.string.konten_why),
                    textAlign = TextAlign.Justify
                )

            }

        }

    }
}

@Composable
fun SlideCard(){

        LazyRow(
            modifier = Modifier.padding(start = 0.dp),
            horizontalArrangement = Arrangement.spacedBy(23.dp)
        ) {
            items(10) { // replace with the number of items you have
                GrayCard(
                    text = stringResource(id = R.string.konten_seminar)
                )
            }
        }

}




@Composable
fun GrayBox(
    height: Int,
    content: @Composable () -> Unit,
){

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp)
    ){
        Card(
            modifier = Modifier
                .padding()
                .height(height.dp)
                .fillMaxWidth(),

            colors = CardDefaults.cardColors(containerColor = Warna.AbuMuda),
            elevation = CardDefaults.cardElevation(6.dp),
            shape = RoundedCornerShape(15.dp)
        ){
            content()
        }
    }
}

@Composable
fun GrayCard(
    text: String,
){
    Card(
        modifier = Modifier
            .padding()
            .height(220.dp)
            .width(165.dp),

        colors = CardDefaults.cardColors(containerColor = Warna.AbuMuda),
        elevation = CardDefaults.cardElevation(3.dp),
        shape = RoundedCornerShape(15.dp)
    ){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ){
            Row {
                Box(
                    modifier = Modifier
                        .size(120.dp, 160.dp)
                        .padding(top = 15.dp),
                    contentAlignment = Alignment.Center
                ){
                    Image(
                        painter = painterResource(id = R.drawable.image_12),
                        contentDescription = "App logo",
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                    )
                }
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 15.dp, end = 15.dp),
            )
            {

                Text(
                    textAlign = TextAlign.Center,
                    color = Warna.HitamNormal,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Normal,
                    text = text
                )
            }

        }
    }
}

@Composable
fun RedBubble(
    size: Int,
    text: @Composable () -> Unit,
){
    Box(
        modifier = Modifier
            .size(size.dp, 32.dp)
            .background(
                color = Warna.MerahNormal,
                shape = RoundedCornerShape(25.dp)
            ),
        contentAlignment = Alignment.Center

    ){
        text()
    }
}

@Composable
fun BottomBar(navController: NavHostController){
    val screens = listOf(
        BottomBarScreen.BottomMenuPage,
        BottomBarScreen.BottomProfilePage,
        BottomBarScreen.BottomCareerPage,
        BottomBarScreen.BottomSkillPage,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation(
        backgroundColor = Warna.MerahNormal,
        modifier = Modifier.height(60.dp)
    ){
        screens.forEach{ screen ->
            AddItem(screen = screen, currentDestination = currentDestination, navController = navController)
        }
    }
    
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
){
    BottomNavigationItem (
        label = {
            Text(text = screen.title, color = Warna.PutihNormal)
        },
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = "eheh",
                tint = Warna.PutihNormal
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.route){
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }

    )


}

