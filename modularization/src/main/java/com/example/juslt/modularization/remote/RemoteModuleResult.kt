package com.example.juslt.modularization.remote

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import com.example.juslt.modularization.ModuleMessageResult

/**
 * Created by Juslt on 2019/4/23
 */

class RemoteModuleResult():Parcelable{
    var success =0
    var bundle = Bundle()

    constructor(parcel: Parcel) : this() {
        success = parcel.readInt()
        bundle = parcel.readBundle(Bundle::class.java.classLoader)?: Bundle()
    }
    constructor(messageResult: ModuleMessageResult):this(){
        success = messageResult.code
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(success)
        parcel.writeBundle(bundle)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RemoteModuleResult> {
        override fun createFromParcel(parcel: Parcel): RemoteModuleResult {
            return RemoteModuleResult(parcel)
        }

        override fun newArray(size: Int): Array<RemoteModuleResult?> {
            return arrayOfNulls(size)
        }
    }

}