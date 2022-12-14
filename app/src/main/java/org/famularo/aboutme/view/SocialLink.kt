package org.famularo.aboutme.view

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import org.famularo.aboutme.enums.SocialService
import org.famularo.aboutme.ui.theme.Typography
import org.famularo.aboutme.viewmodels.SocialLinkViewModel

@Composable
fun SocialLink(link: SocialLinkViewModel) {
    val context = LocalContext.current;
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.clickable {
        openUrl(context, link.url)
    })
    {
        Icon(link.icon, link.contentDescription, Modifier.size(32.dp), link.tint(isSystemInDarkTheme()))
        Text(link.username, modifier = Modifier.padding(start = 8.dp), style = Typography.body1, color = MaterialTheme.colors.onBackground)
    }
}

fun openUrl(context: Context, url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    ContextCompat.startActivity(context, intent, null)
}

@Preview(showBackground = true)
@Composable
fun SocialLinkPreview() {
    SocialLink(SocialLinkViewModel("Fammy", SocialService.Twitter))
}