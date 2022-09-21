package org.famularo.aboutme.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.famularo.aboutme.viewmodels.PersonViewModel

@Composable
fun ContactScreen(vm: PersonViewModel) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            vm.name,
            style = MaterialTheme.typography.h5,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.onBackground
        )
        Contact(vm)
    }
}

@Preview(showBackground = true)
@Composable
fun ContactScreenPreview() {
    ContactScreen(PersonViewModel.sample())
}
