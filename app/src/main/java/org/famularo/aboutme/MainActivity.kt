package org.famularo.aboutme

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import org.famularo.aboutme.enums.SocialService
import org.famularo.aboutme.ui.theme.AboutMeTheme
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
                        AboutMeHeader(vm)
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

@Composable
fun AboutMeHeader(vm: PersonViewModel) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Avatar(R.mipmap.avatar)
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(start = 16.dp)) {
            Text(vm.name, style = MaterialTheme.typography.h5)
            Text(vm.tagLine, style = MaterialTheme.typography.caption)
        }
    }
}

@Composable
fun Contact(vm: PersonViewModel) {
    Column(modifier = Modifier.padding(top = 16.dp)) {
        Text("Contact", style = MaterialTheme.typography.h6)
        for (link in vm.socialServices) {
            SocialLink(link)
        }
    }
}

@Composable
fun SocialLink(link: SocialLinkViewModel) {
    val context = LocalContext.current;
    Row(verticalAlignment = Alignment.Bottom, modifier = Modifier.clickable {
        openUrl(context, link.url)
    })
    {
        Icon(link.icon, link.contentDescription, Modifier.size(20.dp), link.tint)
        Text(link.username, modifier = Modifier.padding(start = 8.dp))
    }
}

fun openUrl(context: Context, url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    ContextCompat.startActivity(context, intent, null)
}

@Composable
fun Avatar(id: Int) {
    val avatarImage: Painter = painterResource(id = id)
    Image(
        painter = avatarImage,
        contentDescription = "avatar",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(128.dp)
            .clip(CircleShape)
    )
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
            AboutMeHeader(vm)
            Contact(vm)
        }
    }
}