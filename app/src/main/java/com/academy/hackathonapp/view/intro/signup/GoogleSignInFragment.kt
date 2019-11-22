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
import com.ammarptn.gdriverest.DriveServiceHelper
import com.ammarptn.gdriverest.DriveServiceHelper.getGoogleDriveService
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.drive.Drive.SCOPE_FILE
import com.google.gson.Gson
import java.io.File

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

    private lateinit var mGoogleSignInClient: GoogleSignInClient
    private lateinit var mDriveServiceHelper: DriveServiceHelper

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.google_sign_in_fragment, container, false)

        view.findViewById<Button>(R.id.sign_google).setOnClickListener {
            signIn()
        }

        view.findViewById<Button>(R.id.search).setOnClickListener {
            mDriveServiceHelper.queryFiles(null)
                .addOnSuccessListener { googleDriveFileHolders ->
                    val gson = Gson()
                    Log.d(TAG, "onSuccess: " + gson.toJson(googleDriveFileHolders))
                }
                .addOnFailureListener { e -> Log.d(TAG, "onFailure: " + e.message) }
        }

        view.findViewById<Button>(R.id.create_folder).setOnClickListener {
            mDriveServiceHelper.createFolder("folderName", null)
                .addOnSuccessListener { googleDriveFileHolder ->
                    val gson = Gson()
                    Log.d(TAG, "onSuccess: " + gson.toJson(googleDriveFileHolder))
                }
                .addOnFailureListener { e -> Log.d(TAG, "onFailure: " + e.message) }
        }

        view.findViewById<Button>(R.id.upload_file).setOnClickListener {
            val file = File(activity!!.filesDir, "fileNameTemp.txt")
            file.createNewFile()
            file.writeText("Test text 1")
            mDriveServiceHelper.uploadFile(file, "text/plain", "1H-A9PnH5nBE-bXHoayNNZ1Ovq87bLLFT")
                .addOnSuccessListener { googleDriveFileHolder ->
                    val gson = Gson()
                    Log.d(TAG, "onSuccess: " + gson.toJson(googleDriveFileHolder))
                }
                .addOnFailureListener { e -> Log.d(TAG, "onFailure: " + e.message) }
        }

        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            REQUEST_CODE_SIGN_IN -> if (resultCode == Activity.RESULT_OK && data != null) {
                handleSignInResult(data)
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun signIn() {
        mGoogleSignInClient = buildGoogleSignInClient()
        startActivityForResult(
            mGoogleSignInClient.signInIntent,
            REQUEST_CODE_SIGN_IN
        )
    }

    private fun buildGoogleSignInClient(): GoogleSignInClient {
        val signInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestScopes(SCOPE_FILE)
            .requestEmail()
            .build()
        return GoogleSignIn.getClient(activity!!, signInOptions)
    }

    private fun handleSignInResult(result: Intent) {
        GoogleSignIn.getSignedInAccountFromIntent(result)
            .addOnSuccessListener { googleSignInAccount ->
                Log.d(TAG, "Signed in as " + googleSignInAccount.email!!)

                mDriveServiceHelper = DriveServiceHelper(
                    getGoogleDriveService(
                        activity,
                        googleSignInAccount,
                        APP_NAME
                    )
                )

                Log.d(TAG, "handleSignInResult: $mDriveServiceHelper")
            }
            .addOnFailureListener { e -> Log.e(TAG, "Unable to sign in.", e) }
    }
}
