package com.example.juslt.modularization

import android.util.Log

/**
 * Created by Juslt on 2019/3/29
 */
class ModuleMessageResult(val code: Int, val message: String) {
    companion object {
        val resultSuccess = 1
        val ERROR_NOT_FOUND =0
        val ERROR_EXEC_FAIL=-1

        fun errorNotFound(moduleName:String):ModuleMessageResult{
            return ModuleMessageResult(ERROR_NOT_FOUND,"$moduleName Not Found!")
        }

        fun success(moduleName: String):ModuleMessageResult{
            return ModuleMessageResult(resultSuccess,"$moduleName success")
        }

        fun errorExecFail(moduleName: String):ModuleMessageResult{
            return ModuleMessageResult(ERROR_EXEC_FAIL,"$moduleName execute fail")
        }
    }

    init {
        Log.i("===","ModuleMessageResult:$code-------$message")
    }
}