package id.radhika.feature.pretest.screen.information

import id.radhika.feature.pretest.databinding.ScreenInformationBinding
import id.radhika.feature.pretest.screen.codeverify.CodeVerifyDao
import id.radhika.feature.pretest.screen.codeverify.CodeVerifyVM
import id.radhika.lib.mvvm.BaseScreen

/**
 * Created by Radhika Yusuf Alifiansyah
 * on 05/Apr/2020
 **/
class InformationScreen : BaseScreen<ScreenInformationBinding, InformationVM, InformationDao>(
    ScreenInformationBinding::inflate
) {
    override fun onViewReady() {
        binding.pageName.text = "Information Screen"
    }

    override fun render() = { dao: InformationDao ->

    }

    override fun getViewModel() = InformationVM::class.java
}
