package org.famularo.aboutme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.famularo.aboutme.enums.SocialService
import org.famularo.aboutme.ui.theme.AboutMeTheme
import org.famularo.aboutme.view.Contact
import org.famularo.aboutme.view.Header
import org.famularo.aboutme.viewmodels.PersonViewModel
import org.famularo.aboutme.viewmodels.SocialLinkViewModel

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
                    Column(Modifier.padding(16.dp)) {
                        Header(vm)
                        Contact(vm)
                    }
                }
            }
        }
    }

    private fun getVm(): PersonViewModel {
        val vm = PersonViewModel("Jason Famularo", "Writing software since the 1st Grade")
        vm.socialServices.add(SocialLinkViewModel("Fammy", SocialService.GitHub))
        vm.socialServices.add(SocialLinkViewModel("@splodn", SocialService.Twitter))
        vm.socialServices.add(SocialLinkViewModel("@fammacro", SocialService.Instagram))
        vm.socialServices.add(SocialLinkViewModel("Homepage", SocialService.Homepage))
        return vm;
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val vm = PersonViewModel("Jason Famularo", "Writing software since the 1st Grade")
    vm.socialServices.add(SocialLinkViewModel("Fammy", SocialService.GitHub))
    vm.socialServices.add(SocialLinkViewModel("@splodn", SocialService.Twitter))
    vm.socialServices.add(SocialLinkViewModel("@fammacro", SocialService.Instagram))
    vm.socialServices.add(SocialLinkViewModel("Homepage", SocialService.Homepage))

    AboutMeTheme {
        Column(Modifier.padding(16.dp)) {
            Header(vm)
            Contact(vm)
        }
    }
}