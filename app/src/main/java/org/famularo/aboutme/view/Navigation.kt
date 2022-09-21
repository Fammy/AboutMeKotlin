package org.famularo.aboutme.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.famularo.aboutme.viewmodels.NavigationItem
import org.famularo.aboutme.viewmodels.PersonViewModel

@Composable
fun Navigation(navController: NavHostController, vm: PersonViewModel) {
    NavHost(navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            HomeScreen(vm)
        }
        composable(NavigationItem.Contact.route) {
            ContactScreen(vm)
        }
    }
}