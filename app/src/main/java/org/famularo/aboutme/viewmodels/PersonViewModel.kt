package org.famularo.aboutme.viewmodels

import org.famularo.aboutme.enums.SocialService

data class PersonViewModel(val name: String, val tagLine: String, val about: String) {
    val socialServices = mutableListOf<SocialLinkViewModel>()

    companion object SampleData {
        fun sample() : PersonViewModel {
            val vm = PersonViewModel(
                "Jason Famularo",
                "Developer, Dad, Dork, Donut Devourer",
                "I first fell in love with programming in first grade. My teacher had a unit on BASIC programming on the TRS-80 and Apple ][. I knew from that point I wanted to be a programmer (astronaut was my runner-up choice).")
            vm.socialServices.add(SocialLinkViewModel("Fammy", SocialService.GitHub))
            vm.socialServices.add(SocialLinkViewModel("@splodn", SocialService.Twitter))
            vm.socialServices.add(SocialLinkViewModel("@fammacro", SocialService.Instagram))
            vm.socialServices.add(SocialLinkViewModel("Homepage", SocialService.Homepage))
            return vm
        }
    }
}


