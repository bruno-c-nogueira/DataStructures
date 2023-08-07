package structures.linkedlist

import structures.NodePrev

class DoublyLinkedList<T> {
    private var head: NodePrev<T>? = null
    private var tail: NodePrev<T>? = null

    fun append(element: T) {
        if (head == null) {
            head = NodePrev(element, null, null)
            tail = head
            return
        }
        tail?.next = NodePrev(value = element, null, tail)
        tail = tail?.next
    }

    fun first() = head

    fun remove(node: NodePrev<T>): T? {
        var current = head
        if (node == head) {
            head = head?.next
            return node.value
        }
        while (current != null) {
            if (node == current) {
                current.prev?.next = current.next
                return node.value
            }
            current = current.next

        }

        return null
    }

    override fun toString(): String {
        return head.toString()
    }
}