package com.masai.gofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class FeaturesAdapter : RecyclerView.Adapter<FeaturesAdapter.FeaturesVH>() {
    var featureItems: List<Features> = ArrayList()

    class FeaturesVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView? = itemView.findViewById(R.id.iv_image)
        var title: TextView? = itemView.findViewById(R.id.tv_title)
        var description: TextView? = itemView.findViewById(R.id.tv_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeaturesVH {
        val inflate: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.features_image_slider, parent, false)
        return FeaturesVH(inflate)
    }

    override fun onBindViewHolder(holder: FeaturesVH, position: Int) {
        val features: Features = featureItems[position]
        holder.image?.let {
            Glide.with(holder.itemView)
                .load(features.getImage())
                .fitCenter()
                .into(it)
        }
        holder.title?.text = features.getTitle()
        holder.description?.text = features.getDescription()
    }

    override fun getItemCount(): Int {
        return featureItems.size
    }
}
