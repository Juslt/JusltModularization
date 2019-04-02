package com.example.juslt.modulea

import android.util.Log
import com.example.juslt.modularization.IModule
import com.example.juslt.modularization.ModuleMessageResult

/**
 * Created by Juslt on 2019/4/1
 */
class ModuleA(override var name: String) :IModule{
    override fun invoke(): ModuleMessageResult? {
        Log.i("===","ModuleA invoke")
        return ModuleMessageResult.success(name)
    }

}