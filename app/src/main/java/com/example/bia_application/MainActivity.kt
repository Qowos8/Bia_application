package com.example.bia_application

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    @SuppressLint("ResourceType", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editTextPhone = findViewById<EditText>(R.id.edit)
        editTextPhone.addTextChangedListener(object : TextWatcher {
            @SuppressLint("ResourceAsColor")
            override fun afterTextChanged(p0: Editable?) {
                var number = p0.toString()
                if(number.length == 4){
                    p0?.insert(3, ") ")
                }
                if(number.length == 9){
                    p0?.insert(8, "-")
                }
                if(number.length == 12){
                    p0?.insert(11, "-")
                }
                if(number.length == 14){
                    var button_yes = findViewById<ImageView>(R.id.button_continue_yes)
                    var button_no = findViewById<ImageView>(R.id.button_continue)
                    var continue_word = findViewById<TextView>(R.id.continue_word)
                    var continue_word_yes = findViewById<TextView>(R.id.continue_word_yes)
                    button_no.visibility = View.INVISIBLE
                    button_yes.visibility = View.VISIBLE
                    continue_word.visibility = View.INVISIBLE
                    continue_word_yes.visibility = View.VISIBLE
                }
                else {
                    var button_yes = findViewById<ImageView>(R.id.button_continue_yes)
                    var button_no = findViewById<ImageView>(R.id.button_continue)
                    var continue_word = findViewById<TextView>(R.id.continue_word)
                    var continue_word_yes = findViewById<TextView>(R.id.continue_word_yes)
                    button_yes.visibility = View.INVISIBLE
                    continue_word_yes.visibility = View.INVISIBLE
                    button_no.visibility = View.VISIBLE
                    continue_word.visibility = View.VISIBLE
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        })
        val button_continue = findViewById<ImageView>(R.id.button_continue_yes)
        button_continue.setOnClickListener{
            val fragment = Authozation_password()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_container, fragment)
                    .commit()
            val text1 = findViewById<TextView>(R.id.welcome)
            val text2 = findViewById<TextView>(R.id.hint)
            val text3 = findViewById<TextView>(R.id.seven)
            val edit = findViewById<TextView>(R.id.edit)
            text1.visibility = View.INVISIBLE
            text2.visibility = View.INVISIBLE
            text3.visibility = View.INVISIBLE
            edit.visibility = View.INVISIBLE
        }
    }
}

private fun EditText.addTextChangedListener(any: Any) {
    TODO("Not yet implemented")
}
