package id.radhika.feature.latihan1.screen.secondpractice

import android.view.View
import id.radhika.feature.latihan1.databinding.ScreenSecondBinding
import id.radhika.lib.mvvm.BaseScreen

/**
 * Created by Radhika Yusuf Alifiansyah
 * on 05/Apr/2020
 **/
class SecondScreen : BaseScreen<ScreenSecondBinding, SecondVM, SecondDao>(
    ScreenSecondBinding::inflate
), View.OnClickListener {

    override fun onViewReady() {

    }

    override fun render() = { dao: SecondDao ->

    }

    override fun getViewModel() = SecondVM::class.java

    override fun onClick(v: View?) {

    }
}
