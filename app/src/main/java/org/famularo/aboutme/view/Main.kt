package org.famularo.aboutme.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import org.famularo.aboutme.ui.theme.AboutMeTheme
import org.famularo.aboutme.viewmodels.PersonViewModel

@Composable
fun Main(vm: PersonViewModel) {
    val navController = rememberNavController()

    Scaffold(
        backgroundColor = MaterialTheme.colors.background,
        bottomBar = { BottomNavigationBar(navController) },
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                Navigation(navController = navController, vm)
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    AboutMeTheme(true) {
        Main(PersonViewModel.sample())
    }
}
