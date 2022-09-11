package org.famularo.aboutme.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun About(about: String) {
    Column(modifier = Modifier.padding(top = 16.dp)) {
        Text("About Me", style = MaterialTheme.typography.h6)
        Spacer(modifier = Modifier.height(8.dp))
        Text(about, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Justify)
    }
}