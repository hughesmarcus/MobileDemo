package com.projects.harbor.mobiledemo

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView


class BooksListAdapter(
        var list: List<Books>,
        private val onDetailSelected: (Books) -> Unit
) : RecyclerView.Adapter<BooksListAdapter.BookResultHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookResultHolder {
        val view = parent.inflate(R.layout.book_item)
        return BookResultHolder(view)
    }

    override fun onBindViewHolder(holder: BookResultHolder, position: Int) {
        holder.display(list[position], onDetailSelected)
    }



    override fun getItemCount() = list.size

    inner class BookResultHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val bookItemLayout = item.findViewById<CardView>(R.id.bookItemLayout)
        private val image = item.findViewById<ImageView>(R.id.bookImage)
        private val title = item.findViewById<TextView>(R.id.title)
        private val author = item.findViewById<TextView>(R.id.author)



        fun display(
                book:Books,
                onClick: (Books) -> Unit
        ) {
            bookItemLayout.setOnClickListener { onClick(book) }
            image.loadUrl(book.imageURL)
            title.text = book.title
            author.text = book.author




        }

    }
}