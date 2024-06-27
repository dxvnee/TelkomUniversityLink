package org.d3if3121.telkomuniversitylink.ui.screen.user


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.d3if3121.telkomuniversitylink.R
import org.d3if3121.telkomuniversitylink.model.Webinar
import org.d3if3121.telkomuniversitylink.ui.theme.Warna
import org.d3if3121.telkomuniversitylink.viewmodel.ContentViewModel

@Preview(showBackground = true)
@Composable
fun SkillPreview() {
    CobaSkillPage()
}

@Composable
fun CobaSkillPage() {
    SkillPage(rememberNavController(), viewModel())
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SkillPage(navController: NavHostController, viewModel: ContentViewModel){


    LaunchedEffect(viewModel.status){
        viewModel.getAllWebinar()
    }


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
                                text = "Skill"
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
        MenuSkill(topbarpadding, viewModel)
    }
}

@Composable
fun MenuSkill(
    topbarpadding :  PaddingValues,
    viewModel: ContentViewModel
){

    //MainColumn
    Column(
        modifier = Modifier
            .padding(topbarpadding)

    ){

        //ImageColumn


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ){
            RedBubble(size = 230) {
                Text(
                    color = Warna.PutihNormal,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    text = "Workshop Available:"
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ){
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(600.dp)
            ){
                SlideVerticalCard2(viewModel)
            }
        }

    }
}

@Composable
private fun SlideVerticalCard2(viewModel: ContentViewModel){
    val webinar by viewModel.webinarData.collectAsState()

    if (webinar != null) {
        LazyColumn(
            modifier = Modifier.padding(start = 0.dp),
            verticalArrangement = Arrangement.spacedBy(23.dp)
        ) {
            items(webinar) {
                GrayVerticalCard2(
                    webinar = it
                )
            }
        }

    } else {
        Text(text = "Tidak ada webinar.")
    }
}


@Composable
private fun GrayVerticalCard2(
    webinar: Webinar,
){
    GrayBox(height = 160) {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ){
            Row(
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            )
            {
                Box(
                    modifier = Modifier
                        .size(90.dp, 120.dp),
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
                Box(
                    modifier = Modifier

                        .fillMaxHeight()
                        .fillMaxWidth(),
                ){
                    Column {
                        Text(
                            textAlign = TextAlign.Center,
                            color = Warna.HitamNormal,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            text = webinar.name
                        )
                        Text(
                            textAlign = TextAlign.Start,
                            color = Warna.MerahNormal,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            text = webinar.company
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(
                                    color = Warna.PutihNormal,
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .fillMaxHeight()
                                .padding(10.dp)
                        ){

                            Text(
                                textAlign = TextAlign.Start,
                                color = Warna.HitamNormal,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Normal,
                                text = webinar.content
                            )
                        }
                    }
                }
            }
        }
    }

}
