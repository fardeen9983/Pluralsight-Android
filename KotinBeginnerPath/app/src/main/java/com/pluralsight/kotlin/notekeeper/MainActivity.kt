package com.pluralsight.kotlin.notekeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab.setOnClickListener {
            val originalValue : Int = textDisplayedValue.text.toString().toInt()
            val newValue = originalValue*2
            textDisplayedValue.text = newValue.toString()
            Snackbar.make(it,"Value $originalValue changed to $newValue",Snackbar.LENGTH_LONG).show()
        }


    }
}
