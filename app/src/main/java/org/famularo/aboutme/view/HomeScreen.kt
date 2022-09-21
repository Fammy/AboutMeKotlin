package org.famularo.aboutme.view

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.famularo.aboutme.R
import org.famularo.aboutme.viewmodels.PersonViewModel

@Composable
fun HomeScreen(vm: PersonViewModel) {
    LazyColumn(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
        //.padding(bottom = paddingValues.calculateBottomPadding())
    ) {
        item {
            val image: Painter = painterResource(id = R.mipmap.avatar)
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(346.dp),
                painter = image,
                alignment = Alignment.CenterStart,
                contentDescription = "Me, aka Jason Famularo",
                contentScale = ContentScale.Crop
            )

            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    vm.name,
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.onBackground
                )
                Text(
                    vm.tagLine,
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.onBackground
                )
                About(vm.about)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(PersonViewModel.sample())
}
