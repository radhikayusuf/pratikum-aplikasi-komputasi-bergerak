package id.radhika.feature.pretest.screen.register

import id.radhika.feature.pretest.databinding.ScreenRegisterBinding
import id.radhika.feature.pretest.screen.welcome.InformationVM
import id.radhika.lib.mvvm.BaseScreen

/**
 * Created by Radhika Yusuf Alifiansyah
 * on 05/Apr/2020
 **/
class RegisterScreen : BaseScreen<ScreenRegisterBinding, InformationVM, InformationDao>(
    ScreenRegisterBinding::inflate
) {
    override fun onViewReady() {

    }

    override fun render() = { dao: InformationDao ->

    }

    override fun getViewModel() = InformationVM::class.java
}
