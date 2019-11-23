package com.academy.hackathonapp.view.intro

import android.content.Intent
import android.os.Bundle
import com.academy.hackathonapp.view.MainActivity
import com.academy.hackathonapp.view.intro.money.MoneyFragment
import com.academy.hackathonapp.view.intro.signup.GoogleSignInFragment
import com.github.paolorotolo.appintro.AppIntro

class IntroActivity : AppIntro() {

    private var isFirstLoading: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        checkForFirstLoading()
        setupIntro()
    }
//
//    private fun checkForFirstLoading() {
//        isFirstLoading = Prefs.getBoolean("is_first_launch", false)
//        if (isFirstLoading) {
//            GlobalScope.launch(Dispatchers.IO) {
//                DataStorage.categoryRepository.addCategories(getDefaultCategories())
//
//            }
//        }
//    }
//
//    private fun getDefaultCategories(): List<Category> {
//        return listOf(
//            Category(1, "Food and Drinks"),
//            Category(2, "Health"),
//            Category(3, "Shopping"),
//            Category(4, "Utilities")
//        )
//    }

    private fun setupIntro() {
        showSkipButton(false)
        addSlides()
    }

    private fun addSlides() {
        addSlide(GoogleSignInFragment.newInstance())
        addSlide(MoneyFragment.newInstance())
    }

    interface OnNextClickListener {
        fun onClickNext(activity: IntroActivity)
    }

    override fun onDonePressed() {
        super.onDonePressed()
        startActivity(Intent(this, MainActivity::class.java))
    }

    override fun onPause() {
        super.onPause()
        finish()
    }
}
