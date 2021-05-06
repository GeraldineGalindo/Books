package ed.ed.booksfragmentsapp.repository

import androidx.lifecycle.LiveData
import ed.ed.booksfragmentsapp.data.IBookDAO
import ed.ed.booksfragmentsapp.models.Book

class BookRepository (private val bookDAO: IBookDAO){

    val getAllBooks: LiveData<List<Book>> = bookDAO.getAllBooks()

    suspend fun addBook(book: Book){
        bookDAO.addBook(book)
    }
}