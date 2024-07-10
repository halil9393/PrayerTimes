package ui

import Greeting
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.koin.compose.getKoin
import util.navigateTo
import viewmodel.HomeViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(navController: NavController) {

    val scope = rememberCoroutineScope()
    var text by remember { mutableStateOf("Loading") }


    val greeting = Greeting()
    //var productList by remember { mutableStateOf(mutableListOf<Product>()) }

    val viewModel: HomeViewModel = getKoin().get()

    LaunchedEffect(true) {
        /*scope.launch {
            text = try {
                Greeting().greeting()
            } catch (e: Exception) {
                e.toString()
            }
        }

        greeting.getProducts()?.collect{
            productListServer ->
            productList = productListServer
        }

        EzanVaktiApi().getCountries()?.collect{

            println("basarılı")
        }*/



       // viewModel.getCountries()

        //viewModel.getCities("2")


        //viewModel.getDistricts("506")

        viewModel.getPrayerTimes("9206")

    }



    Scaffold {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Text("Home Screen")
            Text(text)
            Button(onClick = {
                navigateTo(navController, DestinationScreen.SettingsScreen.route)
            }){
                Text("Navigate to Settings")
            }

            val pagerState = rememberPagerState(0) { 3 }


            HorizontalPager(
                state = pagerState
            ) {currentPage ->
                Box(
                    modifier = Modifier
                        .padding(20.dp)
                        .background(Color.LightGray)
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    Text(currentPage.toString())
                }
            }
        }

    }


}

