package id.radhika.feature.practicelocalstorage.screen.localstorage

import id.radhika.feature.practicelocalstorage.data.database.NotesDatabase
import id.radhika.feature.practicelocalstorage.data.database.entity.UserNoteEntity
import id.radhika.feature.practicelocalstorage.data.sharedprefs.LocalStoragePref
import id.radhika.lib.mvvm.BaseDao
import id.radhika.lib.mvvm.util.LiveDao
import id.radhika.lib.mvvm.util.getValue
import id.radhika.lib.mvvm.util.setValue

/**
 * Created by Radhika Yusuf Alifiansyah
 * on 02/May/2020
 **/
class LocalStorageDao : BaseDao() {

    val sharedPref by lazy { LocalStoragePref.getInstance() }
    val userNotesDao by lazy { NotesDatabase.userNoteDao }

    suspend fun contentNotesData()= userNotesDao.getAll().orEmpty()

    private val notesData: LiveDao<MutableList<UserNoteEntity>> = LiveDao(mutableListOf())
    var notes by notesData::content

    private val lastEditedData: LiveDao<Long> = LiveDao(sharedPref.lastEdit)

    var lastEdited: Long
    set(value) { lastEditedData.content = value; sharedPref.lastEdit = value }
    get() { return lastEditedData.content }

    var recentUserSearch = ""
}