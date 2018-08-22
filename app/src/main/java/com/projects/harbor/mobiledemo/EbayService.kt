package com.projects.harbor.mobiledemo

import retrofit2.Call
import retrofit2.http.GET


interface EbayService {
    @GET("books.json")
    fun listRepos(): Call<List<Books>>
}
