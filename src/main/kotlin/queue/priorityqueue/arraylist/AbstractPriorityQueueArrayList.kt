package queue.priorityqueue.arraylist

import queue.Queue

abstract class AbstractPriorityQueueArrayList<T> : Queue<T> {
    override fun enqueue(element: T): Boolean {
        elements.add(element)
        sort()
        return true
    }

    override fun dequeue(): T? {
        return if (isEmpty) null else elements.removeAt(0)
    }

    override val count: Int
        get() = elements.size

    override fun peek(): T? {
        return elements.firstOrNull()
    }

    protected val elements = ArrayList<T>()

    abstract fun sort()

    override fun toString(): String {
        return elements.toString()
    }
}