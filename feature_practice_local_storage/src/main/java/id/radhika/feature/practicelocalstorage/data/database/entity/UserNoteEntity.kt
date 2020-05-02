package id.radhika.feature.practicelocalstorage.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Radhika Yusuf Alifiansyah
 * on 02/May/2020
 **/
@Entity(tableName = "notesEntity")
data class UserNoteEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id: Long = 0,
    @ColumnInfo(name = "title") var title: String = "",
    @ColumnInfo(name = "notes") var notes: String = "",
    @ColumnInfo(name = "dateTime") var dateTime: Long = 0,
    @ColumnInfo(name = "userName") var userName: String = ""
)