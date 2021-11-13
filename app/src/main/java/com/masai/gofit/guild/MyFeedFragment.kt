package com.masai.gofit.guild

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.masai.gofit.R
import kotlinx.android.synthetic.main.fragment_my_feed.*
import kotlinx.android.synthetic.main.fragment_my_gallery.*


class MyFeedFragment : Fragment() {
    private var layoutManager : RecyclerView.LayoutManager? = null
    private var adapter : RecyclerView.Adapter<MyFeedAdapter.MyFeedViewHolder>? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        layoutManager = LinearLayoutManager(context)
        myFeedRecyclerView.layoutManager = layoutManager
        adapter = MyFeedAdapter()
        myFeedRecyclerView.adapter = adapter
    }


}