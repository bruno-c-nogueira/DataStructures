package algorithms

fun<T: Comparable<T>> ArrayList<T>.bubbleSort(showPasses: Boolean = false) {
    if (this.size < 2) return

    for (end in (1 until this.size).reversed()){
        var swapped = false
        for(current in 0 until end) {
            if (this[current] > this[current + 1]){
                this.swapAt(current, current +1)
                swapped = true
            }
        }
        if (showPasses) println(this)
        if (!swapped) return
    }
}

fun<T: Comparable<T>> ArrayList<T>.bubbleSort1(showPasses: Boolean = false) {
    if (this.size < 2) return
    for (i in 1 until this.size){
    var swapped = false
        for (j in 1 until this.size){
            if (this[j] < this[j-1]){
                swap(j,j-1)
                swapped = true
            }
        }
        println("$i -- > $this")
        if (!swapped) return
    }
}

fun <T>ArrayList<T>.swap(index1: Int, index2: Int){
    val temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp
}