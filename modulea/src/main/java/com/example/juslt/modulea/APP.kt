package com.example.juslt.modulea

import android.app.Application
import com.example.juslt.modularization.ModuleManager

/**
 * Created by Juslt on 2019/4/1
 */
class APP:Application(){
    override fun onCreate() {
        super.onCreate()
        ModuleManager.updateContext(this)
    }
}