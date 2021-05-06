package ed.ed.booksfragmentsapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ed.ed.booksfragmentsapp.models.Book

@Database(entities = [Book:: class], version = 2, exportSchema = false )
abstract class BookDatabase: RoomDatabase() {
    abstract fun bookDao() : IBookDAO
    companion object {
        @Volatile
        private var INSTANCE: BookDatabase? = null

        fun getDatabase(context: Context):BookDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null ){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BookDatabase::class.java,
                    "book_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}