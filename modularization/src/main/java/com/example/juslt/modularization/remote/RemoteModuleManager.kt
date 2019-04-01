package com.example.juslt.modularization.remote

import android.content.Intent
import android.net.Uri
import com.example.juslt.modularization.IRemoteModuleService
import com.example.juslt.modularization.ModuleManager
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
       val iterator =  remoteServiceMap.iterator()
        if(iterator.hasNext()){
            val entry =iterator.next()
            val moduleService = entry.value
           if(moduleService.hasModule(moduleName)) {
               //如果有Module，执行module 的call方法
               moduleService.call()
           }
        }

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