package com.example.bia_application;

import ViewModel.MainViewModel
import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import com.example.bia_application.Authozation_password
import com.example.bia_application.R
import com.example.bia_application.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var textWatcher: TextWatcher? = null

    @SuppressLint("ResourceType", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val viewModel = MainViewModel()
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        /*val navController = findNavController(R.id.nav_host_fragment)

        if (condition) {
            navController.navigate(R.id.your_destination)
        }*/

        val editTextPhone = binding.edit
        textWatcher = createTextWatcher()
        editTextPhone.addTextChangedListener(textWatcher)

        val button_continue = binding.buttonContinueYess

        button_continue.setOnClickListener {
            // Remove the TextWatcher when the button is clicked
            editTextPhone.removeTextChangedListener(textWatcher)

            val fragment = Authozation_password()
            supportFragmentManager.beginTransaction()
                .replace(R.id.frame_container, fragment)
                .commit()

            val text1 = binding.welcome
            val text2 = binding.hint
            val text3 = binding.seven
            val edit = binding.edit
            text1.visibility = View.INVISIBLE
            text2.visibility = View.INVISIBLE
            text3.visibility = View.INVISIBLE
            edit.visibility = View.INVISIBLE
        }
    }

    private fun createTextWatcher(): TextWatcher {
        var isDeleting = false
        return object : TextWatcher {
            @SuppressLint("ResourceAsColor")
            override fun afterTextChanged(p0: Editable?) {
                val number = p0.toString()
                if (isDeleting) {
                    p0?.clear()
                } else {
                    if (number.length == 4) {
                        p0?.insert(3, ") ")
                    }
                    if (number.length == 9) {
                        p0?.insert(8, "-")
                    }
                    if (number.length == 12) {
                        p0?.insert(11, "-")
                    }
                    if (number.length == 14) {
                        binding.buttonContinueYess.visibility = View.VISIBLE
                        binding.buttonContinue.visibility = View.INVISIBLE
                        binding.continueWord.visibility = View.INVISIBLE
                        binding.continueWordYes.visibility = View.VISIBLE
                    } else {
                        binding.buttonContinueYess.visibility = View.INVISIBLE
                        binding.buttonContinue.visibility = View.VISIBLE
                        binding.continueWord.visibility = View.VISIBLE
                        binding.continueWordYes.visibility = View.INVISIBLE
                    }
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                isDeleting = p2 > 0 && p2 > p3
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        }
    }

    override fun onDestroy() {
        removeTextWatcher()
        super.onDestroy()
    }

    private fun removeTextWatcher() {
        val editTextPhone = binding.edit
        editTextPhone.removeTextChangedListener(textWatcher)
    }
}
