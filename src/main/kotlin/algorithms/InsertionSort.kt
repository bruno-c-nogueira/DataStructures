package algorithms

fun <T : Comparable<T>> ArrayList<T>.insertSort(showPasses: Boolean = false) {
    if (this.size < 2) return

    for (current in 1 until this.size) {
        for (shifting in current downTo  1) {
            if (this[shifting] < this[shifting - 1]) {
                this.swapAt(shifting, shifting - 1)
            } else {
                break
            }
        }
        if (showPasses) println(this)
    }
}

fun <T : Comparable<T>> ArrayList<T>.insertSort1(showPasses: Boolean = false){
    for (i in 0 until this.size){
        for (j in i downTo 1){
            if (this[j] < this[j-1]){
                swap(j,j-1)
            }else {
                break
            }
        }
        println(this)
    }
}