package subtask1

class DateFormatter {

    fun toTextDay(day: String, month: String, year: String): String {
        val itogDate: String
        when {
            (day.toInt() > 28) and (month.toInt() == 2) and ((year.toInt() % 4) != 0) ->
                itogDate = "Такого дня не существует"
            (day.toInt() > 29) and (month.toInt() == 2) and ((year.toInt() % 4) == 0) ->
                itogDate = "Такого дня не существует"
            (day.toInt() > 30) and ((month.toInt() == 4) or (month.toInt() == 6) or (month.toInt() == 9) or (month.toInt() == 11)) ->
                itogDate = "Такого дня не существует"
            (day.toInt() > 31) ->
                itogDate = "Такого дня не существует"
            (month.toInt() !in 1..12) ->
                itogDate = "Такого дня не существует"
            else ->
                itogDate = day + " " + monthProp(month) + ", " + weekOpred(day, month, year)
        }
        return itogDate
        throw NotImplementedError("Not implemented")
    }
    fun monthProp (monthFun: String) =
        when (monthFun){
            "1" -> "января"
            "2" -> "февраля"
            "3" -> "марта"
            "4" -> "апреля"
            "5" -> "мая"
            "6" -> "июня"
            "7" -> "июля"
            "8" -> "августа"
            "9" -> "сентября"
            "10" -> "октября"
            "11" -> "ноября"
            "12" -> "декабря"
            else -> ""
        }
    fun weekOpred (dayFunW: String, monthFunW: String, yearFunW: String): String{
        var days: Long
        val weekDay: String
        days = (yearFunW.toLong()-1) * 365 + ((yearFunW.toLong()-1) / 4).toLong()
        when (monthFunW.toInt()-1) {
            1 -> days = days + 31
            2 -> days = days + 31 + 28
            3 -> days = days + 31 + 28 + 31
            4 -> days = days + 31 + 28 + 31 + 30
            5 -> days = days + 31 + 28 + 31 + 30 + 31
            6 -> days = days + 31 + 28 + 31 + 30 + 31 + 30
            7 -> days = days + 31 + 28 + 31 + 30 + 31 + 30 + 31
            8 -> days = days + 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31
            9 -> days = days + 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30
            10 -> days = days + 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31
            11 -> days = days + 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30
        }
        if ((yearFunW.toInt() % 4 == 0) and (monthFunW.toInt() > 2))
            days = days + 1
        days = days + dayFunW.toLong()
        when ((days % 7).toInt()){
            0 -> weekDay = "суббота"
            1 -> weekDay = "воскресенье"
            2 -> weekDay = "понедельник"
            3 -> weekDay = "вторник"
            4 -> weekDay = "среда"
            5 -> weekDay = "четверг"
            6 -> weekDay = "пятница"
            else -> weekDay = ""
        }
        return weekDay
    }
}
