package com.projects.harbor.mobiledemo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Books
(@SerializedName("title")
 @Expose
 var title: String? = null,
 @SerializedName("imageURL")
 @Expose
 var imageURL: String? = null,
 @SerializedName("author")
 @Expose
 var author: String? = null)
