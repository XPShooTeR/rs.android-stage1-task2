package subtask3

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {
        val itogString = a.toUpperCase()
        var i = 0
        var j = 0
        while (i < itogString.length){
            if (j < b.length)
                if (itogString[i] == b[j])
                    j++
            i++
        }
        if (j == b.length)
            return "YES"
        else
            return "NO"
    }
}
