package com.example.culinarix.ui.login

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.EditText
import com.example.culinarix.R
import com.example.culinarix.databinding.ActivityLoginBinding
import com.example.culinarix.ui.customview.ButtonCustom
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var btnLogin:ButtonCustom

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()

        btnLogin = binding.btnSignin
        val edEmail = binding.edtEmail
        val edPass = binding.edtPass
        val layEmail = binding.layEmail
        val layPass = binding.layPass

        edEmail.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                btnLogin.isEnabled =
                    edEmail.text.toString().isNotEmpty() && edPass.text.toString().isNotEmpty()


            }

            override fun afterTextChanged(p0: Editable?) {
                validateEmail(edEmail, layEmail)
            }

        })

        edPass.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                btnLogin.isEnabled =
                    edEmail.text.toString().isNotEmpty() && edPass.text.toString().isNotEmpty()


            }

            override fun afterTextChanged(p0: Editable?) {
                validatePass(edPass, layPass)
            }

        })


    }


    private fun validateEmail(edEmail: EditText, layEmail: TextInputLayout): Boolean {
        return when {
            edEmail.text.toString().trim().isEmpty() -> {
                layEmail.error = "Email tidak boleh kosong"
                false
            }

            !Patterns.EMAIL_ADDRESS.matcher(edEmail.text.toString().trim()).matches() -> {
                layEmail.error = "Email harus unik dan valid"
                false
            }

            else -> {
                layEmail.error = null
                true
            }
        }
    }

    private fun validatePass(edPass: EditText, layPass: TextInputLayout): Boolean {
        return when {
            edPass.text.toString().trim().isEmpty() -> {
                layPass.error = "Password tidak boleh kosong"
                false
            }

            edPass.text.toString().trim().length < 8 -> {
                layPass.error = "Password harus lebih 8 karakter"
                false
            }

            else -> {
                layPass.error = null
                true
            }
        }
    }








    private fun setupView() {
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        supportActionBar?.hide()
    }
}