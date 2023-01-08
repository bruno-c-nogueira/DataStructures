package queue.priorityqueue.arraylist

import org.junit.jupiter.api.Test
import queue.priorityqueue.heap.ComparatorPriorityQueueImpl
import queue.priorityqueue.heap.MilitaryPersonComparator


class ComparablePriorityQueueArrayListTest {
    @Test
    fun `max priority array list based queue`() {
        val priorityArray = CustomPriorityQueueArrayList<Int>()
        arrayListOf(1, 12, 3, 4, 1, 6, 8, 7).forEach {
            priorityArray.enqueue(it)
        }
        priorityArray.enqueue(5)
        priorityArray.enqueue(0)
        priorityArray.enqueue(10)
        while (!priorityArray.isEmpty) {
            println(priorityArray.dequeue())
        }
    }

    @Test
    fun `Write a sort function that returns the list of people on the waitlist by the appropriate priority`(){
        val p1 = Person("Josh", 21, true)
        val p2 = Person("Jake", 22, true)
        val p3 = Person("Clay", 28, false)
        val p4 = Person("Cindy", 28, false)
        val p5 = Person("Sabrina", 30, true)

        val priorityComparator = ComparatorPriorityQueueImpl(MilitaryPersonComparator)
        arrayListOf(p1,p2,p3,p4,p5).forEach {
            priorityComparator.enqueue(it)
        }
        while(!priorityComparator.isEmpty){
            println(priorityComparator.dequeue())
        }
    }
}