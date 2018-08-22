package com.projects.harbor.mobiledemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val retrofit = Retrofit.Builder()
                .baseUrl("https://de-coding-test.s3.amazonaws.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service = retrofit.create<EbayService>(EbayService::class.java!!)
        val books = service.listRepos()
        prepareListView()
        books.enqueue(object: Callback<List<Books>> {
            override fun onResponse(call:Call<List<Books>>, books:Response<List<Books>>) {
                if (books.isSuccessful)
                {
                    showProposalsItemList(books.body()!!)
                }
                else
                {

                }
            }
           override fun onFailure(call:Call<List<Books>>, t:Throwable) {

            }
        })


    }


    private fun prepareListView() {
        book_list.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        book_list.adapter = BooksListAdapter(
                mutableListOf(),
                ::onBookSelected
        )

    }
    private fun showProposalsItemList(newList: List<Books>) {
        val adapter: BooksListAdapter = book_list.adapter as BooksListAdapter
        adapter.list = newList
        adapter.notifyDataSetChanged()
    }
    private fun onBookSelected(book: Books) {

    }
}
