package id.radhika.feature.pretest.screen.information

import android.view.View
import id.radhika.feature.pretest.PretestEnv.ARG_NAME
import id.radhika.feature.pretest.R
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
), View.OnClickListener {

    override fun onViewReady() {
        arguments?.getString(ARG_NAME)?.let {
            // Expected 3 args
            binding.informationPage.text = getString(R.string.text_information, it, it, it)
        }
        binding.buttonOk.setOnClickListener(this)
    }

    override fun render() = { dao: InformationDao -> }

    override fun onClick(v: View?) {
        requireActivity().finish()
    }

    override fun getViewModel() = InformationVM::class.java
}
