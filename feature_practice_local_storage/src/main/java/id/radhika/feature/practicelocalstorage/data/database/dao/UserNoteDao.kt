package id.radhika.feature.practicelocalstorage.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import id.radhika.feature.practicelocalstorage.data.database.entity.UserNoteEntity

/**
 * Created by Radhika Yusuf Alifiansyah
 * on 02/May/2020
 **/

@Dao
interface UserNoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(alternative: UserNoteEntity)

    @Query("SELECT * FROM notesEntity")
    suspend fun getAll(): List<UserNoteEntity>?

    @Query("SELECT * FROM notesEntity WHERE title LIKE :title")
    fun searchNotes(title: String): UserNoteEntity?

    @Query("DELETE FROM notesEntity")
    fun deleteAll()

    @Query("DELETE FROM notesEntity WHERE id = :id")
    fun deleteWithID(id: Long)
}