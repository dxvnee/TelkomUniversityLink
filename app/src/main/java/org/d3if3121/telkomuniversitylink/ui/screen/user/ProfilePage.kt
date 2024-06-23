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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.d3if3121.telkomuniversitylink.R
import org.d3if3121.telkomuniversitylink.model.ProjectResponse
import org.d3if3121.telkomuniversitylink.model.WebinarResponse
import org.d3if3121.telkomuniversitylink.ui.theme.Warna
import org.d3if3121.telkomuniversitylink.viewmodel.UserViewModel


@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    CobaProfilePage()
}

@Composable
fun CobaProfilePage() {
    ProfilePage(rememberNavController())
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfilePage(navController: NavHostController) {
    val viewModel: UserViewModel = viewModel()
    viewModel.loadDummyUsers()

    Scaffold(
        topBar = {
            Column() {
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


        ) { topbarpadding ->
        ProfileMenu(topbarpadding)
    }
}

@Composable
fun ProfileMenu(
    topbarpadding: PaddingValues
) {
    val viewModel: UserViewModel = viewModel()
    val currentUser by viewModel.currentUser.collectAsState()
    //MainColumn
    Column(
        modifier = Modifier
            .padding(topbarpadding)
            .verticalScroll(rememberScrollState())

    ) {

        //ImageColumn
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(129.dp)

        ) {
            Image(
                painter = painterResource(id = R.drawable.header_2),
                contentDescription = "App logo",
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()

        ) {
            Card(
                modifier = Modifier
                    .padding()
                    .height(160.dp)
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Warna.AbuMuda),
                elevation = CardDefaults.cardElevation(6.dp),
                shape = RoundedCornerShape(15.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(20.dp)
                        .height(120.dp)
                        .fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(100.dp)
                            .size(90.dp, 120.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.logo),
                            contentDescription = "App logo",
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight()
                        )
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth()
                            .padding(start = 20.dp),
                    ) {
                        Column()
                        {
                            if (currentUser != null) {

                                Text(
                                    textAlign = TextAlign.Center,
                                    color = Warna.HitamNormal,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    text = currentUser!!.userName
                                )
                                Text(
                                    textAlign = TextAlign.Start,
                                    color = Warna.MerahNormal,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    text = currentUser!!.job
                                )

                                Spacer(modifier = Modifier.height(10.dp))

                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                                ) {
                                    Row {
                                        Icon(
                                            painter = painterResource(id = R.drawable.icon_location_on_),
                                            contentDescription = "App logo",
                                            modifier = Modifier
                                                .size(20.dp),
                                            tint = Warna.MerahNormal
                                        )
                                        Text(
                                            textAlign = TextAlign.Start,
                                            color = Warna.MerahNormal,
                                            fontSize = 13.sp,
                                            fontWeight = FontWeight.Normal,
                                            text = currentUser!!.address
                                        )
                                    }

                                    Row {
                                        Icon(
                                            painter = painterResource(id = R.drawable.icon_contacts_),
                                            contentDescription = "App logo",
                                            modifier = Modifier
                                                .size(20.dp),
                                            tint = Warna.MerahNormal
                                        )
                                        Text(
                                            textAlign = TextAlign.Start,
                                            color = Warna.MerahNormal,
                                            fontSize = 13.sp,
                                            fontWeight = FontWeight.Normal,
                                            text = currentUser!!.phone
                                        )
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.height(10.dp))

                            Row(
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                ButtonMerah(
                                    onClick = { },
                                    modifier = Modifier
                                        .width(80.dp)
                                        .height(35.dp),
                                    content = {
                                        Text(
                                            text = "Edit",
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 13.sp,
                                            color = Warna.PutihNormal
                                        )
                                    }
                                )

                                ButtonMerah(
                                    onClick = { },
                                    modifier = Modifier
                                        .width(85.dp)
                                        .height(35.dp),
                                    content = {
                                        Text(
                                            text = "Other",
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 13.sp,
                                            color = Warna.PutihNormal
                                        )
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            RedBubble(size = 140) {
                Text(
                    color = Warna.PutihNormal,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    text = "About Me"
                )
            }
        }

        GrayBox(height = 160) {
            Box(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxHeight()
                    .fillMaxWidth()
            ) {
                Text(
                    textAlign = TextAlign.Justify,
                    color = Warna.HitamNormal,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Normal,
                    text = "Saya adalah orang yang disiplin dan fokus terhadap hasil kerja. Saya dapat bekerja sama dengan tim dalam bekerja. Saya adalah orang yang disiplin dan fokus terhadap hasil kerja. Saya dapat bekerja sama dengan tim dalam bekerja. Saya adalah orang yang disiplin dan fokus terhadap hasil kerja. Saya dapat bekerja sama dengan tim dalam bekerja."
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            RedBubble(size = 190) {
                Text(
                    color = Warna.PutihNormal,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    text = "Project Ordered"
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp)
        ) {
            SlideCardProject(viewModel)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            RedBubble(size = 190) {
                Text(
                    color = Warna.PutihNormal,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    text = "Workshop Ordered"
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp)
        ) {
            SlideCard()
        }


        Spacer(modifier = Modifier.height(20.dp))


    }
}

@Composable
private fun SlideCardProject(viewModel: UserViewModel) {
    val projects by viewModel.groupList.collectAsState()


    LazyRow(
        modifier = Modifier.padding(start = 0.dp),
        horizontalArrangement = Arrangement.spacedBy(23.dp)
    ) {
        if (projects != null){
            items(projects?.projects!!) {
                GrayCardProject(
                    project = it
                )
            }

        } else {

        }
    }
}

@Composable
private fun GrayCardProject(project: ProjectResponse) {
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
                    text = project.name
                )
            }

        }
    }
}
@Composable
private fun SlideCardWebinars(viewModel: UserViewModel) {
    val webinars by viewModel.groupList.collectAsState()
    LazyRow(
        modifier = Modifier.padding(start = 0.dp),
        horizontalArrangement = Arrangement.spacedBy(23.dp)
    ) {
        items(webinars?.webinars!!) {
            GrayCardWebinar(
                webinar = it
            )
        }
    }
}

@Composable
private fun GrayCardWebinar(webinar: WebinarResponse) {
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
                    text = webinar.title
                )
            }

        }
    }
}


