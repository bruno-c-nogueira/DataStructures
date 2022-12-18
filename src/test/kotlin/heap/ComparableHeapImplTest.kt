package heap

import org.junit.jupiter.api.Test


class ComparableHeapImplTest {

    @Test
    fun creatingMaxHeap() {
        val array = arrayListOf(1, 12, 3, 4, 1, 6, 8, 7) // 1
        val priorityQueue = ComparableHeapImpl.create(array) // 2
        while (!priorityQueue.isEmpty) { // 3
            println(priorityQueue.remove())
        }
    }

    @Test
    fun creatingMinHeap() {
        val array = arrayListOf<Int>(1, 12, 3, 4, 1, 6, 8, 7)
        val inverseComparator = Comparator<Int> { o1, o2 -> o2.compareTo(o1) }
        val minHeap = ComparatorHeapImpl.create(array, inverseComparator)
        while (!minHeap.isEmpty) {
            println(minHeap.remove())
        }
    }
}