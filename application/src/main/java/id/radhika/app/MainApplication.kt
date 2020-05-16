package id.radhika.app

import android.app.Application
import id.radhika.feature.practicelocalstorage.data.database.NotesDatabase
import id.radhika.feature.practicelocalstorage.data.sharedprefs.LocalStoragePref

/**
 * Created by
 * Nama  : Radhika Yusuf Alifiansyah
 * NIM   : 10117909
 * Kelas : IF6K
 * on 05/Apr/2020
 **/
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setupInternalStorage()
    }

    private fun setupInternalStorage() {
        NotesDatabase.initDatabase(this@MainApplication)
        LocalStoragePref.initPref(this@MainApplication)
    }
}