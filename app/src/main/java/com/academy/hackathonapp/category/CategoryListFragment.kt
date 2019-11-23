package com.academy.hackathonapp.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.academy.hackathonapp.R
import com.academy.hackathonapp.dependency.DataStorage
import com.academy.hackathonapp.mvvm.viewModel.CategoryViewModel
import com.academy.hackathonapp.view.MainActivity
import kotlinx.android.synthetic.main.category_list_fragment.*


class CategoryListFragment : Fragment() {

    private lateinit var internalAdapter: CategoryAdapter
    private lateinit var viewModel: CategoryViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(
            this,
            CategoryViewModel.CategoryViewModelFactory(
                DataStorage.categoryRepository
            )
        ).get(CategoryViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.loadCategories()
        return inflater.inflate(R.layout.category_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        internalAdapter = CategoryAdapter(emptyList())
        viewModel.categoryList.observe(this, Observer { categories ->
            internalAdapter.categories = categories
            internalAdapter.notifyDataSetChanged()
        })
        categoryList.apply {
            adapter = internalAdapter
        }
        val activity = activity as MainActivity
        add_category.setOnClickListener {
            activity.showFragment(AddCategoryFragment())
        }
    }


}





