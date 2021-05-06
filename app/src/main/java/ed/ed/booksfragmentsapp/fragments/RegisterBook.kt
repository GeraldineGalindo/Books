package ed.ed.booksfragmentsapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import ed.ed.booksfragmentsapp.R
import ed.ed.booksfragmentsapp.models.Book
import ed.ed.booksfragmentsapp.viewModel.BookViewModel
import kotlinx.android.synthetic.main.fragment_register_book.*
import kotlinx.android.synthetic.main.fragment_register_book.view.*

class RegisterBook : Fragment() {
    private lateinit var bookViewModel: BookViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_register_book, container, false)
        bookViewModel = ViewModelProvider(this).get(BookViewModel::class.java)
        view.btnRegister.setOnClickListener{
            insertDataToDB()
        }

        view.btnCancel.setOnClickListener{
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }
        return view
    }

    private fun insertDataToDB() {
        val title = txtTitleAdd.text.toString()
        val pages = txtPagesAdd.text
        val editorial = txtEditorialAdd.text.toString()
        val author = txtAuthorAdd.text.toString()
        val description = txtDescriptionAdd.text.toString()
        val isbn = txtISBNAdd.text.toString()
        val imagePath = txtImageAdd.text.toString()
        val publishDate = dateAdd.text.toString()

        val book = Book(0, title, Integer.parseInt(pages.toString()), editorial, author, description, isbn, imagePath, publishDate)
        bookViewModel.addBook(book)
        findNavController().navigate(R.id.action_addFragment_to_listFragment)
    }

}