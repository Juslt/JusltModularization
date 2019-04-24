package com.example.juslt.modularization.remote

import android.os.IBinder
import android.util.Log
import com.example.juslt.modularization.JusltCC
import com.example.juslt.modularization.ModuleManager

/**
 * Created by Juslt on 2019/4/1
 */
object RemoteModuleService:IRemoteModuleService.Stub(){
    override fun hasModule(moduleName: String?): Boolean {
        return   ModuleManager.isContainModule(moduleName)
    }

    override fun call(call: RemoteModuleCall?):RemoteModuleResult {
        //获取ModuleName  和 目标bundle

        //接下来的流程和进程内Module调用相同
        Log.i("===","ModuleA call")
        val moduleMessageResult = JusltCC(call!!.moduleName).send()
        return RemoteModuleResult(moduleMessageResult)
        //返回ModuleMessageResult给调用进程
    }
}