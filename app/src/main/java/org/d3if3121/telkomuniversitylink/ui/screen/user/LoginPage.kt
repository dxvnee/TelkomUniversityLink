package org.d3if3121.telkomuniversitylink.ui.screen.user


import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.d3if3121.telkomuniversitylink.R
import org.d3if3121.telkomuniversitylink.model.UserLogin
import org.d3if3121.telkomuniversitylink.navigation.Screen
import org.d3if3121.telkomuniversitylink.ui.theme.Warna
import org.d3if3121.telkomuniversitylink.viewmodel.UserViewModel

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    LoginPage(rememberNavController(), viewModel())
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(
    navController: NavHostController,
    viewModel: UserViewModel,
) {



    val focusManager = LocalFocusManager.current
    val context = LocalContext.current

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var passwordVisible by remember { mutableStateOf(false) }

    var emailError by remember { mutableStateOf(false) }
    var passwordError by remember { mutableStateOf(false) }

    val loginError by viewModel.loginError
    val loginSuccess by viewModel.loginSuccess

    val loginUser = UserLogin(
        username = username,
        password = password
    )

    LaunchedEffect(loginSuccess) {
        if (loginSuccess!!) {
            Toast.makeText(context, "Berhasil Masuk", Toast.LENGTH_SHORT).show()
            navController.navigate(Screen.MenuPage.route)
        }
    }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Warna.PutihNormal, RectangleShape)
        ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Box(
                        modifier = Modifier
                            .height(235.dp)
                            .shadow(elevation = 15.dp)
                            .background(
                                Warna.MerahNormal,
                                RoundedCornerShape(0.dp, 0.dp, 40.dp, 40.dp)
                            ),


                    ){
                        Column {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 35.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ){
                                Image(
                                    painter = painterResource(id = R.drawable.logo),
                                    contentDescription = "App logo",
                                    modifier = Modifier
                                        .width(120.dp)
                                        .height(120.dp)
                                        .shadow(elevation = 20.dp, shape = CircleShape)
                                )
                            }

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Column(
                                    modifier = Modifier.padding(12.dp),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.Start
                                ) {
                                    Text(
                                        text = stringResource(id = R.string.judul),
                                        color = Warna.PutihNormal,
                                        fontSize = 26.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        modifier = Modifier.shadow(elevation = 20.dp)
                                    )
                                }
                            }

                        }

                    }
                }


            }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 280.dp, start = 20.dp, end = 20.dp, bottom = 20.dp)
            .height(350.dp),

        colors = CardDefaults.cardColors(containerColor = Warna.PutihNormal),
        elevation = CardDefaults.cardElevation(20.dp),
        shape = RoundedCornerShape(15.dp)

    )
    {
        Column(
            modifier = Modifier
                .padding(start = 24.dp, top = 23.dp, end = 24.dp)
                .fillMaxWidth()
        ) {
            Row {
                Column {
                    Text(
                        text = stringResource(id = R.string.login),
                        color = Warna.MerahNormal,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,

                        )
                    Spacer(modifier = Modifier.height(14.dp))

                    OutlinedTextField(
                        value = username,
                        onValueChange = { username = it },
                        placeholder = {
                            Text(
                                text = "Username",
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp,
                                color = Warna.AbuNormal
                            )
                        },
                        singleLine = true,
                        isError = emailError,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp, 10.dp))
                            .height(70.dp)
                            .padding(vertical = 8.dp),
                        textStyle = TextStyle(
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp,
                            color = Warna.HitamNormal
                        ),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Warna.MerahNormal,
                            unfocusedBorderColor = Warna.MerahNormal,
                            focusedLabelColor = Warna.MerahNormal,
                            unfocusedLabelColor = Warna.AbuNormal,
                        ),

                        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                        keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(
                            FocusDirection.Down) }),
                        shape = RoundedCornerShape(15.dp),
                    )
                    if (emailError) {
                        Text(
                            text = "Email cannot be empty",
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        placeholder = {
                            Text(
                                text = "Password",
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp,
                                color = Warna.AbuNormal
                            )
                        },
                        singleLine = true,
                        isError = passwordError,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp, 10.dp))
                            .height(70.dp)
                            .padding(vertical = 8.dp),
                        textStyle = TextStyle(
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp,
                            color = Warna.HitamNormal
                        ),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Warna.MerahNormal,
                            unfocusedBorderColor = Warna.MerahNormal,
                            focusedLabelColor = Warna.MerahNormal,
                            unfocusedLabelColor = Warna.AbuNormal,
                        ),

                        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                        keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(
                            FocusDirection.Down) }),
                        shape = RoundedCornerShape(15.dp),
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        trailingIcon = {
                            val image =
                                if (passwordVisible) painterResource(id = R.drawable.baseline_visibility_24)
                                else painterResource(id = R.drawable.baseline_visibility_off_24)

                            IconButton(onClick = {
                                passwordVisible = !passwordVisible
                            }) {
                                Icon(
                                    painter = image,
                                    contentDescription = if (passwordVisible) "Hide password" else "Show password",
                                    tint = Warna.MerahNormal
                                )
                            }
                        }
                    )
                    if (passwordError) {
                        Text(
                            text = "Password cannot be empty",
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                }

            }





            Row(
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier.padding(top = 50.dp)
            ){
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Bottom
                ){
                    if (loginError!!) {
                        Text(
                            text = "The username or password you entered is incorrect",
                            color = MaterialTheme.colorScheme.error,
                            modifier = Modifier.padding(bottom = 5.dp)
                            )
                    }
                    ButtonMerah(
                        onClick = {
                            emailError = username.isEmpty()
                            passwordError = password.isEmpty()

                            if (emailError || passwordError ) {
                                return@ButtonMerah
                            }
                            if (!emailError && !passwordError) {
                                viewModel.loginUser(loginUser)
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(50.dp),
                        content = {
                            Text(
                                text = "LOGIN",
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                color = Warna.PutihNormal
                            )
                        }
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp, start = 3.dp),
                        verticalArrangement = Arrangement.Center,
                    ) {
                        Row (
                            modifier = Modifier
                                .fillMaxWidth(0.8f),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(text = "Belum Memiliki Akun? ", fontSize = 14.sp,fontWeight = FontWeight(500))
                            ClickableText(
                                text = AnnotatedString("Register"),
                                onClick = {
                                    navController.navigate(Screen.Register.route)
                                },
                                style = TextStyle.Default.copy(Warna.MerahNormal,fontSize = 14.sp, fontWeight = FontWeight(500))
                            )
                        }
                    }
                }



            }







        }
    }
        }



@Composable
fun ButtonMerah(
    onClick: () -> Unit,
    content: @Composable () -> Unit,
    modifier: Modifier,
){
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(15.dp),
        content = {
            content()
        },
        colors = ButtonDefaults.buttonColors(
            containerColor =  Warna.MerahNormal,
            contentColor =  Warna.PutihNormal
        )
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldMerah(
    textValue: String,
    onTextChanged: (String) -> Unit,
    nama: String
){
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp, 10.dp))
            .height(70.dp)
            .padding(vertical = 8.dp),

        value = textValue,
        onValueChange = onTextChanged,
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next
        ),
        textStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            color = Warna.HitamNormal
        ),
        placeholder = {
            Text(
                text = nama,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = Warna.AbuNormal
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Warna.MerahNormal,
            focusedBorderColor = Warna.MerahNormal,
            focusedLabelColor = Warna.MerahNormal,
            unfocusedLabelColor = Warna.AbuNormal
        ),
        shape = RoundedCornerShape(15.dp),
    )
}




