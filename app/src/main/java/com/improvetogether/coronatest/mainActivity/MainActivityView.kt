package com.improvetogether.coronatest.mainActivity

import com.improvetogether.coronatest.data.Tips


interface MainActivityView {
    fun onSuccessful(data: Tips)
    fun onFailure()
}