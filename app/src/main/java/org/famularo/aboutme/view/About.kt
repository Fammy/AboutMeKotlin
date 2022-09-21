package org.famularo.aboutme.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun About(about: String) {
    Column(modifier = Modifier.padding(top = 16.dp)) {
        Text("About Me", style = MaterialTheme.typography.h6, color = MaterialTheme.colors.onBackground)
        Spacer(modifier = Modifier.height(8.dp))
        Text(about, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Justify, color = MaterialTheme.colors.onBackground)
    }
}

@Preview(showBackground = true)
@Composable
fun AboutPreview() {
    About("A paragrah or so")
}