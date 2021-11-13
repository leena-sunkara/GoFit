package com.masai.gofit.nearby

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.masai.gofit.R

class NearAdapter : RecyclerView.Adapter<NearAdapter.NearViewHolder>() {

    private val gymName =
        arrayOf("Metropolis Unisex Gym", "AnyTime Fitness", "HS. Multi Gym", "Platinum Gym")

    private val gymAddress = arrayOf(
        "Avinash complex, Address 4th floor, East jail road, Opp \\nDr Amit Mukherjee, Delhi",
        "Avinash complex, Address 4th floor, East jail road, Opp \\nDr Amit Mukherjee, Delhi",
        "Avinash complex, Address 4th floor, East jail road, Opp \\nDr Amit Mukherjee, Delhi",
        "Avinash complex, Address 4th floor, East jail road, Opp \\nDr Amit Mukherjee, Delhi"
    )

    private val gymImage = intArrayOf(
        R.drawable.gym_location,
        R.drawable.anytime_fitness,
        R.drawable.multi_gym,
        R.drawable.gym_location
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NearAdapter.NearViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.near_item_layout, parent, false)
        return NearViewHolder(view)
    }

    override fun onBindViewHolder(holder: NearAdapter.NearViewHolder, position: Int) {
        holder.gymName.text = gymName[position]
        holder.gymAddress.text = gymAddress[position]
        holder.gymImage.setImageResource(gymImage[position])
    }

    override fun getItemCount(): Int {
        return gymName.size
    }

    inner class NearViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var gymImage: ImageView = itemView.findViewById(R.id.near_image)
        var gymName: TextView = itemView.findViewById(R.id.gym_name)
        var gymAddress: TextView = itemView.findViewById(R.id.near_address)
        var share: ImageView = itemView.findViewById(R.id.share_icon)
    }
}