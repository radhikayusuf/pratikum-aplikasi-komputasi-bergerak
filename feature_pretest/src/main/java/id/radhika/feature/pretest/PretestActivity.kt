package id.radhika.feature.pretest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.radhika.feature.pretest.screen.codeverify.CodeVerifyScreen
import id.radhika.feature.pretest.screen.information.InformationScreen
import id.radhika.feature.pretest.screen.register.RegisterScreen
import id.radhika.feature.pretest.screen.welcome.WelcomeScreen
import id.radhika.lib.mvvm.util.*

class PretestActivity : AppCompatActivity() {

    private val welcomeScreen by lazy { WelcomeScreen() }
    private val codeVerifyScreen by lazy { CodeVerifyScreen() }
    private val registerScreen by lazy { RegisterScreen() }
    private val informationScreen by lazy { InformationScreen() }

    private var currentPagePosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pretest)
        setupFragments()
    }

    private fun setupFragments() {
        supportFragmentManager.replaceScreen(welcomeScreen, R.id.frameContent)
    }

    override fun onBackPressed() {
        if (currentPagePosition > 0)
            movePage(false)
        else super.onBackPressed()
    }

    fun movePage(next: Boolean, argument: (Bundle.() -> Unit)? = null) {
        if (currentPagePosition >= 3 && !next) {
            finish()
            return
        }
        currentPagePosition += if (next) 1 else -1
        when (currentPagePosition) {
            1 -> supportFragmentManager.replaceScreen(codeVerifyScreen, R.id.frameContent, android.R.animator.fade_in, android.R.animator.fade_out)
            2 -> supportFragmentManager.replaceScreen(registerScreen, R.id.frameContent, android.R.animator.fade_in, android.R.animator.fade_out)
            3 -> supportFragmentManager.replaceScreen(informationScreen, R.id.frameContent, android.R.animator.fade_in, android.R.animator.fade_out, argument)
            else -> supportFragmentManager.replaceScreen(welcomeScreen, R.id.frameContent, android.R.animator.fade_in, android.R.animator.fade_out)
        }
    }
}
