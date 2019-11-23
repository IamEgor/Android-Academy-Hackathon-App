package com.academy.hackathonapp.view.intro.signup

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.academy.hackathonapp.R
import com.academy.hackathonapp.view.intro.IntroActivity
import com.academy.hackathonapp.view.intro.IntroActivity.OnNextClickListener
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.drive.Drive.SCOPE_FILE
import com.google.android.gms.tasks.Task
import kotlinx.android.synthetic.main.google_sign_in_fragment.sign_google
import kotlinx.android.synthetic.main.google_sign_in_fragment.sign_tv

class GoogleSignInFragment : Fragment(), OnNextClickListener {
    override fun onClickNext(activity: IntroActivity) {
        activity.pager.goToNextSlide()
    }

    companion object {
        private const val REQUEST_CODE_SIGN_IN = 110
        private const val TAG = "GoogleSignInFragment"
        private const val APP_NAME = "HackathonApp"
        @JvmStatic
        fun newInstance() = GoogleSignInFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.google_sign_in_fragment, container, false)

        view.findViewById<Button>(R.id.sign_google).setOnClickListener {
            signIn()
        }
        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }

    private fun signIn() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestScopes(SCOPE_FILE)
            .requestEmail()
            .build()

        val mGoogleSignInClient = GoogleSignIn.getClient(activity as Activity, gso);
        val signInIntent = mGoogleSignInClient.signInIntent
        startActivityForResult(signInIntent, REQUEST_CODE_SIGN_IN)
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {

        try {
            val account = completedTask.getResult(ApiException::class.java)
            updateUI(account)
        } catch (e: ApiException) {
            updateUI(null)
        }
    }

    private fun updateUI(data: GoogleSignInAccount?) {
        Log.d(TAG, "updateUI: ${data?.displayName}")
        sign_google.visibility = View.GONE
        sign_tv.visibility = View.VISIBLE
        sign_tv.text = "You signed as ${data?.displayName}"
    }
}
