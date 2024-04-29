package org.d3if3121.telkomuniversitylink.ui.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import org.d3if3121.telkomuniversitylink.R
import org.d3if3121.telkomuniversitylink.ui.theme.Warna

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CobaLoginPage()
}

@Composable
fun CobaLoginPage() {
    LoginPage {

    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(content: @Composable (Modifier) -> Unit) {

    Surface {
        Column(modifier = Modifier.fillMaxSize()){
            Box(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ){
                Content()
            }
        }
    }

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Content(){
    var textValue by remember { mutableStateOf("") }
        Column(

        ) {
            ConstraintLayout(

            )
            {
                val (topImg, profile) = createRefs()

                SimpleCircle(
                    Modifier
                        .constrainAs(topImg) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                        }
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 38.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "App logo",
                        modifier = Modifier
                            .width(120.dp)
                            .height(120.dp)
                            .shadow(elevation = 20.dp, shape = CircleShape)
                    )

                    Row(
                        modifier = Modifier
                            .height(100.dp)

                    ) {
                        Column(
                            modifier = Modifier
                                .height(70.dp),

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


                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 250.dp, start = 20.dp, end = 20.dp, bottom = 200.dp)
                        .height(350.dp),

                    colors = CardDefaults.cardColors(containerColor = Warna.PutihNormal),
                    elevation = CardDefaults.cardElevation(20.dp),
                    shape = RoundedCornerShape(15.dp)

                )
                {
                    Column(
                        modifier = Modifier.padding(start = 24.dp, top = 18.dp, end = 24.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.login),
                            color = Warna.MerahNormal,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,

                        )
                        Spacer(modifier = Modifier.height(14.dp))

                        TextFieldMerah(
                            textValue = textValue,
                            onTextChanged =  {
                                textValue = it
                            },
                            nama = stringResource(id = R.string.username)
                        )

                        TextFieldMerah(
                            textValue = textValue,
                            onTextChanged =  {
                                textValue = it
                            },
                            nama = stringResource(id = R.string.password)
                        )

                        Spacer(modifier = Modifier.height(70.dp))

                        ButtonMerah(
                            onClick = { },
                            nama = stringResource(id = R.string.login_bold),
                            modifier = Modifier.fillMaxWidth().size(50.dp)
                        )




                    }
                }





            }

        }
    }
@Composable
fun ButtonMerah(
    onClick: () -> Unit,
    nama: String,
    modifier: Modifier,
){
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(15.dp),
        content = {
            Text(
                text = nama,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Warna.PutihNormal
            )
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

@Composable
fun SimpleCircle(
    modifier: Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(280.dp)
            .background(
                color = Warna.MerahNormal,
                shape = RoundedCornerShape(bottomEnd = 25.dp, bottomStart = 25.dp)
            ),
    )
}


