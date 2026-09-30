package com.example.ubiq1

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("onCreate()")

        setContentView(R.layout.activity_main)

        /* Variable */
        val name = findViewById<EditText>(R.id.editName)
        val password = findViewById<EditText>(R.id.editPassword)
        val telephone = findViewById<EditText>(R.id.editPhone)
        val email = findViewById<EditText>(R.id.editEmail)
        val submit = findViewById<Button>(R.id.btnSubmit)

        /* Action Listener for submitButton */
        submit.setOnClickListener {
            val nameText = name.text.toString().trim()
            val passText = password.text.toString().trim()
            val teleNo = telephone.text.toString().trim()
            val emailText = email.text.toString().trim()

            var isValid = true

            /* Form Validations */
            /* NAME */
            if (nameText.isEmpty()) {
                name.error = "Name is Required"
                isValid = false
            } else if (!nameText.matches(Regex("^[a-zA-Z]+$"))) {
                name.error = "Name must contain letters only!"
                isValid = false
            }
            /* PASSWORD */
            if (passText.isEmpty()) {
                password.error = "Password is Required"
                isValid = false
            } else if (passText.length < 3) {
                password.error = "Password must be more 3 or more characters!"
                isValid = false
            }

            /* TELEPHONE */
            if (teleNo.isEmpty()) {
                telephone.error = "Telephone Number is Required"
                isValid = false
            } else if (!teleNo.matches(Regex("^[0-9]+$"))) {
                telephone.error = "You can only use numbers 1 - 9"
                isValid = false
            } else if (teleNo.length < 3) {
                telephone.error = "Phone Number Not Long Enough!"
                isValid = false
            }

            /* EMAIL */
            if (emailText.isEmpty()) {
                email.error = "Email is required"
                isValid = false
            } else if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
                email.error = "Enter a valid email"
                isValid = false
            }
            /* If everything works */
            if (isValid) {
                Toast.makeText(
                    this,
                    "Thank you $nameText, your request is being processed!",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    /* Displaying Application Life Cycle on LogCat */
    override fun onPause() {
        super.onPause()
        println("onPause()")
    }

    override fun onResume() {
        super.onResume()
        println("onResume()")
    }

    override fun onStop() {
        super.onStop()
        println("onStop()")
    }

    override fun onRestart() {
        super.onRestart()
        println("onRestart()")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy()")
    }
}