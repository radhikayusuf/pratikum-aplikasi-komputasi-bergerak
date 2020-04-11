package id.radhika.feature.latihan1.screen.firstpractice

import android.view.View
import id.radhika.feature.latihan1.databinding.ScreenFirstBinding
import id.radhika.lib.mvvm.BaseScreen

/**
 * Created by Radhika Yusuf Alifiansyah
 * on 05/Apr/2020
 **/
class FirstScreen : BaseScreen<ScreenFirstBinding, FirstVM, FirstDao>(
    ScreenFirstBinding::inflate
), View.OnClickListener {

    override fun onViewReady() {

    }

    override fun render() = { dao: FirstDao ->

    }

    override fun getViewModel() = FirstVM::class.java

    override fun onClick(v: View?) {

    }
}
