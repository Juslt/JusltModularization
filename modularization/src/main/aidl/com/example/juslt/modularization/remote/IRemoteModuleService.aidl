
// IRemoteModuleService.aidl
package com.example.juslt.modularization.remote;
// Declare any non-default types here with import statements
import com.example.juslt.modularization.remote.RemoteModuleCall;
import com.example.juslt.modularization.remote.RemoteModuleResult;
interface IRemoteModuleService {
    boolean hasModule(in String moduleName);
    RemoteModuleResult call(in RemoteModuleCall call);
}
