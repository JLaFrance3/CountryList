package edu.quinnipiac.ser210.countrylist.navigation

enum class CountryScreens {
    HomeScreen,
    DetailScreen;
    companion object {
        fun fromRoute(route: String?): CountryScreens
            = when (route?.substringBefore("/")) {
                HomeScreen.name -> HomeScreen
                DetailScreen.name -> DetailScreen
                null -> HomeScreen
                else -> throw IllegalArgumentException("Route $route not recognized")
            }
    }
}