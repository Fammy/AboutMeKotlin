package org.famularo.aboutme.viewmodels

import org.famularo.aboutme.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Home : NavigationItem("home", R.drawable.ic_person, "Home")
    object Contact : NavigationItem("profile", R.drawable.ic_contact, "Contact")
}