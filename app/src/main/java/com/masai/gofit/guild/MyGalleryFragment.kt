package com.masai.gofit.guild

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.masai.gofit.R
import com.masai.gofit.recorded.RecordedAdapter
import kotlinx.android.synthetic.main.fragment_my_gallery.*
import kotlinx.android.synthetic.main.fragment_recorded__session.*


class MyGalleryFragment : Fragment() {
    private var layoutManager : RecyclerView.LayoutManager? = null
    private var adapter : RecyclerView.Adapter<MyGalleryAdapter.MyGalleryViewHolder>? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_gallery, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        layoutManager = LinearLayoutManager(context)
        GalleryRecyclerView.layoutManager = layoutManager
        adapter = MyGalleryAdapter()
        GalleryRecyclerView.adapter = adapter

    }

}