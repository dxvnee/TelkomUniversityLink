package org.d3if3121.telkomuniversitylink

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import org.d3if3121.telkomuniversitylink.navigation.SetupNavGraph
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
                    SetupNavGraph()
                }
            }
        }
    }
}
