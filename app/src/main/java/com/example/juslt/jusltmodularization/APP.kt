package com.example.juslt.jusltmodularization

import android.app.Application
import com.example.juslt.modularization.ModuleManager

/**
 * Created by Juslt on 2019/3/29
 */
class APP:Application(){

    override fun onCreate() {
        super.onCreate()


        ModuleManager.init(this)
        ModuleManager.register(ModuleSecond())

    }
}