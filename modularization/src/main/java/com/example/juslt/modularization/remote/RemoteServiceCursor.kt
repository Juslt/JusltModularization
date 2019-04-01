package com.example.juslt.modularization.remote

import android.database.MatrixCursor
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi

/**
 * Created by Juslt on 2019/4/1
 */
@RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
object RemoteServiceCursor:MatrixCursor(arrayOf(RemoteModuleService::class.java.name)){

    private val extras = Bundle()

    init {
        extras.putBinder(RemoteModuleService::class.java.name,RemoteModuleService)
    }

    override fun getExtras(): Bundle {
        return extras

    }

}