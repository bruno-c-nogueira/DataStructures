package structures.linkedlist

import structures.Queue

class LinkedListQueue<T>: Queue<T> {
    private val list = DoublyLinkedList<T>()

    private var size = 0
    override fun enqueue(element: T): Boolean {
        list.append(element)
        size ++
        return true
    }

    override fun dequeue(): T? {
        val firstNode = list.first() ?: return null
        size--
        return list.remove(firstNode)
    }

    override val count: Int
        get() = size

    override fun peek(): T? {
        return list.first()?.value
    }

    override fun toString(): String {
        return list.toString()
    }

}
