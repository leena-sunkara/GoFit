package com.masai.gofit.programs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.masai.gofit.R
import com.masai.gofit.livesession.LiveAdapter
import com.masai.gofit.nearby.NearAdapter
import kotlinx.android.synthetic.main.fragment_live__session.*
import kotlinx.android.synthetic.main.fragment_nearby.*


class Live_SessionFragment : Fragment() {

    private var layoutManager : RecyclerView.LayoutManager? = null
    private var adapter : RecyclerView.Adapter<LiveAdapter.LiveViewHolder>? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_live__session, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        layoutManager = LinearLayoutManager(context)
        liveRecyclerView.layoutManager = layoutManager
        adapter = LiveAdapter()
        liveRecyclerView.adapter = adapter
    }

}