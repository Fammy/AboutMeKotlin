package org.famularo.aboutme.viewmodels

data class PersonViewModel(val name: String, val tagLine: String) {
    val socialServices = mutableListOf<SocialLinkViewModel>()
}