package com.pluralsight.kotlin.notekeeper

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.pluralsight.kotlin.notekeeper.model.CourseInfo
import com.pluralsight.kotlin.notekeeper.model.DataManager
import com.pluralsight.kotlin.notekeeper.model.NoteInfo
import kotlinx.android.synthetic.main.activity_edit_note.*

class EditNoteActivity : AppCompatActivity() {
    private var notePosition = POSITION_NOT_SET
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_note)

        val adapterCourses = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            DataManager.courses.values.toList()
        )

        adapterCourses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCourses.adapter = adapterCourses

        notePosition =
            savedInstanceState?.getInt(NOTE_POSITION, POSITION_NOT_SET)
                ?: intent.getIntExtra(
                    NOTE_POSITION,
                    POSITION_NOT_SET
                )
        if (notePosition != POSITION_NOT_SET)
            displayNote()
    }

    private fun displayNote() {
        val note = DataManager.notes[notePosition]
        textNoteText.setText(note.text)
        textNoteTitle.setText(note.title)
        spinnerCourses.setSelection(DataManager.courses.values.indexOf(note.course))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_next -> {
                moveNext()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun moveNext() {
        ++notePosition
        displayNote()
        invalidateOptionsMenu()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        if (notePosition >= DataManager.notes.lastIndex) {
            val menuItem = menu?.findItem(R.id.action_next)
            if (menuItem != null) {
                menuItem.icon = getDrawable(R.drawable.ic_last_page)
                menuItem.isEnabled = false
            }

        }
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onPause() {
        super.onPause()

        saveNote()
    }

    private fun saveNote() {
        val note = NoteInfo(
            spinnerCourses.selectedItem as CourseInfo,
            textNoteTitle.text.toString(),
            textNoteText.text.toString()
        )
        if (notePosition == POSITION_NOT_SET)
            DataManager.notes.add(note)
        else DataManager.notes[notePosition] = note

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(NOTE_POSITION, notePosition)
    }

}

