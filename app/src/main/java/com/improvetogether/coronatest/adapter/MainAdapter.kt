package com.improvetogether.coronatest.adapter


import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.improvetogether.coronatest.DetailsActivity
import com.improvetogether.coronatest.R
import com.improvetogether.coronatest.data.Tips
import com.squareup.picasso.Picasso

class MainAdapter(val list: List<Tips.Item?>?) : RecyclerView.Adapter<MainAdapter.ListItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        return ListItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.main_item_single_view, parent, false))
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        holder.itemName.text = list?.get(position)?.title
        Picasso.with(holder.imageView.context).load(list?.get(position)?.image).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    inner class ListItemViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView = itemView.findViewById<ImageView>(R.id.image)
        var itemName = itemView.findViewById<TextView>(R.id.app_name)

        init {
            itemView.setOnClickListener {
                val context = itemView.context
                if(list?.get(adapterPosition)?.description != null){
                    val detailsActivity = Intent(context, DetailsActivity::class.java)
                    detailsActivity.putExtra("image", list[adapterPosition]?.image)
                    detailsActivity.putExtra("title", list[adapterPosition]?.title)
                    detailsActivity.putExtra("description", list[adapterPosition]?.description)
                    context.startActivity(detailsActivity)
                }
            }
        }
    }
}