package com.pluralsight.kotlin.notekeeper.model

class CourseInfo(val courseID : String, val title : String)

class NoteInfo(var course: CourseInfo,val title: String)