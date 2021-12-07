package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private val myName : MyName = MyName(name = "Anjuman Ara Mimi")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.myName = myName


        // setContentView(R.layout.activity_main)

        //findViewById<Button>(R.id.done_button).setOnClickListener {
        //    addNickname(it)
       // }

        binding.doneButton.setOnClickListener {
            addNickname(it)
        }

    }

    private fun addNickname(done_button: View) {

       // val nickNameEdit = findViewById<EditText>(R.id.edit_nickname)
       // val nickNameText = findViewById<TextView>(R.id.nickname_text)

       // nickNameText.text = nickNameEdit.text
       // nickNameEdit.visibility = View.GONE
       // done_button.visibility = View.GONE
      //  nickNameText.visibility = View.VISIBLE
       // binding.nicknameText.text = binding.editNickname.text
        binding.apply {
            myName?.nickname = editNickname.text.toString()
            invalidateAll()
            editNickname.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(done_button.windowToken, 0)

    }
}