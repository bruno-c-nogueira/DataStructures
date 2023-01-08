package queue.priorityqueue.arraylist

import java.util.*
import kotlin.collections.ArrayList

class CustomPriorityQueueArrayList<T : Comparable<T>> : AbstractPriorityQueueArrayList<T>() {
    override fun sort() {
        var index = count - 2
        while (index >= 0 &&
            elements[index + 1].compareTo(elements[index]) > 0
        ) {
            swap(index, index + 1)
            index--;
        }
    }



    private fun swap(i: Int, j: Int) {
        val temp = elements[i]
        elements[i] = elements[j]
        elements[j] = temp
    }

}

class ComparablePriorityQueueArrayList<T : Comparable<T>> :
    AbstractPriorityQueueArrayList<T>() {
    override fun sort() {
        elements.sort()
    }
}

class ComparatorPriorityQueueArrayList<T>(
    private val comparator: Comparator<T>
) : AbstractPriorityQueueArrayList<T>() {
    override fun sort() {
        Collections.sort(elements, comparator)
    }
}


data class Person(
    val name: String,
    val age: Int,
    val isMilitary: Boolean
)
