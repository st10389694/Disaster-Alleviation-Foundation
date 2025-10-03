package za.ac.innosphere.disaster

import android.app.Application
import za.ac.innosphere.disaster.data.AppDatabase

class App : Application() {
    companion object {
        lateinit var instance: App
            private set
    }
    lateinit var database: AppDatabase

    override fun onCreate() {
        super.onCreate()
        instance = this
        database = AppDatabase.getDatabase(this)
    }
}
