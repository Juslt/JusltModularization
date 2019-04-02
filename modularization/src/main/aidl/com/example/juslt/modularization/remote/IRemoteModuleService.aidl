
// IRemoteModuleService.aidl
package com.example.juslt.modularization.remote;
// Declare any non-default types here with import statements
import com.example.juslt.modularization.remote.RemoteModuleCall;
interface IRemoteModuleService {
    boolean hasModule(in String moduleName);
    void call(in RemoteModuleCall call);
}
