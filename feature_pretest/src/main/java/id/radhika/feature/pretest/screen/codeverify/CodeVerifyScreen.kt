package id.radhika.feature.pretest.screen.codeverify

import android.view.View
import id.radhika.feature.pretest.PretestActivity
import id.radhika.feature.pretest.databinding.ScreenCodeVerifyBinding
import id.radhika.lib.mvvm.BaseScreen

/**
 * Created by Radhika Yusuf Alifiansyah
 * on 05/Apr/2020
 **/
class CodeVerifyScreen : BaseScreen<ScreenCodeVerifyBinding, CodeVerifyVM, CodeVerifyDao>(
    ScreenCodeVerifyBinding::inflate
), View.OnClickListener {

    override fun onViewReady() {
        binding.buttonMasuk.setOnClickListener(this)
    }

    override fun render() = { dao: CodeVerifyDao ->
        binding.inputCode.error = dao.errorCode

        if (requireActivity() is PretestActivity && dao.isValid)
            (requireActivity() as PretestActivity).movePage(true)
    }

    override fun getViewModel() = CodeVerifyVM::class.java

    override fun onClick(v: View?) {
        vm.validateValue(binding.inputCode.text.toString())
    }
}
