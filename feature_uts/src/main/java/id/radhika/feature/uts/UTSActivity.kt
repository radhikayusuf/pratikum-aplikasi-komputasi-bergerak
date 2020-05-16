package id.radhika.feature.uts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.radhika.feature.uts.screen.register.RegisterScreen
import id.radhika.feature.uts.screen.welcome.WelcomeScreen
import id.radhika.lib.mvvm.util.replaceScreen

/**
 * Created by
 * Nama  : Radhika Yusuf Alifiansyah
 * NIM   : 10117909
 * Kelas : IF6K
 * on 05/Apr/2020
 **/
class UTSActivity : AppCompatActivity() {

    private val registerScreen by lazy { RegisterScreen() }
    private val welcomeScreen by lazy { WelcomeScreen() }

    private var currentPagePosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uts)
        setupFragments()
    }

    private fun setupFragments() {
        supportFragmentManager.replaceScreen(registerScreen, R.id.frameContent)
    }

    override fun onBackPressed() {
        if (currentPagePosition > 0)
            movePage(false)
        else super.onBackPressed()
    }

    fun movePage(next: Boolean, argument: (Bundle.() -> Unit)? = null) {
        if (currentPagePosition >= 1 && !next) {
            finish()
            return
        }
        currentPagePosition += if (next) 1 else -1
        when (currentPagePosition) {
            0 -> supportFragmentManager.replaceScreen(registerScreen, R.id.frameContent, android.R.animator.fade_in, android.R.animator.fade_out)
            else -> supportFragmentManager.replaceScreen(welcomeScreen, R.id.frameContent, android.R.animator.fade_in, android.R.animator.fade_out, argument)
        }
    }
}
