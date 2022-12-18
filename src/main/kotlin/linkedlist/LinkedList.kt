package linkedlist

import stack.StackImpl

class LinkedList<T> {
    var head: Node<T>? = null
    var tail: Node<T>? = null
    private var size = 0

    fun isEmpty() = size == 0

    override fun toString(): String {
        return if (isEmpty()) {
            return "Empty List"
        } else {
            head.toString()
        }
    }

    fun push(value: T): LinkedList<T> {
        // Big O(1)
        head = Node(value, head)
        if (tail == null) {
            tail = head
        }
        size++
        return this
    }

    fun append(value: T) {
        // Big O(1)
        if (isEmpty()) {
            push(value)
            return
        }
        tail?.next = Node(value)
        tail = tail?.next
        size++
    }

    fun nodeAt(index: Int): Node<T>? {
        // Big O(n)
        var currentNode = head
        var currentIndex = 0

        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }
        return currentNode
    }

    fun insert(value: T, afterNode: Node<T>): Node<T>? {
        // Big O(1)
        if (tail == afterNode) {
            append(value)
            return tail
        }
        val newNode = Node(value, afterNode.next)
        afterNode.next = newNode
        size++
        return newNode
    }

    fun pop(): T? {
        // Big O(1)
        if (!isEmpty()) size--
        val result = head?.value
        head = head?.next
        if (isEmpty()) tail = null
        return result
    }

    fun removeLast(): T? {
        // Big O(n)
        val head = head ?: return null
        if (head.next == null) return pop()
        size--

        var prev = head
        var current = head
        var next = current.next

        while (next != null) {
            prev = current
            current = next
            next = current.next
        }
        prev.next = null
        tail = prev
        return current.value
    }

    fun removeAfter(node: Node<T>): T? {
        // Big O(1)
        val result = node.next?.value

        if (node.next == tail) {
            tail = node
        }

        if (node.next != null) {
            size--
        }
        node.next = node.next?.next
        return result
    }

    fun reverseLinkedList(): Node<T>? {
        //Big O(n)
        var current = head
        var next: Node<T>? = null
        var prev: Node<T>? = null
        while (current != null) {
            next = current.next
            current.next = prev
            prev = current
            current = next
        }
        return prev
    }

    fun mergerNodesBetweenZero(head: Node<Int>?): Node<Int>? {
        //https://leetcode.com/problems/merge-nodes-in-between-zeros/
        var head = head?.next
        var current = 0
        var p1: Node<Int>? = Node(0)
        var p2 = p1

        while (head != null) {
            if (head.value != 0) {
                current += head.value!!
            } else {
                p2?.next = Node(current)
                current = 0
                p2 = p2?.next
            }
            head = head.next
        }
        return p1?.next
    }

    fun printInReverse() {
        val stack = StackImpl<T>()
        var head = head
        while (head != null) {
            head.value?.let { stack.push(it) }
            head = head.next
        }
        var node = stack.pop()
        while (node != null) {
            println(node)
            node = stack.pop()
        }
    }

    fun removeElements(`val`: Int): Node<T>? {
        var current = head
        if (current?.next?.next == null && current?.next?.value == `val`) return null

        if (head?.value == `val`){
            head = head?.next
        }

        while (current != null) {
            if (current.next?.value == `val`) {
                current.next = current.next?.next
            }
            current = current.next
        }
        return head?.next
    }

}