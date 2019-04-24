package com.example.juslt.modularization.remote

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import com.example.juslt.modularization.ModuleManager
//import com.example.juslt.modularization.remote.RemoteModuleCall
import java.lang.Exception
import java.util.concurrent.ConcurrentHashMap

/**
 * Created by Juslt on 2019/4/1
 */
object RemoteModuleManager {
    private var initialated = false

    private val remoteServiceMap = ConcurrentHashMap<String, IRemoteModuleService>()

    fun dispatchRemote(moduleName: String) {
        if (!initialated) {
            initRemote()
        }

        //IInterface.hasModule判断远程进程是否含有目标module
        val service = findRemoteServiceByModuleName(moduleName)

        //调用远程进程的call方法

        val remoteModuleResult = service?.call(RemoteModuleCall(moduleName, Bundle()))
       Log.i("===Remote Module Result", remoteModuleResult?.success.toString())

    }

    private fun findRemoteServiceByModuleName(moduleName: String) :IRemoteModuleService?{
        val iterator =  remoteServiceMap.iterator()
        while(iterator.hasNext()){
            val entry =iterator.next()

            //TODO try catch 可能抛出remote service 连接异常
            val moduleService = entry.value
            if(moduleService.hasModule(moduleName)) {
               return moduleService
            }
        }

        return null
    }

    private fun dispatch() {

    }

    private fun initRemote() {
        //通过RemoteActivity获取所有可通信进程的包名
        val intent = Intent("action.com.example.juslt.remote.provider")
        val activities = ModuleManager.mContext.packageManager.queryIntentActivities(intent, 0)

        //包名不同的情况下，说明是远程进程
        activities.forEach {
            val packageName = it.activityInfo.packageName
            if (ModuleManager.mContext.packageName != packageName) {
                //尝试连接远程进程
                val service = tryConnection(packageName)
                service?.apply {
                    remoteServiceMap[packageName] = service
                }
            }
        }
        initialated = true

    }

    private fun tryConnection(packageName: String): IRemoteModuleService? {
        //通过包名获取远程进程ContentProvider提供的Binder
        val cursor = ModuleManager.mContext.contentResolver?.query(
            Uri.parse("content://$packageName.juslt.remote/modularization"),
            arrayOf(RemoteServiceProvider::class.java.name),
            null,
            null,
            null
        )
        //（期间生成AIDL）定义 hasModule 和 call方法

        //通过Binder获取AIDL的IInterface
        cursor?.apply {
            try {
                val binder = cursor.extras.getBinder(RemoteModuleService::class.java.name)
                return IRemoteModuleService.Stub.asInterface(binder)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                cursor.close()
            }
        }
        return null
    }
}