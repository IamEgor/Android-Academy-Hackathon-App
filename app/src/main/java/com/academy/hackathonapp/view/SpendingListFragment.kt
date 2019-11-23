package com.academy.hackathonapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.academy.hackathonapp.R
import com.academy.hackathonapp.dependency.DataStorage
import kotlinx.android.synthetic.main.spending_list_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SpendingListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?) : View {

        val view = inflater.inflate(R.layout.list_item, container, false)

        GlobalScope.launch(Dispatchers.IO) {
            val items = DataStorage.expenseRepository.getAllCategories()
            withContext(Dispatchers.Main){
                recycler_spending_list.adapter = SpentItemsAdapter(items)
                recycler_spending_list.layoutManager = LinearLayoutManager(this@SpendingListFragment.context)
            }
        }
        return view
    }
}