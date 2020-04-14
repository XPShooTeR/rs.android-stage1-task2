package subtask5

import kotlin.reflect.KClass
import java.time.LocalDate

class Blocks {

    fun getData(blockA: Array<Any>, blockB: KClass<*>): Any {
        var i = 0
        var itogSum: Int
        var itogString = ""
        var vrem: String
        val formatDate = java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy")
        var itogDate = LocalDate.parse("01.01.1000", formatDate)
        itogSum = 0
        while (i < blockA.size){
            if ((blockA[i] is String) and (blockB == String::class))
                itogString += blockA[i]
            if ((blockA[i] is Int) and (blockB == Int::class)) {
                vrem = blockA[i].toString()
                itogSum = itogSum + vrem.toInt()
            }
            if ((blockA[i] is LocalDate) and (blockB == LocalDate::class))
                if (itogDate < LocalDate.parse(blockA[i].toString().substring(8,10)+"."+blockA[i].toString().substring(5,7)+"."+blockA[i].toString().substring(0,4), formatDate))
                    itogDate = LocalDate.parse(blockA[i].toString().substring(8,10)+"."+blockA[i].toString().substring(5,7)+"."+blockA[i].toString().substring(0,4), formatDate)
            i++
        }
        when (blockB){
            String::class -> return itogString
            Int::class -> return itogSum
            LocalDate::class -> return itogDate.format(formatDate)
            else -> return ""
        }
    }
}
