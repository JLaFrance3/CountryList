package edu.quinnipiac.ser210.countrylist.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import edu.quinnipiac.ser210.countrylist.Country
import edu.quinnipiac.ser210.countrylist.CountryList

@Composable
fun DetailScreen(
    navController: NavController,
    countryName: String?
) {
    val countryList = CountryList.filter { country ->
        country.name == countryName
    }

    DetailColumn(
        navController = navController,
        country = countryList[0]
    )
}

@Composable
fun DetailColumn(navController: NavController, country: Country, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(16.dp)
    ) {
        Text(
            text = "Country Fact: ${country.fact}",
            modifier = modifier
        )
        Image(
            painter = painterResource(country.map),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 32.dp)
        )
    }
}