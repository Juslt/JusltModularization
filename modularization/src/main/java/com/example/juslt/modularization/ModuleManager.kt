package com.example.juslt.modularization

import android.app.Application
import java.util.concurrent.ConcurrentHashMap

/**
 * Created by Juslt on 2019/3/29
 */

object ModuleManager{
    //维护本地Module的集合
    private val moduleMap = ConcurrentHashMap<String,IModule>()

    fun init(application: Application){

    }
    //加入Module到本地集合
    fun register(module:IModule){
        moduleMap[module.name] = module
    }

    //向下分发事件
    fun dispatch(moduleName:String){

        if(moduleMap.containsKey(moduleName)){
            //本地处理Module
            val module = moduleMap[moduleName]
            module?.invoke()
        }else{
            //请求远程Module处理
        }
    }

    private fun dispatchLocal(){

    }
}