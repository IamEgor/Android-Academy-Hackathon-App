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
import com.academy.hackathonapp.view.spending.SpendingListFragment
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment: Fragment() {
    lateinit var fragmentViewModel:FragmentViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        fragmentViewModel = ViewModelProviders.of(this).get(FragmentViewModel::class.java)
        fragmentViewModel.lv.observe(viewLifecycleOwner, Observer {
            when(it){
               StateChart.PieChart->{
                  fragmentManager?.beginTransaction()?.replace(layout_container.id,PieFragment())?.commit()
               }
               StateChart.ListChart->{
                   fragmentManager?.beginTransaction()?.replace(layout_container.id, SpendingListFragment())?.commit()
               }
            }
        })
        setListeners()
    }

    fun setListeners(){
        txtList.setOnClickListener { v ->
            run {
                fragmentViewModel.changeToListChartState()
            }
        }

        txtPie.setOnClickListener { v ->
            run {
                fragmentViewModel.changeToPieChartState()
            }
        }
    }




}