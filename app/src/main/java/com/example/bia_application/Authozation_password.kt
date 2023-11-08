package com.example.bia_application

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class Authozation_password: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.authorization_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<ImageView>(R.id.move)
        button.setOnClickListener{
            val activityIntent = Intent(requireContext(), MainActivity::class.java)
            startActivity(activityIntent)
            val text1 = view.findViewById<TextView>(R.id.password)
            val text2 = view.findViewById<TextView>(R.id.hint_password)
            val edit = view.findViewById<EditText>(R.id.edit_password)
            text1.visibility = View.INVISIBLE
            text2.visibility = View.INVISIBLE
            edit.visibility = View.INVISIBLE
            button.visibility = View.INVISIBLE
        }

        val editTextPhone = view.findViewById<EditText>(R.id.edit_password)
        editTextPhone.addTextChangedListener(object : TextWatcher {
            @SuppressLint("ResourceAsColor")
            override fun afterTextChanged(p0: Editable?) {
                var number = p0.toString()
                if(number.length == 1){
                    val line1 = view.findViewById<ImageView>(R.id.line1)
                    line1.visibility = View.INVISIBLE
                    p0?.insert(1, "    ")
                }
                else if(number.length < 1) {
                    val line1 = view.findViewById<ImageView>(R.id.line1)
                    line1.visibility = View.VISIBLE
                }
                if(number.length == 6){
                    val line2 = view.findViewById<ImageView>(R.id.line2)
                    line2.visibility = View.INVISIBLE
                    p0?.insert(6, "    ")
                }
                else if(number.length < 6){
                    val line2 = view.findViewById<ImageView>(R.id.line2)
                    line2.visibility = View.VISIBLE
                }
                if(number.length == 11){
                    val line3 = view.findViewById<ImageView>(R.id.line3)
                    line3.visibility = View.INVISIBLE
                    p0?.insert(11, "     ")
                }
                else if(number.length < 11){
                    val line3 = view.findViewById<ImageView>(R.id.line3)
                    line3.visibility = View.VISIBLE
                }
                if(number.length == 17){
                    val line4 = view.findViewById<ImageView>(R.id.line4)
                    line4.visibility = View.INVISIBLE
                    p0?.insert(17, "     ")
                }
                else if(number.length < 17){
                    val line4 = view.findViewById<ImageView>(R.id.line4)
                    line4.visibility = View.VISIBLE
                }
                if(number.length == 23){
                    val line5 = view.findViewById<ImageView>(R.id.line5)
                    line5.visibility = View.INVISIBLE
                    p0?.insert(23, "    ")
                }
                else if(number.length < 23){
                    val line5 = view.findViewById<ImageView>(R.id.line5)
                    line5.visibility = View.VISIBLE
                }
                if(number.length == 28){
                    val line6 = view.findViewById<ImageView>(R.id.line6)
                    line6.visibility = View.INVISIBLE
                    var button_yes = view.findViewById<ImageView>(R.id.button_continue_yes)
                    var button_no = view.findViewById<ImageView>(R.id.button_continue)
                    var continue_word = view.findViewById<TextView>(R.id.continue_word)
                    var continue_word_yes = view.findViewById<TextView>(R.id.continue_word_yes)
                    button_no.visibility = View.INVISIBLE
                    button_yes.visibility = View.VISIBLE
                    continue_word.visibility = View.INVISIBLE
                    continue_word_yes.visibility = View.VISIBLE
                }
                else if(number.length < 28){
                    val line6 = view.findViewById<ImageView>(R.id.line6)
                    line6.visibility = View.VISIBLE
                    var button_yes = view.findViewById<ImageView>(R.id.button_continue_yes)
                    var button_no = view.findViewById<ImageView>(R.id.button_continue)
                    var continue_word = view.findViewById<TextView>(R.id.continue_word)
                    var continue_word_yes = view.findViewById<TextView>(R.id.continue_word_yes)
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
    }
}