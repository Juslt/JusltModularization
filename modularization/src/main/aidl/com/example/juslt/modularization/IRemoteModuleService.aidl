// IRemoteModuleService.aidl
package com.example.juslt.modularization;

// Declare any non-default types here with import statements

interface IRemoteModuleService {
    boolean hasModule(in String moduleName);
    void call();
}
