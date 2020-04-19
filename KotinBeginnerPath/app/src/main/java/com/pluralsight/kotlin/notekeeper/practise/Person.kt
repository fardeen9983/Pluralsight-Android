package com.pluralsight.kotlin.notekeeper.practise

class Person(val name: String, var weightLbs: Double) {

    var weightKilos: Double
        get() = weightLbs / 2.2
        set(value) {
            weightLbs = value * 2.2
        }

    fun demo() {
        val p = Person("Khan", 110.0)
        val name = p.name

        p.weightLbs = 220.0
        var kilos = p.weightKilos

        p.weightKilos = 50.0
        var lbs = p.weightLbs

        p.eatDessert(false)
        lbs = p.weightLbs
        p.eatDessert()
        lbs = p.weightLbs

        var gw = p.calcGoalWeightLbs()

        val p2 = Person(weightLbs = 200.0, name = "Fardeen")
        p2.eatDessert(addedIceCream = false)
        gw = p2.calcGoalWeightLbs(lbsToLoose = 50.0)
    }

    fun eatDessert(addedIceCream: Boolean = true) {
        weightLbs += if (addedIceCream) 4.0 else 2.0
    }

    fun calcGoalWeightLbs(lbsToLoose: Double = 10.0) = weightLbs - lbsToLoose

    fun nullSafety(p: Person?) {
        val name = p?.name
        var test: String = name ?: "NA"
        test = p?.name ?: "NA"
    }
}

