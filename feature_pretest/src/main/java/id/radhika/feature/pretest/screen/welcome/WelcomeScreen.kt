package id.radhika.feature.pretest.screen.welcome

import android.view.View
import id.radhika.feature.pretest.PretestActivity
import id.radhika.feature.pretest.databinding.ScreenWelcomeBinding
import id.radhika.lib.mvvm.BaseScreen

/**
 * Created by Radhika Yusuf Alifiansyah
 * on 05/Apr/2020
 **/
class WelcomeScreen : BaseScreen<ScreenWelcomeBinding, WelcomeVM, WelcomeDao>(
    ScreenWelcomeBinding::inflate
), View.OnClickListener {
    override fun onViewReady() {
        binding.buttonMulai.setOnClickListener(this)
    }

    override fun render() = { dao: WelcomeDao ->

    }

    override fun getViewModel() = WelcomeVM::class.java

    override fun onClick(v: View?) {
        if (requireActivity() is PretestActivity)
            (requireActivity() as PretestActivity).movePage(true)
    }
}
