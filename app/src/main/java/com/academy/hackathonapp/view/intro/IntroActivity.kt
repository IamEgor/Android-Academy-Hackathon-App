package com.academy.hackathonapp.view.intro

import android.content.Intent
import android.os.Bundle
import com.academy.hackathonapp.view.MainActivity
import com.academy.hackathonapp.view.intro.money.MoneyFragment
import com.academy.hackathonapp.view.intro.signup.GoogleSignInFragment
import com.github.paolorotolo.appintro.AppIntro
import com.pixplicity.easyprefs.library.Prefs

class IntroActivity : AppIntro() {

    private var isFirstLoading: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkForFirstLoading()
        setupIntro()
    }

    private fun checkForFirstLoading() {
        isFirstLoading = Prefs.getBoolean("is_first_launch", false)
        if (isFirstLoading) {
//            onDonePressed()
        }
    }

    private fun setupIntro() {
        showSkipButton(false)
        addSlides()
    }

    private fun addSlides() {
        addSlide(GoogleSignInFragment.newInstance())
        addSlide(MoneyFragment.newInstance())
//        addSlide(CategoryChooserFragment.newInstance())
    }

    interface OnNextClickListener {
        fun onClickNext(activity: IntroActivity)
    }

    override fun onDonePressed() {
        super.onDonePressed()
        Prefs.putBoolean("is_first_launch", true)
        startActivity(Intent(this, MainActivity::class.java))
    }

    override fun onPause() {
        super.onPause()
        finish()
    }
}
