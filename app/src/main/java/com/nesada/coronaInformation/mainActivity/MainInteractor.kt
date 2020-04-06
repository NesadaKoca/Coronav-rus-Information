package com.nesada.coronaInformation.mainActivity

import com.nesada.coronaInformation.data.Tips
import com.nesada.coronaInformation.network.CoronaRest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainInteractor(val mainPresenter: MainPresenter) {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://raw.githubusercontent.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val coronaRest: CoronaRest = retrofit.create(
        CoronaRest::class.java)

    fun startNetworkRequest() {
        val call = coronaRest.getTips
            call.enqueue(object : Callback<Tips> {
                override fun onResponse(call: Call<Tips>?, response: Response<Tips>) {
                    if (response.isSuccessful) {
                        val data = response.body()
                        mainPresenter.onSuccessful(data)
                    } else {
                        mainPresenter.onFailure()
                    }
                }

                override fun onFailure(call: Call<Tips>?, t: Throwable) {
                    mainPresenter.onFailure()
                }
            })
    }
}