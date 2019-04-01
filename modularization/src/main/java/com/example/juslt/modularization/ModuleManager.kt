package com.example.juslt.modularization

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.os.Build
import android.support.annotation.RequiresApi
import com.example.juslt.modularization.remote.RemoteModuleManager
import java.util.concurrent.ConcurrentHashMap

/**
 * Created by Juslt on 2019/3/29
 */

@SuppressLint("StaticFieldLeak")
object ModuleManager{
    //维护本地Module的集合
    private val moduleMap = ConcurrentHashMap<String,IModule>()
    lateinit var mContext:Context
    fun init(application: Application){

    }

    fun updateContext(context: Context){
        this.mContext = context
    }

    //加入Module到本地集合
    fun register(module:IModule){
        moduleMap[module.name] = module
    }

    //向下分发事件
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    fun dispatch(moduleName:String){

        if(moduleMap.containsKey(moduleName)){
            //本地处理Module
            val module = moduleMap[moduleName]
            module?.invoke()
        }else{
            //请求远程Module处理
            RemoteModuleManager.dispatchRemote(moduleName)
        }
    }

    private fun dispatchLocal(){

    }
}