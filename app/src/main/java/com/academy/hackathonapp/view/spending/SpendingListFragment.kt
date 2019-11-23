package com.academy.hackathonapp.view.spending

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.academy.hackathonapp.R
import com.academy.hackathonapp.mvvm.Status.ERROR
import com.academy.hackathonapp.mvvm.Status.LOADING
import com.academy.hackathonapp.mvvm.Status.SUCCESS

class SpendingListFragment : Fragment() {

    private val viewModel: SpendingViewModel by lazy { ViewModelProviders.of(this).get(SpendingViewModel::class.java) }
    private val adapter = SpentItemsAdapter(emptyList())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.spending_list_fragment, container, false)
        val list = view.findViewById<RecyclerView>(R.id.recycler_spending_list)

        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(activity)

        viewModel.loadExpenses()
        viewModel.expenses.observe(this, Observer {
            when (it.status) {
                SUCCESS -> {
                    val items = it.data
                    if (items != null) {
                        adapter.setItems(it.data)
                    }
                }
                LOADING -> {
                }
                ERROR -> {
                }

            }

        })


        return view
    }
}