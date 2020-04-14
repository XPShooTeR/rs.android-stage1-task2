package subtask4

class Pangram {

    fun getResult(inputString: String): String {
        var itogString = inputString.toUpperCase()
        var i: Int
        var j = 0
        var isort = 0
        var imin = 0
        var ifrom = 0
        var pangr = 1
        val wordsArr: Array<String> = Array(50, {""})
        val wordsArrInd: Array<Array<Int>> = Array(3, {Array(50, {0})})
        val wordsArrSort: Array<Array<Int>> = Array(2, {Array(50, {0})})
        val letters = Array(26) {il ->('A' + il)}
        var alfav = ""
        i = 0
        while (i < 26) {
            if (letters[i] !in itogString) pangr = 0
            alfav += letters[i]
            i++
        }
        i = 0
        while (i < inputString.length){
            if (inputString[i] == ' ')
                if ((i - ifrom == 0) or (inputString.substring(ifrom, i+1).trim() == ""))
                    ifrom = i + 1
                else{
                    wordsArr[j] = inputString.substring(ifrom, i+1).trim()
                    ifrom = i + 1
                    wordsArrInd[0][j] = j
                    j++
                }
            if (i == inputString.length - 1)
                if (inputString.substring(ifrom, i+1).trim() != "") {
                    wordsArr[j] = inputString.substring(ifrom, i+1).trim()
                    ifrom = i + 1
                    wordsArrInd[0][j] = j
                    j++
                }
            i++
        }
        if (j==0) return ""

        i = 0
        while (i < j){
            wordsArrInd[1][i] = wordSum(wordsArr[i], pangr, alfav)
            i++
        }
        i = 0
        while (i < j){
            while (isort < j) {
                if (wordsArrInd[2][isort] == 0) {
                    imin = isort
                    isort = j
                }
                isort++
            }
            isort = 0
            while (isort < j){
                if (wordsArrInd[2][isort] == 0)
                    if (wordsArrInd[1][isort] < wordsArrInd[1][imin])
                        imin = isort
                isort++
            }
            wordsArrInd[2][imin] = 1
            wordsArrSort[1][i] =wordsArrInd[1][imin]
            wordsArrSort[0][i] =wordsArrInd[0][imin]
            i++
            isort = 0
        }
        i = 1
        itogString = wordsArrSort[1][0].toString()+wordConv(wordsArr[wordsArrSort[0][0]], pangr, alfav)
        while (i < j) {
            itogString += (" " + wordsArrSort[1][i].toString()+wordConv(wordsArr[wordsArrSort[0][i]], pangr, alfav))
            i++
        }
        return itogString
    }
    fun wordSum(word: String, opredFun: Int, alfavFun: String): Int{
        var iword = 0
        var itogGl = 0
        var itogSogl = 0
        val alfavUni = alfavFun + alfavFun.toLowerCase()
        while (iword < word.length){
            if (word[iword] in alfavUni)
                when (word[iword]){
                    'A' -> itogGl++
                    'E' -> itogGl++
                    'I' -> itogGl++
                    'O' -> itogGl++
                    'U' -> itogGl++
                    'Y' -> itogGl++
                    'a' -> itogGl++
                    'e' -> itogGl++
                    'i' -> itogGl++
                    'o' -> itogGl++
                    'u' -> itogGl++
                    'y' -> itogGl++
                    else -> itogSogl++
                }
            iword++
        }
        if (opredFun == 1) return itogGl
        else return itogSogl
    }
    fun wordConv(word: String, opredFun: Int, alfavFun: String): String{
        var iword = 0
        var itogWord = ""
        val alfavUni = alfavFun + alfavFun.toLowerCase()
        while (iword < word.length){
            if (opredFun == 1)
                if (word[iword] in alfavUni)
                    when (word[iword]){
                        'a' -> itogWord += 'A'
                        'e' -> itogWord += 'E'
                        'i' -> itogWord += 'I'
                        'o' -> itogWord += 'O'
                        'u' -> itogWord += 'U'
                        'y' -> itogWord += 'Y'
                        else -> itogWord += word[iword]
                    }
                else itogWord += word[iword]
            else
                if (word[iword] in alfavUni)
                    when (word[iword]){
                        'b' -> itogWord += 'B'
                        'c' -> itogWord += 'C'
                        'd' -> itogWord += 'D'
                        'f' -> itogWord += 'F'
                        'g' -> itogWord += 'G'
                        'h' -> itogWord += 'H'
                        'j' -> itogWord += 'J'
                        'k' -> itogWord += 'K'
                        'l' -> itogWord += 'L'
                        'm' -> itogWord += 'M'
                        'n' -> itogWord += 'N'
                        'p' -> itogWord += 'P'
                        'q' -> itogWord += 'Q'
                        'r' -> itogWord += 'R'
                        's' -> itogWord += 'S'
                        't' -> itogWord += 'T'
                        'v' -> itogWord += 'V'
                        'w' -> itogWord += 'W'
                        'x' -> itogWord += 'X'
                        'z' -> itogWord += 'Z'
                        else -> itogWord += word[iword]
                    }
                else itogWord += word[iword]
            iword++
        }
        return itogWord
    }
}
