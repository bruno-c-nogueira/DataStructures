package queue.priorityqueue.heap

import heap.Heap

abstract class AbstractPriorityQueue<T>: Heap<T> {
    abstract val heap: Heap<T>

    override val count: Int
        get() = heap.count

    override fun peek(): T? {
        return heap.peek()
    }
    fun enqueue(element: T): Boolean{
        heap.insert(element)
        return true
    }

    fun dequeue() = heap.remove()


}