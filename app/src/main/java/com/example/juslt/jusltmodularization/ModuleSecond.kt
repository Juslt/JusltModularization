package com.example.juslt.jusltmodularization

import android.util.Log
import com.example.juslt.modularization.IModule
import com.example.juslt.modularization.ModuleMessageResult

/**
 * Created by Juslt on 2019/3/29
 */
class ModuleSecond:IModule{
    override var name= "ModuleSecond"
    override fun invoke(): ModuleMessageResult? {
        Log.i("===","ModuleSecond")
        return null
    }

}