package com.masai.gofit.assessment

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.masai.gofit.R
import kotlinx.android.synthetic.main.fragment_days.*
import kotlinx.android.synthetic.main.fragment_prefer.*
import kotlinx.android.synthetic.main.fragment_time_long.*


class TimeLongFragment : Fragment() {

    private var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_time_long, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        min15.setOnClickListener {
            if (!min15.isSelected){
                min15.setBackgroundColor(Color.BLUE)
            }
        }

        min30.setOnClickListener {
            if (!min15.isSelected){
                min15.setBackgroundColor(Color.BLUE)
            }
        }

        min45.setOnClickListener {
            if (!min15.isSelected){
                min15.setBackgroundColor(Color.BLUE)
            }
        }

        min50.setOnClickListener {
            if (!min15.isSelected){
                min15.setBackgroundColor(Color.BLUE)
            }
        }

        navController = Navigation.findNavController(view)

        contninueBtn10.setOnClickListener {
            navController!!.navigate(R.id.action_timeLongFragment_to_processingFragment)
        }

    }

}