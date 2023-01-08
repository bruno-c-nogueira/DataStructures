package queue.priorityqueue.heap

import heap.ComparableHeapImpl
import heap.ComparatorHeapImpl
import queue.priorityqueue.arraylist.Person

class ComparablePriorityQueueImpl<T: Comparable<T>>() : AbstractPriorityQueue<T>() {
    override val heap = ComparableHeapImpl<T>()

    override fun insert(element: T) {
        TODO("Not yet implemented")
    }

    override fun remove(): T? {
        TODO("Not yet implemented")
    }

    override fun remove(index: Int): T? {
        TODO("Not yet implemented")
    }
}
 class ComparatorPriorityQueueImpl<T>(
    private val comparator: Comparator<T>
) : AbstractPriorityQueue<T>() {
    override val heap = ComparatorHeapImpl(comparator)
     override fun remove(): T? {
         TODO("Not yet implemented")
     }

     override fun remove(index: Int): T? {
         TODO("Not yet implemented")
     }

     override fun insert(element: T) {
         TODO("Not yet implemented")
     }
 }

object MilitaryPersonComparator : java.util.Comparator<Person> {
    override fun compare(o1: Person?, o2: Person?): Int {
        if (o1?.isMilitary == true && o2?.isMilitary == false) {
            return 1
        } else if (o1?.isMilitary == false && o2?.isMilitary == true) {
            return -1
        } else if (o1?.isMilitary == true && o2?.isMilitary == true) {
            return o1.age.compareTo(o2.age)
        }

        return 0
    }
}