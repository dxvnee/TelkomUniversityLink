package org.d3if3121.telkomuniversitylink.ui.screen.user


import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.flow.MutableStateFlow
import org.d3if3121.telkomuniversitylink.R
import org.d3if3121.telkomuniversitylink.model.UserRegister
import org.d3if3121.telkomuniversitylink.model.User
import org.d3if3121.telkomuniversitylink.navigation.Screen
import org.d3if3121.telkomuniversitylink.ui.theme.Warna
import org.d3if3121.telkomuniversitylink.viewmodel.UserViewModel




@Composable
fun RegisterPage(
    navController: NavHostController,
    viewModel: UserViewModel
) {



    val context = LocalContext.current
    val focusManager = LocalFocusManager.current

    var userName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var passwordVisible by remember { mutableStateOf(false) }

    var userNameError by remember { mutableStateOf(false) }
    var userNameErrorContext by remember { mutableStateOf("Username cannot be empty") }
    var emailError by remember { mutableStateOf(false) }
    var passwordError by remember { mutableStateOf(false) }

    var registerSuccess by viewModel.registerSuccess
    var registerError by viewModel.registerError
    var registerErrorBoolean by viewModel.registerErrorBoolean


    val newUser = UserRegister(
        username = userName,
        email = email,
        password = password
    )

    LaunchedEffect(registerSuccess) {
        if (registerSuccess!!) {
            Toast.makeText(context, "Registration Successfully", Toast.LENGTH_SHORT).show()
            navController.navigate(Screen.Login.route)
        }
    }

    LaunchedEffect(registerErrorBoolean) {
        if (registerErrorBoolean) {
            userNameErrorContext = "Username already exist!"
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
                    .background(Warna.MerahNormal, RoundedCornerShape(0.dp, 0.dp, 40.dp, 40.dp)),


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
    val cardHeight = remember { mutableStateOf<Int?>(0) }
        if (userNameError || emailError || passwordError){
            cardHeight.value = 430
        } else {
            cardHeight.value = 390
        }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 280.dp, start = 20.dp, end = 20.dp, bottom = 100.dp)
            .height(cardHeight.value!!.dp),

        colors = CardDefaults.cardColors(containerColor = Warna.PutihNormal),
        elevation = CardDefaults.cardElevation(20.dp),
        shape = RoundedCornerShape(15.dp)

    )
    {
        Column(
            modifier = Modifier.padding(start = 24.dp, top = 18.dp, end = 24.dp, bottom = 18.dp).fillMaxHeight()
        ) {
            Row(
                verticalAlignment = Alignment.Top
            ){
                Column {
                    Text(
                        text = "Register",
                        color = Warna.MerahNormal,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,

                        )
                    Spacer(modifier = Modifier.height(14.dp))

                    OutlinedTextField(
                        value = userName,
                        onValueChange = { userName = it },
                        placeholder = {
                            Text(
                                text = "Username",
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp,
                                color = Warna.AbuNormal
                            )
                        },
                        singleLine = true,
                        isError = userNameError,
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
                    if (userNameError) {
                        Text(
                            text = userNameErrorContext,
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                    if (registerErrorBoolean) {
                        Text(
                            text = userNameErrorContext,
                            color = MaterialTheme.colorScheme.error
                        )
                    }

                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        placeholder = {
                            Text(
                                text = "Email",
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
                            color = MaterialTheme.colorScheme.error,

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



            Row (
                modifier = Modifier.fillMaxHeight(),
                verticalAlignment = Alignment.Bottom
            ){
                Column (
                    verticalArrangement = Arrangement.Bottom
                ){

                    ButtonMerah(
                        onClick = {
                            userNameError = userName.isEmpty()
                            emailError = email.isEmpty()
                            passwordError = password.isEmpty()

                            if (userNameError || emailError || passwordError ) {
                                return@ButtonMerah
                            }
                            if (!userNameError && !emailError && !passwordError) {
                                viewModel.registerUser(newUser)
                            }


                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp)
                            .size(50.dp),
                        content = {
                            Text(
                                text = "REGISTER",
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
                        horizontalAlignment = Alignment.Start
                    ) {
                        Row (
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(text = "Already have an account? ", fontSize = 14.sp,fontWeight = FontWeight(500))
                            ClickableText(
                                text = AnnotatedString("Login"),
                                onClick = {
                                    navController.navigate(Screen.Login.route)
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




@Preview(showBackground = true)
@Composable
fun RegisterPreview() {
    RegisterPage(rememberNavController(), viewModel())
}
