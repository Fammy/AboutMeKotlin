package org.famularo.aboutme.viewmodels

import androidx.compose.ui.graphics.Color
import compose.icons.LineAwesomeIcons
import compose.icons.lineawesomeicons.*
import org.famularo.aboutme.enums.SocialService

data class SocialLinkViewModel(val username: String, val service: SocialService) {
    val contentDescription = service.name;

    val icon = when (service) {
        SocialService.GitHub -> LineAwesomeIcons.Github
        SocialService.Twitter -> LineAwesomeIcons.Twitter
        SocialService.Instagram -> LineAwesomeIcons.Instagram
        SocialService.Homepage -> LineAwesomeIcons.HomeSolid
    }

    val url = when (service) {
        SocialService.GitHub -> "https://github.com/Fammy"
        SocialService.Twitter -> "https://twitter.com/splodn"
        SocialService.Instagram -> "https://www.instagram.com/fammacro/"
        SocialService.Homepage -> "https://famularo.org/"
    }

    val tint = when (service) {
        SocialService.GitHub -> Color.Black
        SocialService.Twitter -> Color(29, 161, 242)
        SocialService.Instagram -> Color(251, 57, 88)
        SocialService.Homepage -> Color.DarkGray
    }
}