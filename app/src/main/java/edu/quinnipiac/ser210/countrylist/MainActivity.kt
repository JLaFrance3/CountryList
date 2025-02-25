package edu.quinnipiac.ser210.countrylist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import edu.quinnipiac.ser210.countrylist.navigation.CountryListNavigation
import edu.quinnipiac.ser210.countrylist.ui.theme.CountryListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApp {
                CountryListNavigation()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    CountryListTheme {
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun ListPreview() {
    MyApp {
        CountryListNavigation()
    }
}