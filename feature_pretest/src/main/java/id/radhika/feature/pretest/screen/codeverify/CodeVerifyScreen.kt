package id.radhika.feature.pretest.screen.codeverify

import id.radhika.feature.pretest.databinding.ScreenCodeVerifyBinding
import id.radhika.lib.mvvm.BaseScreen

/**
 * Created by Radhika Yusuf Alifiansyah
 * on 05/Apr/2020
 **/
class CodeVerifyScreen : BaseScreen<ScreenCodeVerifyBinding, CodeVerifyVM, CodeVerifyDao>(
    ScreenCodeVerifyBinding::inflate
) {
    override fun onViewReady() {

    }

    override fun render() = { dao: CodeVerifyDao ->

    }

    override fun getViewModel() = CodeVerifyVM::class.java
}
