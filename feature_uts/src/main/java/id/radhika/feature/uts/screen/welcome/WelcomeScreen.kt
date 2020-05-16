package id.radhika.feature.uts.screen.welcome

import id.radhika.feature.uts.R
import id.radhika.feature.uts.UTStEnv
import id.radhika.feature.uts.databinding.ScreenUtsWelcomeBinding
import id.radhika.lib.mvvm.BaseScreen

/**
 * Created by Radhika Yusuf Alifiansyah
 * on 16/May/2020
 **/
class WelcomeScreen : BaseScreen<ScreenUtsWelcomeBinding, WelcomeVM, WelcomeDao>(
    ScreenUtsWelcomeBinding::inflate
) {
    private val name by lazy { arguments?.getString(UTStEnv.ARG_NAME, "") ?: "" }
    private val age by lazy { arguments?.getString(UTStEnv.ARG_AGE, "") ?: "" }
    private val gender by lazy { arguments?.getString(UTStEnv.ARG_GENDER, "") ?: "" }

    override fun onViewReady() {
        binding.textWelcomeContent.text =
            getString(R.string.text_welcome_description, name, gender, age)
    }

    override fun render() = { dao: WelcomeDao ->

    }

    override fun getViewModel() = WelcomeVM::class.java

}