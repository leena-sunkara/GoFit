package com.masai.gofit.recorded

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.masai.gofit.R

class RecordedAdapter : RecyclerView.Adapter<RecordedAdapter.RecordedViewHolder>() {

    private val recorded_ecercise_name = arrayOf("Chest" , "ABS" , "Arms & Sholder","Boxing" , "Yoga", "Cardio","Zumba" , "Calisthenics")
    private val recorded_poster = intArrayOf(R.drawable.chest,R.drawable.abs,R.drawable.arms,R.drawable.yoga, R.drawable.cardio,R.drawable.zumba,R.drawable.calisthenics )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordedViewHolder {
        val  view = LayoutInflater.from(parent.context).inflate(R.layout.recorded_item_layout,parent,false)
        return RecordedViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecordedViewHolder, position: Int) {
        holder.recordedexcersicename.text= recorded_ecercise_name[position]
        holder.recorded_poster.setImageResource(recorded_poster[position])
    }

    override fun getItemCount(): Int {
       return recorded_ecercise_name.size
    }

    inner class RecordedViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var recorded_poster : ImageView
        var recordedexcersicename : TextView

        init {
            recorded_poster  = itemView.findViewById(R.id.recorded_image)
            recordedexcersicename = itemView.findViewById(R.id.recorded_excercise_name)
        }
    }

}