package com.pluralsight.kotlin.notekeeper.practise

class Person(val name: String, var weightLbs: Double) {
    var weightKilos: Double
        get() = weightLbs / 2.2
        set(value) {
            weightLbs = value * 2.2
        }

    fun demo() {
        val p = Person("Khan",110.0)
        val name = p.name

        p.weightLbs = 220.0
        var kilos = p.weightKilos

        p.weightKilos = 50.0
        val lbs = p.weightLbs
    }
}

