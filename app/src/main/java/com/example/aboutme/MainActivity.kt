package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.done_button).setOnClickListener {
            addNickname(it)
        }

    }

    private fun addNickname(done_button: View) {

        val nickNameEdit = findViewById<EditText>(R.id.edit_nickname)
        val nickNameText = findViewById<TextView>(R.id.nickname_text)

        nickNameText.text = nickNameEdit.text
        nickNameEdit.visibility = View.GONE
        done_button.visibility = View.GONE
        nickNameText.visibility = View.VISIBLE

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(done_button.windowToken, 0)

    }
}