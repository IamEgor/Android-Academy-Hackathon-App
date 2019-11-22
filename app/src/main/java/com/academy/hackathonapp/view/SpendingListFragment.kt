package com.academy.hackathonapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.academy.hackathonapp.R

class SpendingListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?) : View {

        val view = inflater.inflate(R.layout.list_item, container, false)
        val list = view.findViewById<RecyclerView>(R.id.recycler_spending_list)
        return view
    }
}