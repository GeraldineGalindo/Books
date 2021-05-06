package ed.ed.booksfragmentsapp.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ed.ed.booksfragmentsapp.R
import ed.ed.booksfragmentsapp.models.Book
import kotlinx.android.synthetic.main.book_row.view.*

class BookListAdapter: RecyclerView.Adapter<BookListAdapter.MyViewHolder>(){
    private var bookList = emptyList<Book>()
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.book_row, parent, false))
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val book = bookList[position]
        holder.itemView.txtTitle.text = book.title
        holder.itemView.txtAuthor.text = book.author
        holder.itemView.txtPages.text = book.pages.toString()
        holder.itemView.txtEditorial.text = book.editorial
        holder.itemView.txtDescription.text = book.description
    }

    fun setData(books: List<Book>){
        this.bookList = books
        notifyDataSetChanged()
    }
}