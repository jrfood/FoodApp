package com.example.homefoodactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.homefoodactivity.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class Register : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    private lateinit var fAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)

        fAuth = FirebaseAuth.getInstance()

        if(fAuth.currentUser != null) {
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
        } else {
            registerUser()
        }
    }

    override fun onResume() {
        super.onResume()
        binding.progressBar.visibility = View.GONE
    }

    private fun registerUser() {
      binding.registerBtn.setOnClickListener {
          val email = binding.email.text.toString()
          val password = binding.password.text.toString()

          if (TextUtils.isEmpty(email)) {
              binding.email.setError("Email is Required")
          }
          if (TextUtils.isEmpty(password)) {
              binding.password.setError("Password is Required")
          }

          //register the user
          if (email.isNotEmpty() && password.isNotEmpty()) {
              binding.progressBar.visibility = View.VISIBLE
              fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                  if (it.isComplete) {
                      Toast.makeText(this, "User Created", Toast.LENGTH_SHORT).show()
                      binding.progressBar.visibility = View.GONE
                      startActivity(Intent(applicationContext, MainActivity::class.java))
                  } else {
                      Toast.makeText(
                          this,
                          "Register Error" + it.exception?.message,
                          Toast.LENGTH_SHORT
                      ).show()
                  }
              }
          }

      }
    }
}