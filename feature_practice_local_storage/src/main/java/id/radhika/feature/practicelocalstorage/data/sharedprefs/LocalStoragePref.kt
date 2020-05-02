package id.radhika.feature.practicelocalstorage.data.sharedprefs

import android.app.Application
import android.content.Context
import id.radhika.lib.data.pref.long
import id.radhika.lib.data.pref.string

/**
 * Created by Radhika Yusuf Alifiansyah
 * on 02/May/2020
 **/
class LocalStoragePref(application: Application) {

    private val sharedPref by lazy { application.getSharedPreferences(SHARED_PREF_KEY, Context.MODE_PRIVATE) }

    var lastEdit: Long by sharedPref.long(key = PREF_LAST_EDIT, defaultValue = 0L)

    companion object {
        private const val SHARED_PREF_KEY = "local-storage-pref-key"
        private const val PREF_LAST_EDIT = "last-edit-key"

        private lateinit var INSTANCE: LocalStoragePref

        fun initPref(application: Application) {
            INSTANCE = LocalStoragePref(application)
        }

        fun getInstance(): LocalStoragePref {
            return INSTANCE
        }
    }
}