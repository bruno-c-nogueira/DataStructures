package queue

import linkedlist.DoublyLinkedList

class QueueLinkedList<T>: Queue<T> {
    private val list = DoublyLinkedList<T>()

    private var size = 0
    override val count: Int
        get() = size

    override fun enqueue(element: T): Boolean {
        list.append(element)
        size ++
        return true
    }

    override fun dequeue(): T? {
        val firstNode = list.first() ?: return null
        size --
        list.remove(firstNode)
        return firstNode
    }

    override fun peek(): T? {
        return list.first()
    }

    override fun toString(): String = list.toString()

    fun enqueueList(elements: List<T>){
        elements.forEach {
            enqueue(it)
        }
    }

}