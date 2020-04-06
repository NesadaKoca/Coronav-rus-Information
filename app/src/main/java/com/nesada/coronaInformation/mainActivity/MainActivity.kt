package com.nesada.coronaInformation.mainActivity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.nesada.coronaInformation.R
import com.nesada.coronaInformation.adapter.MainAdapter
import com.nesada.coronaInformation.data.Tips
import com.nesada.coronaInformation.utils.SpacesItemDecoration
import kotlinx.android.synthetic.main.activity_main.recyclerView

class MainActivity : AppCompatActivity(),
    MainActivityView {
    lateinit var presenter: MainPresenter
    private lateinit var mainAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this)
        presenter.startNetworkRequest()
    }

    override fun onSuccessful(data: Tips) {
        mainAdapter = MainAdapter(data.allItems)
        recyclerView.adapter = mainAdapter
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.addItemDecoration(
            SpacesItemDecoration(
                this,
                R.dimen.dp15
            )
        )
    }

    override fun onFailure() {
        Toast.makeText(this, "Couldn't load data!", Toast.LENGTH_LONG).show()
    }
}