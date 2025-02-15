package edu.quinnipiac.ser210.countrylist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.quinnipiac.ser210.countrylist.ui.theme.CountryListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    CountryListTheme {
        Surface (
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            CountryColumn()
        }
    }
}

@Composable
fun CountryColumn(modifier: Modifier = Modifier) {
    LazyColumn {
        items(CountryList) { country ->
            HorizontalDivider(color = MaterialTheme.colorScheme.secondary)
            CountryCard(country, modifier)
        }
    }
}

@Composable
fun CountryCard(country: Country, modifier: Modifier = Modifier) {
    Row (
        modifier = modifier.fillMaxWidth()
    ) {
        FlagImage(country.flag, modifier)
        CountryInfo(country.name, country.currency, modifier)
    }
}

@Composable
fun FlagImage(@DrawableRes flag: Int, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(flag),
        contentDescription = "Flag",
        alignment = Alignment.Center,
        contentScale = ContentScale.Fit,
        modifier = modifier.size(48.dp)
    )
}

@Composable
fun CountryInfo(countryName: String, currency: String, modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
            .padding(start = 8.dp)
            .height(48.dp)
    ) {
        Text(
            text = "Country: $countryName",
            fontSize = 16.sp,
            lineHeight = 16.sp
        )
        Text(
            text = "Currency: $currency",
            fontSize = 12.sp,
            lineHeight = 12.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CountryListTheme {
        MyApp()
    }
}