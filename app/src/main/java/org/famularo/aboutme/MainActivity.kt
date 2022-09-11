package org.famularo.aboutme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.famularo.aboutme.ui.theme.AboutMeTheme
import org.famularo.aboutme.view.Main
import org.famularo.aboutme.viewmodels.PersonViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val vm = getVm()

        setContent {
            AboutMeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Main(vm)
                }
            }
        }
    }

    private fun getVm(): PersonViewModel {
        return PersonViewModel.sample()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AboutMeTheme {
        Main(PersonViewModel.sample())
    }
}