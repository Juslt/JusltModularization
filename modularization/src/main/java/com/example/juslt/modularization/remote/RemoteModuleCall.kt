package com.example.juslt.modularization.remote

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable

/**
 * Created by Juslt on 2019/4/2
 */
class RemoteModuleCall() : Parcelable{
    lateinit var moduleName: String
    var bundle = Bundle()

    constructor(parcel: Parcel) : this() {
        moduleName = parcel.readString()!!
        bundle = parcel.readBundle(javaClass.classLoader)!!
    }
    constructor(moduleName:String,bundle: Bundle):this(){
        this.moduleName =moduleName
        this.bundle = bundle
    }


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(moduleName)
        parcel.writeBundle(bundle)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RemoteModuleCall> {
        override fun createFromParcel(parcel: Parcel): RemoteModuleCall {
            return RemoteModuleCall(parcel)
        }

        override fun newArray(size: Int): Array<RemoteModuleCall?> {
            return Array(size) {null}
        }
    }
}