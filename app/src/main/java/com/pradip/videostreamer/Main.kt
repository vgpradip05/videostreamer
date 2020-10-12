package com.pradip.videostreamer


import com.pradip.data.util.daoModule
import com.pradip.data.util.webServiceModule
import com.pradip.core.application.CoreApp
import com.pradip.data.AppDb

/**
 * Android's Application class.
 * Use for 3rd party library init and other setup.
 */
class Main : CoreApp() {

    override fun getDataModules() = arrayOf(
        daoModule(AppDb.getDatabase(applicationContext)),
        webServiceModule
    )

}
