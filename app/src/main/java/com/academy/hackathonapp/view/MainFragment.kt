package com.academy.hackathonapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.academy.hackathonapp.R
import com.academy.hackathonapp.mvvm.viewModel.FragmentViewModel
import com.academy.hackathonapp.mvvm.viewModel.FragmentViewModel.Companion.StateChart
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.temp_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        var fragmentViewModel = ViewModelProviders.of(this).get(FragmentViewModel::class.java)
        fragmentViewModel.lv.observe(viewLifecycleOwner, Observer {
            when(it){
               StateChart.PieChart->{}
               StateChart.ListChart->{}
            }
        })
    }

    fun setListeners(){
        txtList.setOnClickListener { v ->
            run {
                fragmentManager?.beginTransaction()?.replace(layout.id,ListFragment())?.commit()
            }
        }

        txtPie.setOnClickListener { v ->
            run {
                fragmentManager?.beginTransaction()?.replace(layout.id,PieFragment())?.commit()
            }
        }

    }


}