package ed.ed.booksfragmentsapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import ed.ed.booksfragmentsapp.data.BookDatabase
import ed.ed.booksfragmentsapp.models.Book
import ed.ed.booksfragmentsapp.repository.BookRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookViewModel(app: Application): AndroidViewModel(app) {

    val getAllBooks: LiveData<List<Book>>
    private val bookRepository: BookRepository

    init {
        val bookDao = BookDatabase.getDatabase(app).bookDao()
        bookRepository = BookRepository(bookDao)
        getAllBooks = bookRepository.getAllBooks
    }

    fun addBook(book: Book){
        viewModelScope.launch(Dispatchers.IO) {
            bookRepository.addBook(book)
        }
    }
}