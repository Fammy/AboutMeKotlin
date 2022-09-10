package org.famularo.aboutme

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Brands
import compose.icons.fontawesomeicons.brands.Github
import compose.icons.fontawesomeicons.brands.Instagram
import compose.icons.fontawesomeicons.brands.Twitter
import org.famularo.aboutme.ui.theme.AboutMeTheme
import org.famularo.aboutme.viewModels.personViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val vm = getVm()

        setContent {
            AboutMeTheme {
                // A surface container using the 'background' color from the theme
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

    private fun getVm(): personViewModel {
        return personViewModel("Jason Famularo", "Writing software since the 1st Grade")
    }
}

@Composable
fun AboutMeHeader(vm: personViewModel) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Avatar(R.mipmap.avatar)
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(start = 16.dp)) {
            Text(vm.name, style = MaterialTheme.typography.h5)
            Text(vm.tagLine, style = MaterialTheme.typography.caption)
        }
    }
}

@Composable
fun Contact(vm: personViewModel) {
    Column(modifier = Modifier.padding(top = 16.dp)) {
        Text("Contact", style = MaterialTheme.typography.h6)
        ContactSource(FontAwesomeIcons.Brands.Github, "Fammy", "GitHub")
        ContactSource(FontAwesomeIcons.Brands.Twitter, "@splodn", "Twitter")
        ContactSource(FontAwesomeIcons.Brands.Instagram, "@fammacro", "Instragram")
    }
}

@Composable
fun ContactSource(image: ImageVector, username: String, contentDesc: String) {
    Row(verticalAlignment = Alignment.Bottom){
        Icon(image, contentDesc, modifier = Modifier.size(16.dp))
        Text(username, modifier = Modifier.padding(start = 8.dp))
    }
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
            .border(2.dp, Color.DarkGray, CircleShape)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val vm = personViewModel("Jason Famularo", "Writing software since the 1st Grade")

    AboutMeTheme {
        Column(Modifier.padding(16.dp)) {
            AboutMeHeader(vm)
            Contact(vm)
        }
    }
}