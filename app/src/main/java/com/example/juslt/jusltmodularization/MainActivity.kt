package com.example.juslt.jusltmodularization

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.juslt.modularization.JusltCC
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_send_local_module.setOnClickListener {
            JusltCC("ModuleSecond")
                .send()
        }

        btn_send_module_a.setOnClickListener {
            JusltCC("ModuleA").send()
        }
    }
}
