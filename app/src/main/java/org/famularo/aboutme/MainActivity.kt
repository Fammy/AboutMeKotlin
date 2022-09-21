package org.famularo.aboutme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import org.famularo.aboutme.ui.theme.AboutMeTheme
import org.famularo.aboutme.view.Main
import org.famularo.aboutme.viewmodels.PersonViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val vm = getVm()

        setContent {
            AboutMeTheme {
                Main(vm)
            }
        }
    }

    private fun getVm(): PersonViewModel {
        return PersonViewModel.sample()
    }
}
