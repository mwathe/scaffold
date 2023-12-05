package com.alan.myapplication2.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.alan.myapplication2.Screens.HomeScreen
import com.alan.myapplication2.Screens.ProfileScreen
import com.alan.myapplication2.Screens.SettingsScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation (){

    val navController:NavHostController = rememberNavController()

    Scaffold (
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination : NavDestination? = navBackStackEntry?.destination

                listOfNavItems.forEach { navItem ->
                   NavigationBarItem(
                       selected = currentDestination?.hierarchy?.any { it.route == navItem.route} == true,
                       onClick = {
                                 navController.navigate(navItem.route){
                                     popUpTo(navController.graph.findStartDestination().id){
                                         saveState = true
                                     }
                                     launchSingleTop = true
                                     restoreState = true
                                 }
                       },
                       icon = {
                           Icon(imageVector = navItem.icon,
                               contentDescription = null)
                       },
                       label = {
                             Text(text = navItem.label)
                       }

                   )

                }
            }

        }
    ) {paddingValues: PaddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screens.HomeScreen.name,
            modifier = Modifier
                .padding(paddingValues)
        ){
            composable(route = Screens.HomeScreen.name){
                HomeScreen()
            }
            composable(route = Screens.ProfileScreen.name){
                ProfileScreen()
            }
            composable(route = Screens.SettingsScreen.name){
                SettingsScreen()
            }


        }
    }
}