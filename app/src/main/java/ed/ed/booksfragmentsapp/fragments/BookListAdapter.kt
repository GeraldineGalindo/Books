package ed.ed.booksfragmentsapp.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
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
        val picasso = Picasso.get()
        val book = bookList[position]
        holder.itemView.txtTitle.text = book.title
        holder.itemView.txtAuthor.text = book.author
        holder.itemView.txtPages.text = book.pages.toString()
        holder.itemView.txtEditorial.text = book.editorial
        holder.itemView.txtDescription.text = book.description
        holder.itemView.txtIsbn.text = book.isbn
        picasso.load("https://cdn.domestika.org/c_limit,dpr_1.0,f_auto,q_auto,w_663/v1540461180/content-items/002/573/817/WEB_Abbati_Sjoberg.artecollezionaremosche_-original.jpg?1540461180").into(holder.itemView.imageView)
    }

    fun setData(books: List<Book>){
        this.bookList = books
        notifyDataSetChanged()
    }
}