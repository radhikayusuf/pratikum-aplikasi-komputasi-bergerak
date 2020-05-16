package id.radhika.feature.practicelocalstorage.data.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import id.radhika.feature.practicelocalstorage.data.database.dao.UserNoteDao
import id.radhika.feature.practicelocalstorage.data.database.entity.UserNoteEntity

/**
 * Created by Radhika Yusuf Alifiansyah
 * on 02/May/2020
 **/
@Database(entities = [(UserNoteEntity::class)], version = 1, exportSchema = false)
abstract class NotesDatabase : RoomDatabase() {

    abstract fun userNoteDao(): UserNoteDao

    companion object {
        private const val databaseName = "notes-db"
        private lateinit var databaseInstance: NotesDatabase

        fun initDatabase(app: Application) {
            databaseInstance = Room.databaseBuilder(
                app,
                NotesDatabase::class.java,
                databaseName
            ).fallbackToDestructiveMigration().build()
        }

        val userNoteDao by lazy { databaseInstance.userNoteDao() }
    }
}