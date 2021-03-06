package com.pluralsight.kotlin.notekeeper.model

object DataManager {
    val courses = HashMap<String, CourseInfo>()
    val notes = ArrayList<NoteInfo>()

    init {
        initializeCourses()
        initializeNotes()
    }

    private fun initializeCourses() {
        var course = CourseInfo("android_intents", "Android Programming with Intents")
        courses[course.courseID] = course

        course = CourseInfo("android_async", "Android Async Programming and Services")
        courses[course.courseID] = course

        course = CourseInfo(courseID = "java_lang",title =  "The JAVA language")
        courses[course.courseID] = course
    }

    private fun initializeNotes(){
        val courses = courses.values.toList()
        notes.add(NoteInfo(courses[0],"First", " Learn Intent"))
        notes.add(NoteInfo(courses[1],"Second", " Learn Intent"))
        notes.add(NoteInfo(courses[2],"Third", " Learn Intent"))
        notes.add(NoteInfo(courses[0],"Fourth", " Learn Intent"))
        notes.add(NoteInfo(courses[1],"Fifth", " Learn Intent"))
        notes.add(NoteInfo(courses[2],"Sixth", " Learn Intent"))
        notes.add(NoteInfo(courses[0],"Seventh", " Learn Intent"))
    }
}