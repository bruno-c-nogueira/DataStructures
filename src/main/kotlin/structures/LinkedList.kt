package structures

class LinkedList<T> {
    var head: Node<T>? = null
    var tail: Node<T>? = null
    private var size = 0

    fun isEmpty() = size == 0

    override fun toString(): String {
        return if (head == null) {
            "Linked List is empty"
        } else head.toString()
    }

    fun push(value: T) {
        head = Node(value = value, next = head)
        if (tail == null) tail = head
        size++
    }

    fun append(value: T) {
        if (tail == null) {
            push(value)
            return
        }
        tail?.next = Node(value)
        tail = tail?.next
        size++
    }

    fun nodeAt(index: Int): Node<T>? {
        var current = head
        var counter = 0
        while (counter < index && current != null) {
            current = current.next
            counter++
        }
        return current
    }

    fun insert(value: T, afterNode: Node<T>): Node<T>? {
        if (tail == afterNode) {
            append(value)
            return tail
        }
        val newNode = Node(value, afterNode.next)
        afterNode.next = newNode
        return newNode
    }


    fun pop(): Node<T>? {
        val result = head
        head = head?.next
        if (!isEmpty()) {
            size--
        }

        if (isEmpty()) {
            tail = null
        }
        return result
    }

    fun removeLast(): Node<T>? {
        if (head == null) return null
        if (head?.next == null) pop()

        var prev: Node<T>? = null
        var current: Node<T>? = head

        while (current?.next != null) {
            prev = current
            current = current.next
        }
        val result = prev?.next
        prev?.next = null
        return result
    }

    fun removeAfter(node: Node<T>): T? {
        val result = node.next?.value

        if (node.next == tail) {
            tail = node
        }

        if (node.next != null) size--

        node.next = node.next?.next

        return result
    }

    fun reverseLinkedList(): Node<T>? {
        var prev: Node<T>? = null
        var next: Node<T>? = null
        var current = head?.copy()

        while (current != null) {
            next = current.next
            current.next = prev
            prev = current
            current = next
        }
        return prev
    }

    fun getMiddle(): Node<T>? {
        var fast = nodeAt(0)
        var slow = nodeAt(0)

        while (fast != null) {
            fast = fast.next
            if (fast != null) {
                fast = fast.next
                slow = slow?.next
            }
        }
        return slow
    }

    fun mergeTwoLinkedList(first: Node<Int>?, second: Node<Int>?): Node<Int>? {
        var dummyHead: Node<Int>? = Node(-1)
        var current = dummyHead
        var first = first
        var second = second
        while (first != null && second != null) {
            if (first.value!! < second.value!!) {
                current?.next = first
                first = first.next
            } else {
                current?.next = second
                second = second.next
            }
            current = current?.next
        }
        current?.next = first ?: second
        return dummyHead?.next
    }


}

fun <T> LinkedList<T>.reversed(): LinkedList<T> {
    val result = LinkedList<T>()
    val head = this.nodeAt(0)
    if (head != null) {
        addInReverse(result, head)
    }
    return result
}

private fun <T> addInReverse(list: LinkedList<T>, node: Node<T>) {
    val next = node.next
    if (next != null) addInReverse(list, next)
    node.value?.let { list.append(it) }
}

