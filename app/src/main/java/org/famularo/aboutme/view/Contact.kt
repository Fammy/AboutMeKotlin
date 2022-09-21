package org.famularo.aboutme.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.famularo.aboutme.viewmodels.PersonViewModel

@Composable
fun Contact(vm: PersonViewModel) {
    Column(modifier = Modifier.padding(top = 16.dp)) {
        Text("Contact", style = MaterialTheme.typography.h6, color = MaterialTheme.colors.onBackground)
        Spacer(modifier = Modifier.height(8.dp))

        for (link in vm.socialServices) {
            SocialLink(link)
        }
    }
}