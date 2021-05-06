package ed.ed.booksfragmentsapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ed.ed.booksfragmentsapp.models.Book

@Dao
interface IBookDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addBook(book: Book)

    @Query("SELECT * FROM books")
    fun getAllBooks(): LiveData<List<Book>>

}