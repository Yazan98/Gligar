package com.opensooq.supernova.gligarexample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.opensooq.supernova.gligar.GligarPicker
import com.opensooq.supernova.gligar.ui.GligarScreenResult
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startForResult = registerForActivityResult(object : GligarScreenResult() {
            override fun getGligarIntentLauncher(): Intent {
                return GligarPicker().limit(10).disableCamera(false).cameraDirect(false).requestCode(PICKER_REQUEST_CODE)
                    .withActivity(this@MainActivity).show()
            }
        }) {
            if (!it.isNullOrEmpty()) {
                imagesCount.text = "Number of selected Images: ${it.size}"
            }
        }

        startForResult.launch(0)
    }


}
