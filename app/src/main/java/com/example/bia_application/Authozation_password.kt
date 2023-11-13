package com.example.bia_application

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class Authozation_password : Fragment() {
    private var textWatcher: TextWatcher? = null
    private lateinit var line1: ImageView
    private lateinit var line2: ImageView
    private lateinit var line3: ImageView
    private lateinit var line4: ImageView
    private lateinit var line5: ImageView
    private lateinit var line6: ImageView
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
        line1 = view.findViewById(R.id.line1)
        line2 = view.findViewById(R.id.line2)
        line3 = view.findViewById(R.id.line3)
        line4 = view.findViewById(R.id.line4)
        line5 = view.findViewById(R.id.line5)
        line6 = view.findViewById(R.id.line6)
        button.setOnClickListener {
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

        val button_continue = view.findViewById<ImageView>(R.id.button_continue_yes)
        textWatcher = createTextWatcher(button_continue)
        val editTextPhone = view.findViewById<EditText>(R.id.edit_password)
        editTextPhone.addTextChangedListener(textWatcher)
        button_continue.setOnClickListener {
            val imm =
                requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view?.windowToken, 0)
            val fragment = TaskFragment()
            requireFragmentManager().beginTransaction()
                .add(R.id.frame_container1, fragment)
                .commit()

        }

    }

    private fun createTextWatcher(button: ImageView): TextWatcher {
        var isDeleting = false
        return object : TextWatcher {
            @SuppressLint("ResourceAsColor")
            override fun afterTextChanged(p0: Editable?) {
                val number = p0.toString()

                if (isDeleting) {
                    p0?.clear()
                    line1?.visibility = View.VISIBLE
                    line2?.visibility = View.VISIBLE
                    line3?.visibility = View.VISIBLE
                    line4?.visibility = View.VISIBLE
                    line5?.visibility = View.VISIBLE
                    line6?.visibility = View.VISIBLE


                } else {
                    if (number.length == 1) {
                        line1?.visibility = View.INVISIBLE
                        p0?.insert(1, "    ")
                    } else if (number.isEmpty()) {
                        line1?.visibility = View.VISIBLE
                    }
                    if (number.length == 6) {
                        line2?.visibility = View.INVISIBLE
                        p0?.insert(6, "    ")
                    } else if (number.length < 6) {
                        line2?.visibility = View.VISIBLE
                    }
                    if (number.length == 11) {
                        line3?.visibility = View.INVISIBLE
                        p0?.insert(11, "     ")
                    } else if (number.length < 11) {
                        line3?.visibility = View.VISIBLE
                    }
                    if (number.length == 17) {
                        line4?.visibility = View.INVISIBLE
                        p0?.insert(17, "     ")
                    } else if (number.length < 17) {
                        line4?.visibility = View.VISIBLE
                    }
                    if (number.length == 23) {
                        line5?.visibility = View.INVISIBLE
                        p0?.insert(23, "    ")
                    } else if (number.length < 23) {
                        line5?.visibility = View.VISIBLE
                    }
                    if (number.length == 28) {
                        line6?.visibility = View.INVISIBLE
                        val button_yes = view?.findViewById<ImageView>(R.id.button_continue_yes)
                        val button_no = view?.findViewById<ImageView>(R.id.button_continue)
                        val continue_word = view?.findViewById<TextView>(R.id.continue_word)
                        val continue_word_yes = view?.findViewById<TextView>(R.id.continue_word_yes)
                        button_no?.visibility = View.INVISIBLE
                        button_yes?.visibility = View.VISIBLE
                        continue_word?.visibility = View.INVISIBLE
                        continue_word_yes?.visibility = View.VISIBLE
                    } else if (number.length < 28) {
                        line6?.visibility = View.VISIBLE
                        val button_yes = view?.findViewById<ImageView>(R.id.button_continue_yes)
                        val button_no = view?.findViewById<ImageView>(R.id.button_continue)
                        val continue_word = view?.findViewById<TextView>(R.id.continue_word)
                        val continue_word_yes = view?.findViewById<TextView>(R.id.continue_word_yes)
                        button_yes?.visibility = View.INVISIBLE
                        continue_word_yes?.visibility = View.INVISIBLE
                        button_no?.visibility = View.VISIBLE
                        continue_word?.visibility = View.VISIBLE
                    }
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                isDeleting = p2 > 0 && p2 > p3
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        removeTextWatcher()
    }

    private fun removeTextWatcher() {
        val editTextPhone = view?.findViewById<EditText>(R.id.edit_password)
        editTextPhone?.removeTextChangedListener(textWatcher)
    }
}
