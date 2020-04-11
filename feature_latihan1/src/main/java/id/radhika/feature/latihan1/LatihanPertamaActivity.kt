package id.radhika.feature.latihan1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_latihan.*

class LatihanPertamaActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_latihan)
        buttonThat.setOnClickListener(this)
        buttonThis.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.buttonThat -> {
                firstFrame.visibility = View.GONE
                secondFrame.visibility = View.VISIBLE
            }
            R.id.buttonThis -> {
                firstFrame.visibility = View.VISIBLE
                secondFrame.visibility = View.GONE
            }
        }
    }

    override fun onBackPressed() {
        if (firstFrame.visibility == View.VISIBLE || secondFrame.visibility == View.VISIBLE) {
            firstFrame.visibility = View.GONE
            secondFrame.visibility = View.GONE
        } else
            super.onBackPressed()
    }
}
