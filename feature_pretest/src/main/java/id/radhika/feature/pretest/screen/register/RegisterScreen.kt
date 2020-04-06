package id.radhika.feature.pretest.screen.register

import android.view.View
import id.radhika.feature.pretest.PretestActivity
import id.radhika.feature.pretest.databinding.ScreenRegisterBinding
import id.radhika.feature.pretest.PretestEnv.ARG_NAME
import id.radhika.lib.mvvm.BaseScreen

/**
 * Created by Radhika Yusuf Alifiansyah
 * on 05/Apr/2020
 **/
class RegisterScreen : BaseScreen<ScreenRegisterBinding, RegisterVM, RegisterDao>(
    ScreenRegisterBinding::inflate
), View.OnClickListener {

    override fun onViewReady() {
        binding.buttonNext.setOnClickListener(this)
    }

    override fun render() = { dao: RegisterDao ->
        binding.inputNama.error = dao.errorName
        binding.inputUmur.error = dao.errorUmur

        if (dao.isValid && requireActivity() is PretestActivity)
                (requireActivity() as PretestActivity).movePage(true) {
                    putString(ARG_NAME, binding.inputNama.text.toString())
                }
    }

    override fun getViewModel() = RegisterVM::class.java

    override fun onClick(v: View?) {
        vm.validateValue(
            binding.inputNama.text?.toString(),
            binding.inputUmur.text?.toString()
        )
    }
}
