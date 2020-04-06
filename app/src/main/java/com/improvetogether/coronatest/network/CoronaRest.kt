package com.improvetogether.coronatest.network

import com.improvetogether.coronatest.Post
import com.improvetogether.coronatest.data.Tips
import retrofit2.Call
import retrofit2.http.GET


interface CoronaRest {
    @get:GET("ArtanElezaj/Test1234/Test1234/app/src/main/java/com/example/test/assets/coronavirus")
    val getTips: Call<Tips>

    @GET("posts")
    fun getPosts(): Call<List<Post?>?>?
}