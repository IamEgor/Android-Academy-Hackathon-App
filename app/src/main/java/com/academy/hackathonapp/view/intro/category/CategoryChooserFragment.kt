package com.academy.hackathonapp.view.intro.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.academy.hackathonapp.R

class CategoryChooserFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_category_chooser, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = CategoryChooserFragment()
    }
}

