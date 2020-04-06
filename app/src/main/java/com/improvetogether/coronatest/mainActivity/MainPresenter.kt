package com.improvetogether.coronatest.mainActivity

import com.improvetogether.coronatest.data.Tips

class MainPresenter(val mainActivityView: MainActivityView?) {
    private var mainInteractor: MainInteractor = MainInteractor(this)

    fun startNetworkRequest() {
        mainInteractor.startNetworkRequest()
    }

    fun onSuccessful(data: Tips?) {
        if(data?.allItems == null){
            onFailure()
            return
        }
        mainActivityView?.onSuccessful(data)
    }

    fun onFailure() {
        mainActivityView?.onFailure()
    }
}
