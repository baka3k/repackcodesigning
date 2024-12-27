package com.callstack.repack

import com.facebook.react.TurboReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.model.ReactModuleInfo
import com.facebook.react.module.model.ReactModuleInfoProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import java.security.PublicKey

class ScriptManagerPackage(
    private val publicKey: PublicKey? = null,
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO
) : TurboReactPackage() {
    override fun getModule(name: String, reactContext: ReactApplicationContext): NativeModule? {
        return if (name == ScriptManagerModule.NAME) {
            ScriptManagerModule(
                reactContext,
                publicKey = publicKey,
                coroutineDispatcher = coroutineDispatcher
            )
        } else {
            null
        }
    }

    override fun getReactModuleInfoProvider(): ReactModuleInfoProvider {
        return ReactModuleInfoProvider {
            val moduleInfos: MutableMap<String, ReactModuleInfo> = HashMap()
            val isTurboModule: Boolean = BuildConfig.IS_NEW_ARCHITECTURE_ENABLED
            // Use deprecated constructor for backwards compatibility
            moduleInfos[ScriptManagerModule.NAME] = ReactModuleInfo(
                ScriptManagerModule.NAME,
                ScriptManagerModule.NAME,
                false,
                true,
                false,
                false,
                isTurboModule
            )
            moduleInfos
        }
    }
}
