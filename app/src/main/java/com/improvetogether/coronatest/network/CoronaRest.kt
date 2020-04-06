package com.improvetogether.coronatest.network

import com.improvetogether.coronatest.data.Tips
import retrofit2.Call
import retrofit2.http.GET


interface CoronaRest {
    @get:GET("NesadaKoca/Jsons/master/app/src/main/assets/coronavirus")
    val getTips: Call<Tips>
}