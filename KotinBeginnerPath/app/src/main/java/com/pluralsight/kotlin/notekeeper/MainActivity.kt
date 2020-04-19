package com.pluralsight.kotlin.notekeeper

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.pluralsight.kotlin.notekeeper.model.DataManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listNotes.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,DataManager.notes)
        fab.setOnClickListener {
            startActivity(Intent(this, EditNoteActivity::class.java))
        }
    }
}
