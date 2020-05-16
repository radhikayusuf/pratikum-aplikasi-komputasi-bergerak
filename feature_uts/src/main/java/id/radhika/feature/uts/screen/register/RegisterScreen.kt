package id.radhika.feature.uts.screen.register

import android.view.View
import id.radhika.feature.uts.UTSActivity
import id.radhika.feature.uts.UTStEnv.ARG_AGE
import id.radhika.feature.uts.UTStEnv.ARG_GENDER
import id.radhika.feature.uts.UTStEnv.ARG_NAME
import id.radhika.feature.uts.databinding.ScreenRegisterUtsBinding
import id.radhika.lib.mvvm.BaseScreen

/**
 * Created by Radhika Yusuf Alifiansyah
 * on 16/May/2020
 **/
class RegisterScreen : BaseScreen<ScreenRegisterUtsBinding, RegisterVM, RegisterDao>(
    ScreenRegisterUtsBinding::inflate
), View.OnClickListener {

    override fun onViewReady() {
        binding.inputName.setOnClickListener(this)
    }

    override fun render() = { dao: RegisterDao ->
        if (dao.errorGender == null) {
            binding.errorGender.visibility = View.GONE
            binding.errorGender.text = ""
        } else {
            binding.errorGender.text = dao.errorGender
            binding.errorGender.visibility = View.VISIBLE
        }

        binding.inputName.error = dao.errorName
        binding.inputUmur.error = dao.errorUmur

        if (dao.isValid && requireActivity() is UTSActivity)
            (requireActivity() as UTSActivity).movePage(true) {
                putString(ARG_NAME, binding.inputName.text.toString())
                putString(ARG_AGE, binding.inputUmur.text.toString())
                putString(ARG_GENDER, if (binding.genderMale.isChecked) "Laki - laki" else "Perempuan")
            }
    }

    override fun getViewModel() = RegisterVM::class.java

    override fun onClick(v: View?) {
        vm.validateValue(
            binding.inputName.text?.toString(),
            binding.inputUmur.text?.toString(),
            binding.genderMale.isChecked,
            binding.genderFemale.isChecked
        )
    }
}
