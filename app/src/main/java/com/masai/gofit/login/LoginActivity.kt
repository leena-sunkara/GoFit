package com.masai.gofit.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.facebook.*
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.masai.gofit.R
import com.masai.gofit.home.HomeActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.password

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    //Google
    private lateinit var googleSignInClient: GoogleSignInClient

    //Facebook
    private lateinit var callbackManager: CallbackManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = Firebase.auth
        initViews()
    }

    private fun initViews() {
        backArrow.setOnClickListener {
            startActivity(Intent(this, FeaturesActivity::class.java))
        }
        btnEmailLogin.setOnClickListener {
            val email = mail_id.text.toString()
            val password = password.text.toString()
            emailLogin(email, password)
        }
        ivGoogleLogin.setOnClickListener {
            googleLogin()
        }
        ivFacebookLogin.setOnClickListener {
            facebookLogin()
        }
        ivForgotPassword.setOnClickListener {
            startActivity(Intent(this, ResetPasswordActivity::class.java))
        }
    }

    private fun emailLogin(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    //Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "SignInWithEmail:Success")
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    //If sign in fails, display a message to the user
                    Log.w(TAG, "SignInWithEmail:Failure", task.exception)
                    Toast.makeText(
                        baseContext, "Authentication failed!",
                        Toast.LENGTH_SHORT
                    ).show()
                    updateUI(null)
                }
            }
    }

    private fun googleLogin() {
        //Configure Google Sign In
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(this, gso)
        //Sign In
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    private fun facebookLogin() {
        FacebookSdk.sdkInitialize(this)
        callbackManager = CallbackManager.Factory.create()
        LoginManager.getInstance().logInWithReadPermissions(
            this,
            listOf("email", "public_profile")
        )
        LoginManager.getInstance()
            .registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
                override fun onSuccess(result: LoginResult) {
                    handleFacebookAccessToken(result.accessToken)
                }

                override fun onCancel() {
                    Log.d(TAG, "Facebook:onCancelMethod")
                }

                override fun onError(error: FacebookException) {
                    Log.d(TAG, "Facebook:onErrorMethod", error)
                }
            })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //Google
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                //Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)!!
                Log.d(TAG, "FirebaseAuthWithGoogle:" + account.id)
                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
                //Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e)
            }
        }
        //Facebook
        callbackManager.onActivityResult(requestCode, resultCode, data)
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    //Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "SignInWithCredential:Success")
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    //If sign in fails, display a message to the user
                    Log.w(TAG, "SignInWithCredential:Failure", task.exception)
                    updateUI(null)
                }
            }
    }

    internal fun handleFacebookAccessToken(token: AccessToken) {
        val credential = FacebookAuthProvider.getCredential(token.token)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    //Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "SignInWithCredential:Success")
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    //If sign in fails, display a message to the user
                    Log.w(TAG, "SignInWithCredential:Failure", task.exception)
                    updateUI(null)
                }
            }
    }

    companion object {
        private const val TAG = "LoginActivity"
        private const val RC_SIGN_IN = 100
    }

    private fun updateUI(user: FirebaseUser?) {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }
}