package ed.ed.booksfragmentsapp.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "books")
class Book (
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val title: String,
    val pages: Int,
    val editorial: String,
    val author: String,
    val description: String,
    val isbn: String
) : Parcelable