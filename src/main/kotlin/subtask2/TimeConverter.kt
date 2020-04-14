package subtask2

class TimeConverter {

    fun toTextFormat(hour: String, minute: String): String {
        val timeItog: String
        if ((hour.toInt() in 1..12) and (minute.toInt() in 0..60))
            when {
                (minute.toInt() == 0) -> timeItog = hourToText(hour.toInt()) + " o' clock"
                (minute.toInt() == 15) -> timeItog = "quarter past " + hourToText(hour.toInt())
                (minute.toInt() == 30) -> timeItog = "half past " + hourToText(hour.toInt())
                (minute.toInt() == 45) -> timeItog = "quarter to " + hourToText(hour.toInt()+1)
                ((minute.toInt() < 30) and (minute.toInt() != 15)) ->
                    timeItog = if (minute.toInt() < 20) minuteToText(minute.toInt()) + " minutes past " + hourToText(hour.toInt()) else "twenty " + minuteToText(minute.toInt()-20) + " minutes past " + hourToText(hour.toInt())
                ((minute.toInt() > 30) and (minute.toInt() != 45) and (minute.toInt() < 61)) ->
                    timeItog = if ((60 - minute.toInt()) < 20) minuteToText(60 - minute.toInt()) + " minutes to " + hourToText(hour.toInt()+1) else "twenty " + minuteToText(40 - minute.toInt()) + " minutes to " + hourToText(hour.toInt()+1)
                else -> timeItog = ""
            }
        else
            timeItog = ""
        return timeItog
    }
    fun hourToText(hourFun: Int) = when (hourFun){
        1 -> "one"
        2 -> "two"
        3 -> "three"
        4 -> "four"
        5 -> "five"
        6 -> "six"
        7 -> "seven"
        8 -> "eight"
        9 -> "nine"
        10 -> "ten"
        11 -> "eleven"
        12 -> "twelve"
        else -> ""
    }
    fun minuteToText(minuteFun: Int) = when (minuteFun) {
            1 -> "one"
            2 -> "two"
            3 -> "three"
            4 -> "four"
            5 -> "five"
            6 -> "six"
            7 -> "seven"
            8 -> "eight"
            9 -> "nine"
            10 -> "ten"
            11 -> "eleven"
            12 -> "twelve"
            13 -> "thirteen"
            14 -> "fourteen"
            16 -> "sixteen"
            17 -> "seventeen"
            18 -> "eighteen"
            19 -> "nineteen"
            else -> ""
        }
}
