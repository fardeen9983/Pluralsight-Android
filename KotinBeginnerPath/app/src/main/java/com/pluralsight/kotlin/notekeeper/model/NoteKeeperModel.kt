package com.pluralsight.kotlin.notekeeper.model

data class CourseInfo(val courseID : String, val title : String){
    override fun toString(): String {
        return title
    }
}

data class NoteInfo(var course: CourseInfo,var title: String, var text: String)