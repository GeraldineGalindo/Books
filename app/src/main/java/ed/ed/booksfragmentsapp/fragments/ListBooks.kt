package ed.ed.booksfragmentsapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ed.ed.booksfragmentsapp.R
import ed.ed.booksfragmentsapp.viewModel.BookViewModel
import kotlinx.android.synthetic.main.fragment_list_books.view.*

class ListBooks : Fragment() {
    private lateinit var bookViewModel: BookViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list_books, container, false)
        //Settings for Recycler view
        val recyclerAdapter = BookListAdapter()
        val recyclerView = view.recyclerView
        recyclerView.adapter = recyclerAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //BookViewModel
        bookViewModel = ViewModelProvider(this).get(BookViewModel::class.java)
        bookViewModel.getAllBooks.observe(viewLifecycleOwner, Observer { book -> recyclerAdapter.setData(book) })

        view.btnGoToRegister.setOnClickListener{
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }


        return view
    }
}