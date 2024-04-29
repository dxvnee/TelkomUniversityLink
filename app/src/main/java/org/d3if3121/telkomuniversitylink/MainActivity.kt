package org.d3if3121.telkomuniversitylink

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import org.d3if3121.telkomuniversitylink.ui.screen.LoginPage
import org.d3if3121.telkomuniversitylink.ui.theme.TelkomUniversityLinkTheme
import org.d3if3121.telkomuniversitylink.ui.theme.Warna

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            TelkomUniversityLinkTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Warna.MerahNormal
                ) {
                    LoginPage {

                    }
                }
            }
        }
    }
}
