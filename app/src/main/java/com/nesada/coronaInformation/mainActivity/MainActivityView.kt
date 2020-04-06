package com.nesada.coronaInformation.mainActivity

import com.nesada.coronaInformation.data.Tips


interface MainActivityView {
    fun onSuccessful(data: Tips)
    fun onFailure()
}