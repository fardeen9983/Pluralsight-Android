package com.pluralsight.kotlin.notekeeper

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.pluralsight.kotlin.notekeeper.model.CourseInfo
import com.pluralsight.kotlin.notekeeper.model.DataManager
import kotlinx.android.synthetic.main.activity_edit_note.*

class EditNoteActivity : AppCompatActivity() {
    private var notePosition = POSITION_NOT_SET
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_note)

        val adapterCourses = ArrayAdapter<CourseInfo>(
            this,
            android.R.layout.simple_spinner_item,
            DataManager.courses.values.toList()
        )

        adapterCourses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCourses.adapter = adapterCourses

        notePosition = intent.getIntExtra(EXTRA_NOTE_POSITION, POSITION_NOT_SET)
        if (notePosition != POSITION_NOT_SET)
            displayNote()
    }

    private fun displayNote() {
        val note = DataManager.notes[notePosition]
        textNoteText.setText(note.text)
        textNoteTitle.setText(note.title)
        spinnerCourses.setSelection(DataManager.courses.values.indexOf(note.course))
    }
}
