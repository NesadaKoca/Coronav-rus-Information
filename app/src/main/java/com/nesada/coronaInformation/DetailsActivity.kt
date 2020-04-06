package com.nesada.coronaInformation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.nesada.coronaInformation.data.Tips
import com.nesada.coronaInformation.mainActivity.MainActivityView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity(),
    MainActivityView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        Picasso.with(this).load(intent.getStringExtra("image")).into(itemImage)
        titleItem.text = intent.getStringExtra("title")
        description.text = intent.getStringExtra("description")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSuccessful(data: Tips) {

    }

    override fun onFailure() {

    }
}
