package id.radhika.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import id.radhika.feature.latihan1.LatihanPertamaActivity
import id.radhika.feature.pretest.PretestActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pretest.setOnClickListener(this@MainActivity)
        latihan1.setOnClickListener(this@MainActivity)
    }

    override fun onClick(view: View) {
        val clazz: Class<*>? = when (view.id) {
            R.id.pretest -> {
                PretestActivity::class.java
            }
            R.id.latihan1 -> {
                LatihanPertamaActivity::class.java
            }
            else -> null
        }
        startActivity(Intent(this, clazz))
    }
}
