package com.example.juslt.modularization.remote

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by Juslt on 2019/4/1
 */
class RemoteModuleCallback() :Parcelable{
    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RemoteModuleCallback> {
        override fun createFromParcel(parcel: Parcel): RemoteModuleCallback {
            return RemoteModuleCallback(parcel)
        }

        override fun newArray(size: Int): Array<RemoteModuleCallback?> {
            return arrayOfNulls(size)
        }
    }

}