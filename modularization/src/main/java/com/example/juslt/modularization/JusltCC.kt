package com.example.juslt.modularization

import android.os.Bundle

/**
 * Created by Juslt on 2019/3/29
 */
class JusltCC(private val moduleName:String){
    val bundle = Bundle()

    //发送消息
    fun send():ModuleMessageResult{
        return ModuleManager.dispatch(moduleName)
    }

    //定义目标Module的action事件


}