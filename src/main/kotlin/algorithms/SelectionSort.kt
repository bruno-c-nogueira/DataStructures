package algorithms

fun <T : Comparable<T>> ArrayList<T>.selectionSort(showPasses: Boolean = false) {
    if (this.size < 2) return

    for (current in 0 until (this.size - 1)) {
        var lowest = current
        for (other in (current + 1) until this.size) {
            if (this[lowest] > this[other]) {
                lowest = other
            }
        }
        if (lowest != current){
            this.swapAt(lowest, current)
        }
        if (showPasses) println(this)

    }
}

fun <T : Comparable<T>> ArrayList<T>.selectionSort1() {
    for (current in 0 until this.size-1) {
        var low = current
        for (other in low+1 until this.size){
            if (this[low] > this[other]){
                low = other
            }
        }
            if (low != current) swap(low,current)
            println("$current --> $this")
    }
}
