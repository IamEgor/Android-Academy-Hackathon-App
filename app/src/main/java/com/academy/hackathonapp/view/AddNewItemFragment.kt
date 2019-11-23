package com.academy.hackathonapp.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.academy.hackathonapp.R
import com.academy.hackathonapp.db.model.Category
import com.academy.hackathonapp.db.model.Currency
import com.academy.hackathonapp.db.model.Expense
import com.academy.hackathonapp.dependency.DataStorage
import kotlinx.android.synthetic.main.adding_item_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.ArrayList

class AddNewItemFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(R.layout.adding_item_fragment,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        GlobalScope.launch(Dispatchers.IO) { val list = DataStorage.categoryRepository.getAllNameCategories()
        withContext(Dispatchers.Main){categories_spinner.adapter=ArrayAdapter<String>(this@AddNewItemFragment.context as Context,R.layout.support_simple_spinner_dropdown_item,list)}}


        save_spend.setOnClickListener { v->run{
            val expense = Expense(1, categories_spinner.selectedItem as Category,input_description.text.toString(),sumSpend.text.toString().toBigDecimal(),
                Currency(0,"BYN",0),System.currentTimeMillis())
            GlobalScope.launch(Dispatchers.IO){ DataStorage.createExpenseRepository().addExpense(expense) }
        } }


    }

}