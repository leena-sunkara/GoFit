package com.masai.gofit.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.masai.gofit.R

class StoreProductsAdapter : RecyclerView.Adapter<StoreProductsAdapter.StoreProductsViewHolder>() {

    private val productImage = intArrayOf(
        R.drawable.product_hex_dumbell,
        R.drawable.product_yoga_mat,
        R.drawable.product_kettlebell,
        R.drawable.product_sport_shoes,
        R.drawable.product_boxing_gloves,
        R.drawable.product_hand_gripper,
        R.drawable.product_whey_protein,
        R.drawable.product_punching_bag_combo
    )

    private val productName =
        arrayOf(
            "Hex Dumbell",
            "Yoga Mat",
            "Kettlebell",
            "Sport Shoes",
            "Boxing Gloves",
            "Hand Gripper",
            "Whey Protein",
            "Punching Bag Combo"
        )

    private val productPrice = intArrayOf(
        974, 479, 750, 2999, 1299, 199, 4999, 2500
    )

    private val productDiscount = intArrayOf(
        25, 20, 10, 40, 15, 10, 10, 35
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreProductsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.product_item_layout, parent, false)
        return StoreProductsViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: StoreProductsViewHolder, position: Int) {
        holder.productImage.setImageResource(productImage[position])
        holder.productName.text = productName[position]
        holder.productPrice.text = "₹" + productPrice[position].toString()
        holder.productDiscount.text = productDiscount[position].toString() + "% Off"
    }

    override fun getItemCount(): Int {
        return productName.size
    }

    class StoreProductsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var productImage: ImageView = itemView.findViewById(R.id.productImage)
        var productName: TextView = itemView.findViewById(R.id.productName)
        var productPrice: TextView = itemView.findViewById(R.id.productPrice)
        var productDiscount: TextView = itemView.findViewById(R.id.productDiscount)
    }
}