package com.example.juslt.modularization.remote

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.Log

/**
 * Created by Juslt on 2019/4/1
 */
class RemoteServiceProvider:ContentProvider(){


    override fun onCreate(): Boolean {
        Log.i("===","${context?.packageName} module provider onCreate")
        return false
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    override fun query(
        uri: Uri,
        projection: Array<String>?,
        selection: String?,
        selectionArgs: Array<String>?,
        sortOrder: String?
    ): Cursor? {
        return RemoteServiceCursor
    }


    override fun update(uri: Uri, values: ContentValues?, selection: String?, selectionArgs: Array<String>?): Int =0
    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int =0
    override fun getType(uri: Uri): String? =null
    override fun insert(uri: Uri, values: ContentValues?): Uri? =null
}