package com.vikas.groceryapp.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp()
class GroceryApp : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }


    companion object {
        private var instance: GroceryApp? = null

        //Not being used
        //For future use only
        @Synchronized
        fun getInstance(): GroceryApp? {
            if (instance != null) return instance
            return null
        }
    }
}