package com.masai.gofit.assessment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.masai.gofit.R
import kotlinx.android.synthetic.main.fragment_basic_details.*
import kotlinx.android.synthetic.main.fragment_intrest.*

class IntrestFragment : Fragment() {
    private var navController: NavController? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_intrest, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        contninueBtn5.setOnClickListener {
            navController!!.navigate(R.id.action_intrestFragment_to_equpmentsFragment)
        }
    }

}