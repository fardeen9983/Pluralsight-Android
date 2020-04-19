package com.pluralsight.kotlin.notekeeper

import com.pluralsight.kotlin.notekeeper.model.CourseInfo
import com.pluralsight.kotlin.notekeeper.model.NoteInfo

class DataManager {
    val courses = HashMap<String, CourseInfo>()
    val notes = ArrayList<NoteInfo>()

    init {
        initializeCourses()
    }

    private fun initializeCourses() {
        var course = CourseInfo("android_intents", "Android Programming with Intents")
        courses[course.courseID] = course

        course = CourseInfo("android_async", "Android Async Programming and Services")
        courses[course.courseID] = course

        course = CourseInfo(courseID = "java_lang",title =  "The JAVA language")
        courses[course.courseID] = course


    }
}