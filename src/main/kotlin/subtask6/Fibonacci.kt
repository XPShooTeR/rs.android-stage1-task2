package subtask6

class Fibonacci {

    fun productFibonacciSequenceFor(n: Int): IntArray {
        val itogArr = IntArray(3, {0})
        var nextElem: Int
        itogArr[1] = 1
        while (itogArr[0] * itogArr[1] < n){
            nextElem = itogArr[0] + itogArr[1]
            itogArr[0] = itogArr[1]
            itogArr[1] = nextElem
        }
        if (itogArr[0] * itogArr[1] == n)
            itogArr[2] = 1
        return itogArr
    }
}
