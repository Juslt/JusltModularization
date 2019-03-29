package com.example.juslt.modularization

/**
 * Created by Juslt on 2019/3/29
 */
interface IModule{
    var name:String
    fun invoke():ModuleMessageResult?
}