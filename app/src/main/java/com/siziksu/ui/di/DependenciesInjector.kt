package com.siziksu.ui.di

import android.app.Application
import com.siziksu.ui.di.module.viewModule
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.Module

fun Application.startInjector() {
    val list = ArrayList<Module>()
    list.addAll(appModules())
    return startKoin(this, list)
}

fun appModules(): List<Module> {
    return listOf(
        viewModule
    )
}
