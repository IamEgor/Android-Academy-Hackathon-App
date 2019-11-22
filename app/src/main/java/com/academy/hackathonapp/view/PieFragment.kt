package com.academy.hackathonapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.academy.hackathonapp.R
import com.academy.hackathonapp.mvvm.viewModel.FragmentViewModel
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.android.synthetic.main.fragment_pie_chart.*

class PieFragment:Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pie_chart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val fragmentViewModel = ViewModelProviders.of(requireActivity()).get(FragmentViewModel::class.java)
        val spendings =ArrayList<PieEntry>()


        spendings.add(PieEntry(945f,"2008"))
        spendings.add(PieEntry(1044f, "2009"))
        spendings.add(PieEntry(1100f, "2010"))
        spendings.add(PieEntry(1200f, "2011"))
        spendings.add(PieEntry(1300f, "2012"))
        spendings.add(PieEntry(1400f, "2013"))
        spendings.add(PieEntry(1500f, "2014"))
        spendings.add(PieEntry(1600f, "2015"))

        val data =PieDataSet(spendings,"Our spending")

        val datapie = PieData(data)


        //pieChartId.setUsePercentValues(true)
        pieChartId.setEntryLabelTextSize(20F)

        pieChartId.data = datapie
        //pieChartId.clearValues()
        data.colors = ColorTemplate.createColors(ColorTemplate.COLORFUL_COLORS)
        pieChartId.animateXY(5000,5000)

    }

}