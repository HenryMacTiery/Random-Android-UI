package com.timac.zoomrecylerlayout.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.timac.zoomrecylerlayout.R

class RecyclerAdapter(
    private var image: List<Int>,
    private var titile: List<String>,
    private var rating: List<Int>
) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemImage: ImageView = itemView.findViewById(R.id.iv_image)
        val itemRating: RatingBar = itemView.findViewById(R.id.card_rating_bar)
        val itemTitle: TextView = itemView.findViewById(R.id.tv_destination)

        init {
            /// takes care of click events
            itemView.setOnClickListener {
                val position: Int = adapterPosition
                Toast.makeText(itemView.context, titile[position], Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.itemImage.setImageResource(image[position])
        holder.itemTitle.text = titile[position]
        holder.itemRating.rating = rating[position].toFloat()
    }

    override fun getItemCount(): Int {
        //Can return the image, title, or rating size as long as it is a list of fixed items
        return image.size
    }

}