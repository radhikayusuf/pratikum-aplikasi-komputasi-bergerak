package id.radhika.feature.practicelocalstorage.screen.localstorage

import androidx.lifecycle.viewModelScope
import id.radhika.feature.practicelocalstorage.data.LocalStorageUseCase
import id.radhika.feature.practicelocalstorage.data.database.entity.UserNoteEntity
import id.radhika.lib.mvvm.BaseVM
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by Radhika Yusuf Alifiansyah
 * on 02/May/2020
 **/
class LocalStorageVM : BaseVM<LocalStorageDao, LocalStorageUseCase>() {

    override suspend fun onCreate() { }

    suspend fun searchNotes(text: String) {
        contentData.apply {
            recentUserSearch = text
            notes = filterData(text, contentNotesData())
        }
    }

    suspend fun refreshData() {
        contentData.apply {
            notes = filterData(recentUserSearch, contentNotesData())
        }
    }

    fun insertNotes(title: String, notes: String) {
        contentData.lastEdited = System.currentTimeMillis()
        viewModelScope.launch(Dispatchers.IO) {
            contentData.userNotesDao.insert(UserNoteEntity(title = title, notes = notes, dateTime = contentData.lastEdited))
            refreshData()
        }
    }

    fun deleteItem(item: UserNoteEntity) {
        contentData.lastEdited = System.currentTimeMillis()
        viewModelScope.launch(Dispatchers.IO) {
            contentData.userNotesDao.deleteWithID(item.id)
            refreshData()
        }
    }

    fun filterData(text: String, data: List<UserNoteEntity>): MutableList<UserNoteEntity> =
        if (text.isNotEmpty()) {
            data.filter { it.notes.contains(text) || it.title.contains(text) }.toMutableList()
        } else {
            data.toMutableList()
        }

    override fun getDao() = LocalStorageDao()

    override fun createUseCase(): LocalStorageUseCase = LocalStorageUseCase()
}