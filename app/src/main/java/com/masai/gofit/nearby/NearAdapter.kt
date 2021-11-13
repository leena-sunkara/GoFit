package com.masai.gofit.nearby

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.masai.gofit.R

class NearAdapter : RecyclerView.Adapter<NearAdapter.NearViewHolder>() {

    private  val name_gym = arrayOf("Metropolis Unisex Gym", "AnyTime Fitness", "Gold Gym", "Platinum gym")

    private val gym_address = arrayOf("Avinash complex, Address 4th floor, East jail road, Opp \\nDr Amit Mukherjee, Delhi", "Avinash complex, Address 4th floor, East jail road, Opp \\nDr Amit Mukherjee, Delhi","Avinash complex, Address 4th floor, East jail road, Opp \\nDr Amit Mukherjee, Delhi","Avinash complex, Address 4th floor, East jail road, Opp \\nDr Amit Mukherjee, Delhi")

    private val gym_image = intArrayOf(R.drawable.gym_location,R.drawable.gym_location,R.drawable.gym_location,R.drawable.gym_location)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NearAdapter.NearViewHolder{

        val  view = LayoutInflater.from(parent.context).inflate(R.layout.near_item_layout,parent,false)
        return NearViewHolder(view)
    }

    override fun onBindViewHolder(holder: NearAdapter.NearViewHolder, position: Int) {
        holder.gymName.text= name_gym[position]
        holder.gymAddress.text= gym_address[position]
        holder.gymImage.setImageResource(gym_image[position])
    }

    override fun getItemCount(): Int {
        return name_gym.size

    }

    inner class NearViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        var gymImage : ImageView
        var gymName : TextView
        var gymAddress : TextView
        var share : ImageView

        init {
            gymImage = itemView.findViewById(R.id.near_image)
            gymName = itemView.findViewById(R.id.gym_name)
            gymAddress = itemView.findViewById(R.id.near_address)
            share = itemView.findViewById(R.id.share_icon)

        }

    }
}