package id.radhika.feature.pretest.screen.welcome

import id.radhika.feature.pretest.databinding.ScreenWelcomeBinding
import id.radhika.lib.mvvm.BaseScreen

/**
 * Created by Radhika Yusuf Alifiansyah
 * on 05/Apr/2020
 **/
class WelcomeScreen : BaseScreen<ScreenWelcomeBinding, WelcomeVM, WelcomeDao>(
    ScreenWelcomeBinding::inflate
) {
    override fun onViewReady() {

    }

    override fun render() = { dao: WelcomeDao ->

    }

    override fun getViewModel() = WelcomeVM::class.java
}
