package com.example.culinarix.ui.register

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
import com.example.culinarix.databinding.ActivityRegisterBinding
import com.example.culinarix.ui.customview.ButtonCustom
import com.google.android.material.textfield.TextInputLayout

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var btnRegister: ButtonCustom


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()

        btnRegister = binding.btnSignup
        val edName = binding.edtName
        val edEmail = binding.edtEmail
        val edPaswword = binding.edtPass
        val edUmur = binding.edtAge
        val edDomisili = binding.edtDomisili

        val layName = binding.layName
        val layEmail = binding.layEmail
        val layPassword = binding.layPass
        val layUmur = binding.layAge
        val layDomisili = binding.layDomisili

        edName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                btnRegister.isEnabled =
                    edName.text.toString().isNotEmpty() && edEmail.text.toString().isNotEmpty() &&
                            edPaswword.text.toString().isNotEmpty() && edUmur.text.toString()
                        .isNotEmpty() && edDomisili.text.toString().isNotEmpty()
            }

            override fun afterTextChanged(s: Editable?) {
                validateName(edName, layName)
            }

        })

        edEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {


            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                btnRegister.isEnabled =
                    edName.text.toString().isNotEmpty() && edEmail.text.toString().isNotEmpty() &&
                            edPaswword.text.toString().isNotEmpty() && edUmur.text.toString()
                        .isNotEmpty() && edDomisili.text.toString().isNotEmpty()
            }

            override fun afterTextChanged(s: Editable?) {
                validateEmail(edEmail, layEmail)
            }

        })

        edPaswword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                btnRegister.isEnabled =
                    edName.text.toString().isNotEmpty() && edEmail.text.toString().isNotEmpty() &&
                            edPaswword.text.toString().isNotEmpty() && edUmur.text.toString()
                        .isNotEmpty() && edDomisili.text.toString().isNotEmpty()
            }

            override fun afterTextChanged(s: Editable?) {
                validatePass(edPaswword, layPassword)
            }

        })

        edUmur.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                btnRegister.isEnabled =
                    edName.text.toString().isNotEmpty() && edEmail.text.toString().isNotEmpty() &&
                            edPaswword.text.toString().isNotEmpty() && edUmur.text.toString()
                        .isNotEmpty() && edDomisili.text.toString().isNotEmpty()

            }

            override fun afterTextChanged(s: Editable?) {
                validateUmur(edUmur, layUmur)
            }

        })

        edDomisili.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                btnRegister.isEnabled =
                    edName.text.toString().isNotEmpty() && edEmail.text.toString().isNotEmpty() &&
                            edPaswword.text.toString().isNotEmpty() && edUmur.text.toString()
                        .isNotEmpty() && edDomisili.text.toString().isNotEmpty()

            }

            override fun afterTextChanged(s: Editable?) {
                validateDomisili(edDomisili, layDomisili)
            }

        })

    }


    private fun validateName(edName: EditText, layNAme: TextInputLayout): Boolean {
        return when {
            edName.text.toString().trim().isEmpty() -> {
                layNAme.error = "Nama tidak boleh kosong"
                false
            }

            else -> {
                layNAme.error = null
                true
            }
        }
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

    private fun validateUmur(edUmur: EditText, layUnur: TextInputLayout): Boolean {
        return when {
            edUmur.text.toString().trim().isEmpty() -> {
                layUnur.error = "Umur tidak boleh kosong"
                false
            }

            edUmur.text.toString().trim().length > 2 -> {
                layUnur.error = "Umur maksimal hanya 2 digit"
                false
            }

            else -> {
                layUnur.error = null
                true
            }
        }
    }

    private fun validateDomisili(edDomisili: EditText, layDomisili: TextInputLayout): Boolean {
        return when {
            edDomisili.text.toString().trim().isEmpty() -> {
                layDomisili.error = "Domisili tidak boleh kosong"
                false
            }


            else -> {
                layDomisili.error = null
                true
            }
        }
    }

//    private fun setEnableButton(){
//        btnRegister = binding.btnSignup
//        btnRegister.isEnabled = validateEmail()
//    }
//


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