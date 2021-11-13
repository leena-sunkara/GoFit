package com.masai.gofit.guild

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.masai.gofit.R
import com.masai.gofit.nearby.NearAdapter

class MyFeedAdapter : RecyclerView.Adapter<MyFeedAdapter.MyFeedViewHolder>() {

    private val Like_Count = arrayOf("22 Likes", "20 Likes" , "25 Likes" )
    private val See_all = arrayOf("See All Comments", "See All Comments","See All Comments" )
    private val Feed_Messasges = arrayOf("Superb" , "Hard work", "Keep it up" )
    private val add_comment = arrayOf(" Add a Comments", "Add a Comments","Add a Comments" )
    private val Image_Gallery = intArrayOf(R.drawable.feed1,R.drawable.feed2,R.drawable.feed3)
    private val Like_Icon = intArrayOf(R.drawable.likes,R.drawable.likes,R.drawable.likes)
    private val Comments_Icon = intArrayOf(R.drawable.comments,R.drawable.comments,R.drawable.comments)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int
    ): MyFeedAdapter.MyFeedViewHolder {
        val  view = LayoutInflater.from(parent.context).inflate(R.layout.feed_item_layout,parent,false)
        return MyFeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyFeedAdapter.MyFeedViewHolder, position: Int) {
        holder.countlike.text= Like_Count[position]
        holder.seeallcomm.text= See_all[position]
        holder.commadd.text= add_comment[position]
        holder.commentess.text= Feed_Messasges[position]
        holder.galleryImage.setImageResource(Image_Gallery[position])
        holder.likeicon.setImageResource(Like_Icon[position])
        holder.commenticon.setImageResource(Comments_Icon[position])
    }

    override fun getItemCount(): Int {
        return Image_Gallery.size
    }

    inner class MyFeedViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        var galleryImage : ImageView
        var likeicon : ImageView
        var countlike : TextView
        var seeallcomm : TextView
        var commentess : TextView
        var commenticon : ImageView
        var commadd : TextView

        init {
            galleryImage = itemView.findViewById(R.id.feed_image)
            likeicon = itemView.findViewById(R.id.likeicon)
            countlike = itemView.findViewById(R.id.feed_likecount)
            seeallcomm = itemView.findViewById(R.id.feed_seeallcomments)
            commentess = itemView.findViewById(R.id.feed_commentmessage)
            commenticon= itemView.findViewById(R.id.commenticon)
            commadd = itemView.findViewById(R.id.feed_writecomment)

        }

    }

}