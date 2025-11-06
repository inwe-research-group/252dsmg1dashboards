package com.dsm.a252dsmdashboards

import android.app.Application
import com.dsm.a252dsmdashboards.data.AppContainer
import com.dsm.a252dsmdashboards.data.DefaultAppContainer

class DashboardApplication: Application() {
    lateinit var container : AppContainer
    override fun onCreate(){
        super.onCreate()
        container= DefaultAppContainer()
    }
}