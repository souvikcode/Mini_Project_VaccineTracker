package com.example.vaccinetracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_in.*


class Sign_in : AppCompatActivity() {

    var mAuth: FirebaseAuth? = null
    var mAuthListener: FirebaseAuth.AuthStateListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        mAuth = FirebaseAuth.getInstance()
        mAuthListener = FirebaseAuth.AuthStateListener {  }
    }


    fun signIn(view: View){

        mAuth!!.signInWithEmailAndPassword(emailText.text.toString(), passwordText.text.toString())
            .addOnCompleteListener { task ->
                if(task.isSuccessful) {
                    Toast.makeText(applicationContext, "WELCOME AGAIN USER!!", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, pin_code::class.java)
                    startActivity(intent)
                }
            }.addOnFailureListener { exception ->
                if(exception!= null){
                    Toast.makeText(applicationContext, exception.localizedMessage.toString(), Toast.LENGTH_LONG).show()
                }
            }
    }
    fun signUp(view: View){
        mAuth!!.createUserWithEmailAndPassword(emailText.text.toString(), passwordText.text.toString())
            .addOnCompleteListener { task ->
                if(task.isSuccessful) {
                    Toast.makeText(applicationContext, "USER CREATED!!", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, CoWin::class.java)
                    startActivity(intent)
                }
            }.addOnFailureListener { exception ->
                if(exception!= null){
                    Toast.makeText(applicationContext, exception.localizedMessage.toString(), Toast.LENGTH_LONG).show()
                }
            }
    }
}