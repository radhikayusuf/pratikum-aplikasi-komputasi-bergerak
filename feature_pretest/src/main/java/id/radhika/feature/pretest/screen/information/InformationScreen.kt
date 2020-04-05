package id.radhika.feature.pretest.screen.information

import id.radhika.feature.pretest.databinding.ScreenInformationBinding
import id.radhika.lib.mvvm.BaseScreen

/**
 * Created by Radhika Yusuf Alifiansyah
 * on 05/Apr/2020
 **/
class InformationScreen : BaseScreen<ScreenInformationBinding, CodeVerifyVM, CodeVerifyDao>(
    ScreenInformationBinding::inflate
) {
    override fun onViewReady() {

    }

    override fun render() = { dao: CodeVerifyDao ->

    }

    override fun getViewModel() = CodeVerifyVM::class.java
}
