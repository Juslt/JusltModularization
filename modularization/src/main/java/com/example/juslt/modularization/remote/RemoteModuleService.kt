package com.example.juslt.modularization.remote

import android.util.Log
import com.example.juslt.modularization.IRemoteModuleService

/**
 * Created by Juslt on 2019/4/1
 */
object RemoteModuleService:IRemoteModuleService.Stub(){
    override fun hasModule(moduleName: String?): Boolean {
        return true
    }

    override fun call() {
        //接下来的流程和进程内Module调用相同
        Log.i("===","Modulea call")
    }

}