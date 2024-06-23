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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.d3if3121.telkomuniversitylink.R
import org.d3if3121.telkomuniversitylink.ui.theme.Warna
import org.d3if3121.telkomuniversitylink.viewmodel.WebinarViewModel


@Preview(showBackground = true)
@Composable
fun EditProfilePreview() {
    CobaEditProfilePage()
}

@Composable
fun CobaEditProfilePage() {
    EditProfilePage(rememberNavController())
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfilePage(navController: NavHostController){
val factory = ViewModelFactroy()

    val viewModel: WebinarViewModel = viewModel(factory = factory)
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
                                text = "Edit Profile"
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
        EditProfileMenu(topbarpadding)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileMenu(
    topbarpadding :  PaddingValues
){

    //MainColumn
    Column(
        modifier = Modifier
            .padding(topbarpadding)
            .verticalScroll(rememberScrollState())
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ){
            RedBubble(size = 200) {
                Text(
                    color = Warna.PutihNormal,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    text = "Change your info:"
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth().height(700.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center
        ){
            //card
            GrayBox(height = 900)
            {
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))

                        .padding(20.dp)
                ){
                    Column(

                    ){
                        Text(
                            text = "Full Name: ",
                            color = Warna.MerahNormal,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold,
                        )
                        OutlinedTextField(
                            value = "",
                            onValueChange = {
//                            newText ->
//                            if (newText.length <= 14) {
//                                onWordChange(newText)
//                            }
                            },


                            singleLine = true,
                            keyboardOptions = KeyboardOptions(
                                capitalization = KeyboardCapitalization.Words,
                                imeAction = ImeAction.Next
                            ) ,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp, 10.dp))
                                .padding(vertical = 10.dp),

                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = Warna.MerahNormal,
                                focusedBorderColor = Warna.MerahNormal,
                                focusedLabelColor = Warna.MerahNormal,
                                unfocusedLabelColor = Warna.HitamNormal,
                            ),
                            shape = RoundedCornerShape(15.dp),
                            trailingIcon = {
//                            IconPicker(isError = wordsError, imageVector = Icons.Default.AddCircle)
                            },
                            textStyle = TextStyle(
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp,
                                color = Warna.HitamNormal
                            ),
                            supportingText = {
//                            ErrorHint(wordsError)
                            },
                            placeholder = {
                                Text(
                                    text = "ex. Eigiya Daramuli Kale",
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 14.sp,
                                    color = Warna.AbuNormal
                                )
                            },

                            )

                        Text(
                            text = "Job:",
                            color = Warna.MerahNormal,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold,
                        )
                        OutlinedTextField(
                            value = "",
                            onValueChange = {
//                            newText ->
//                            if (newText.length <= 14) {
//                                onWordChange(newText)
//                            }
                            },


                            singleLine = true,
                            keyboardOptions = KeyboardOptions(
                                capitalization = KeyboardCapitalization.Words,
                                imeAction = ImeAction.Next
                            ) ,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp, 10.dp))
                                .padding(vertical = 10.dp),

                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = Warna.MerahNormal,
                                focusedBorderColor = Warna.MerahNormal,
                                focusedLabelColor = Warna.MerahNormal,
                                unfocusedLabelColor = Warna.HitamNormal,
                            ),
                            shape = RoundedCornerShape(15.dp),
                            trailingIcon = {
//                            IconPicker(isError = wordsError, imageVector = Icons.Default.AddCircle)
                            },
                            textStyle = TextStyle(
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp,
                                color = Warna.HitamNormal
                            ),
                            supportingText = {
//                            ErrorHint(wordsError)
                            },
                            placeholder = {
                                Text(
                                    text = "ex. Software Engineer",
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 14.sp,
                                    color = Warna.AbuNormal
                                )
                            },

                            )

                        Text(
                            text = "Location: ",
                            color = Warna.MerahNormal,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold,
                        )
                        OutlinedTextField(
                            value = "",
                            onValueChange = {
//                            newText ->
//                            if (newText.length <= 14) {
//                                onWordChange(newText)
//                            }
                            },


                            singleLine = true,
                            keyboardOptions = KeyboardOptions(
                                capitalization = KeyboardCapitalization.Words,
                                imeAction = ImeAction.Next
                            ) ,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp, 10.dp))
                                .padding(vertical = 10.dp),

                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = Warna.MerahNormal,
                                focusedBorderColor = Warna.MerahNormal,
                                focusedLabelColor = Warna.MerahNormal,
                                unfocusedLabelColor = Warna.HitamNormal,
                            ),
                            shape = RoundedCornerShape(15.dp),
                            trailingIcon = {
//                            IconPicker(isError = wordsError, imageVector = Icons.Default.AddCircle)
                            },
                            textStyle = TextStyle(
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp,
                                color = Warna.HitamNormal
                            ),
                            supportingText = {
//                            ErrorHint(wordsError)
                            },
                            placeholder = {
                                Text(
                                    text = "ex. Bandung, Indonesia",
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 14.sp,
                                    color = Warna.AbuNormal
                                )
                            },

                            )
                        Text(
                            text = "Phone: ",
                            color = Warna.MerahNormal,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold,
                        )
                        OutlinedTextField(
                            value = "",
                            onValueChange = {
//                            newText ->
//                            if (newText.length <= 14) {
//                                onWordChange(newText)
//                            }
                            },


                            singleLine = true,
                            keyboardOptions = KeyboardOptions(
                                capitalization = KeyboardCapitalization.Words,
                                imeAction = ImeAction.Next
                            ) ,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp, 10.dp))
                                .padding(vertical = 10.dp),

                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = Warna.MerahNormal,
                                focusedBorderColor = Warna.MerahNormal,
                                focusedLabelColor = Warna.MerahNormal,
                                unfocusedLabelColor = Warna.HitamNormal,
                            ),
                            shape = RoundedCornerShape(15.dp),
                            trailingIcon = {
//                            IconPicker(isError = wordsError, imageVector = Icons.Default.AddCircle)
                            },
                            textStyle = TextStyle(
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp,
                                color = Warna.HitamNormal
                            ),
                            supportingText = {
//                            ErrorHint(wordsError)
                            },
                            placeholder = {
                                Text(
                                    text = "ex. +62 81366366550",
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 14.sp,
                                    color = Warna.AbuNormal
                                )
                            },

                            )
                        Text(
                            text = "About Me: ",
                            color = Warna.MerahNormal,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold,
                        )
                        OutlinedTextField(
                            value = "",
                            onValueChange = {
//                            newText ->
//                            if (newText.length <= 14) {
//                                onWordChange(newText)
//                            }
                            },

                            singleLine = true,
                            keyboardOptions = KeyboardOptions(
                                capitalization = KeyboardCapitalization.Words,
                                imeAction = ImeAction.Next
                            ) ,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp, 10.dp))
                                .padding(vertical = 10.dp),

                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = Warna.MerahNormal,
                                focusedBorderColor = Warna.MerahNormal,
                                focusedLabelColor = Warna.MerahNormal,
                                unfocusedLabelColor = Warna.HitamNormal,
                            ),
                            shape = RoundedCornerShape(15.dp),
                            trailingIcon = {
//                            IconPicker(isError = wordsError, imageVector = Icons.Default.AddCircle)
                            },
                            textStyle = TextStyle(
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp,
                                color = Warna.HitamNormal
                            ),
                            supportingText = {
//                            ErrorHint(wordsError)
                            },
                            placeholder = {
                                Text(
                                    text = "ex. I'm a student at Telkom University",
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 14.sp,
                                    color = Warna.AbuNormal
                                )
                            },

                            )

                        Spacer(modifier = Modifier.height(20.dp))

                        Button(
                            onClick = {
//
//                            wordsError = (word == "")
//                            meaningError = (meaning == "")
//                            notesError = (note == "")
//
//                            if(wordsError || meaningError || notesError) {
//
//                            } else {
//                                if(id == null){
//                                    if(isChecked){
//                                        viewModel.insertWithDate(word, meaning, note)
//                                    } else {
//                                        viewModel.insert(word, meaning, note)
//                                    }
//                                } else {
//                                    viewModel.update(id, word, meaning, note)
//                                }
//                                navController.popBackStack()
//                                Toast.makeText(context, R.string.data_add, Toast.LENGTH_SHORT).show()
//
//                            }


                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .size(50.dp),
                            shape = RoundedCornerShape(15.dp),
                            content = {
                                Text(
                                    text = "Edit",
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
