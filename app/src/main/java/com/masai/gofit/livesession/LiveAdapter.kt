package com.masai.gofit.livesession

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.masai.gofit.R

class LiveAdapter : RecyclerView.Adapter<LiveAdapter.LiveViewHolder>() {

    private  val tranner_name = arrayOf("Abhishek Kumar", "vipin Dev", "golu Tomer", "shanker Singh","girish chauchan")
    private val excercise_name = arrayOf("Stringth " ,"Lifting" , "Cardio", "Yoga","Boxing" )
    private val excercise_time = arrayOf("45 min" , "35 min" , "60 min" , "55 min" , "40 min")
    private val live_poster = intArrayOf(R.drawable.live1,R.drawable.live2,R.drawable.live3,R.drawable.live4, R.drawable.live5)
    private val live_icon = intArrayOf(R.drawable.liveicon,R.drawable.liveicon,R.drawable.liveicon,R.drawable.liveicon,R.drawable.liveicon)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LiveViewHolder {
        val  view = LayoutInflater.from(parent.context).inflate(R.layout.live_item_layout,parent,false)
        return LiveViewHolder(view)
    }

    override fun onBindViewHolder(holder: LiveViewHolder, position: Int) {
        holder.trannerName.text= tranner_name[position]
        holder.excersicename.text= excercise_name[position]
        holder.time.text= excercise_time[position]
        holder.liveposter.setImageResource(live_poster[position])
        holder.liveicon.setImageResource(live_icon[position])
    }

    override fun getItemCount(): Int {
        return excercise_name.size
    }

    inner class LiveViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var liveicon : ImageView
        var liveposter : ImageView
        var trannerName : TextView
        var excersicename : TextView
        var time : TextView
        var btnlive : Button

        init {
            liveicon  = itemView.findViewById(R.id.liveicon)
            liveposter  = itemView.findViewById(R.id.live_image)
            trannerName = itemView.findViewById(R.id.tranner_name)
            excersicename = itemView.findViewById(R.id.excercise_name)
            time = itemView.findViewById(R.id.excercise_time)
            btnlive = itemView.findViewById(R.id.liveBtn)

        }

    }
}