package com.nesada.coronaInformation.network

import com.nesada.coronaInformation.data.Tips
import retrofit2.Call
import retrofit2.http.GET


interface CoronaRest {
    @get:GET("NesadaKoca/Jsons/master/app/src/main/assets/coronavirus")
    val getTips: Call<Tips>
}