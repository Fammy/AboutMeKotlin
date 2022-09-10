package org.famularo.aboutme.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.famularo.aboutme.R
import org.famularo.aboutme.viewmodels.PersonViewModel

@Composable
fun Header(vm: PersonViewModel) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Avatar(R.mipmap.avatar)
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(start = 16.dp)) {
            Text(vm.name, style = MaterialTheme.typography.h5)
            Text(vm.tagLine, style = MaterialTheme.typography.caption)
        }
    }
}