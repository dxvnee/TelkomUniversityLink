package org.d3if3121.telkomuniversitylink.ui.screen.user


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.d3if3121.telkomuniversitylink.R
import org.d3if3121.telkomuniversitylink.ui.theme.Warna
import org.d3if3121.telkomuniversitylink.viewmodel.ProjectViewModel
import org.d3if3121.telkomuniversitylink.viewmodel.UserViewModel

@Preview(showBackground = true)
@Composable
fun ConfirmCareerPreview() {
    CobaConfirmCareerPage()
}

@Composable
fun CobaConfirmCareerPage() {
    ConfirmCareerPage(rememberNavController(), 0)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfirmCareerPage(navController: NavHostController, id: Int? = null) {
    val viewModel: ProjectViewModel = viewModel()
    LaunchedEffect(id) {
        if (id != null) {
            viewModel.getCurrentProject(id)
        } else {
            viewModel.loadDummyProjects()
        }
    }

    Scaffold(
        topBar = {
            Column() {
                TopAppBar(
                    navigationIcon = {},
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
                                text = "Confirm Career"
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
                        .background(color = Warna.AbuNormal)
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
        MenuConfirmCareer(topbarpadding, viewModel)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuConfirmCareer(
    topbarpadding: PaddingValues,
    viewModelProject: ProjectViewModel
) {
    val viewModel: UserViewModel = viewModel()
    val currentUser by viewModel.currentUser.collectAsState()
    val currentProject by viewModelProject.currentProject.collectAsState()

    //MainColumn
    Column(
        modifier = Modifier
            .padding(topbarpadding)
            .verticalScroll(rememberScrollState())
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(600.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            //card
            if (currentUser != null && currentProject != null) {
                GrayBox(height = 480) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .padding(20.dp)
                    ) {
                        Column {
                            Text(
                                text = "Full Name: ",
                                color = Warna.MerahNormal,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.SemiBold,
                            )
                            Text(
                                text = currentUser!!.userName,
                                color = Warna.HitamNormal,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                            )

                            Spacer(modifier = Modifier.height(20.dp))

                            Text(
                                text = "Job :",
                                color = Warna.MerahNormal,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.SemiBold,
                            )
                            Text(
                                text = currentUser!!.job,
                                color = Warna.HitamNormal,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                            )

                            Spacer(modifier = Modifier.height(20.dp))

                            Text(
                                text = "Location: ",
                                color = Warna.MerahNormal,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.SemiBold,
                            )
                            Text(
                                text = currentUser!!.address,
                                color = Warna.HitamNormal,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                            )
                            Spacer(modifier = Modifier.height(20.dp))

                            Text(
                                text = "Phone: ",
                                color = Warna.MerahNormal,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.SemiBold,
                            )
                            Text(
                                text = currentUser!!.phone,
                                color = Warna.HitamNormal,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                            )

                            Spacer(modifier = Modifier.height(20.dp))

                            Text(
                                text = "Ordered: ",
                                color = Warna.MerahNormal,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.SemiBold,
                            )
                            Text(
                                text = currentProject!!.name,
                                color = Warna.HitamNormal,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                            )

                            Spacer(modifier = Modifier.height(40.dp))
                            Button(
                                onClick = {
                                    viewModelProject.registerToProject(currentUser!!.id, currentProject!!.id)
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .size(50.dp),
                                shape = RoundedCornerShape(15.dp),
                                content = {
                                    Text(
                                        text = "Confirm",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 18.sp,
                                        color = Warna.PutihNormal
                                    )
                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Warna.MerahNormal,
                                    contentColor = Warna.PutihNormal
                                )
                            )
                        }
                    }
                }
            } else {
                // Menampilkan data dummy jika currentUser atau currentProject bernilai null
                GrayBox(height = 480) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .padding(20.dp)
                    ) {
                        Column {
                            Text(
                                text = "Full Name: ",
                                color = Warna.MerahNormal,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.SemiBold,
                            )
                            Text(
                                text = "Egia Kale",
                                color = Warna.HitamNormal,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                            )

                            Spacer(modifier = Modifier.height(20.dp))

                            Text(
                                text = "Job :",
                                color = Warna.MerahNormal,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.SemiBold,
                            )
                            Text(
                                text = "Software engineer",
                                color = Warna.HitamNormal,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                            )

                            Spacer(modifier = Modifier.height(20.dp))

                            Text(
                                text = "Location: ",
                                color = Warna.MerahNormal,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.SemiBold,
                            )
                            Text(
                                text = "Bandung",
                                color = Warna.HitamNormal,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                            )
                            Spacer(modifier = Modifier.height(20.dp))

                            Text(
                                text = "Phone: ",
                                color = Warna.MerahNormal,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.SemiBold,
                            )
                            Text(
                                text = "0813287423",
                                color = Warna.HitamNormal,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                            )

                            Spacer(modifier = Modifier.height(20.dp))

                            Text(
                                text = "Ordered: ",
                                color = Warna.MerahNormal,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.SemiBold,
                            )
                            Text(
                                text = "Magang Web Dev",
                                color = Warna.HitamNormal,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                            )

                            Spacer(modifier = Modifier.height(40.dp))

                            Button(
                                onClick = {
                                    viewModelProject.loadDummyProjects()
                                    viewModelProject.registerToProject(1, 1)  // ID dummy
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .size(50.dp),
                                shape = RoundedCornerShape(15.dp),
                                content = {
                                    Text(
                                        text = "Confirm",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 18.sp,
                                        color = Warna.PutihNormal
                                    )
                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Warna.MerahNormal,
                                    contentColor = Warna.PutihNormal
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}





























