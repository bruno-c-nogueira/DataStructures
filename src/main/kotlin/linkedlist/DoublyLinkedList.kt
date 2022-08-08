package linkedlist

class DoublyLinkedList<T> : Iterable<T>, Collection<T>, MutableIterable<T>, MutableCollection<T>  {
    var head: Node<T>? = null
    var tail: Node<T>? = null

    override var size = 0
        private set

    override fun clear() {
        head = null
        tail = null
        size = 0
    }

    override fun addAll(elements: Collection<T>): Boolean {
        for (element in elements) {
            append(element)
        }
        return true
    }

    override fun add(element: T): Boolean {
        append(element)
        return true
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        for (item in elements) {
            if (!contains(item)) return false
        }
        return true
    }

    override fun contains(element: T): Boolean {
        for (item in this) {
            if (item == element) {
                return true
            }
        }
        return false
    }

    override fun isEmpty() = size == 0

    override fun iterator(): MutableIterator<T> {
        return LinkedListIterable(this)
    }

    override fun retainAll(elements: Collection<T>): Boolean {
        var result = false
        val iterator = this.iterator()
        while (iterator.hasNext()) {
            val item = iterator.next()
            if (!elements.contains(item)) {
                iterator.remove()
                result = true
            }
        }
        return result
    }

    override fun removeAll(elements: Collection<T>): Boolean {
        var result = false
        for (item in elements) {
            result = remove(item) || result
        }
        return result
    }

    override fun remove(element: T): Boolean {
        val iterator = iterator()
        if (head?.value == element) {
            iterator.remove()
            return true
        }
        while (iterator.hasNext()) {
            val item = iterator.next()

            if (item == element) {
                iterator.remove()
                return true
            }
        }
        return false
    }

    override fun toString(): String {
        return if (isEmpty()) {
            "Empty list"
        } else {
            head.toString()
        }
    }

    fun push(value: T): DoublyLinkedList<T> {
        head = Node(value = value, next = head)
        if (tail == null) {
            tail = head
        }
        size++
        return this
    }

    fun append(value: T) {
        if (isEmpty()) {
            push(value)
            return
        }

        tail?.next = Node(value)

        tail = tail?.next
        size++
    }

    fun nodeAt(index: Int): Node<T>? {
        var currentNode = head
        var currentIndex = 0
        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }
        return currentNode
    }

    fun insert(value: T, afterNode: Node<T>): Node<T> {
        if (tail == afterNode) {
            append(value)
            return tail!!
        }
        val newNode = Node(value, afterNode.next)
        afterNode.next = newNode
        size++
        return newNode
    }

    fun pop(): T? {
        if (!isEmpty()) {
            size--
        }
        val result = head?.value
        head = head?.next
        if (isEmpty()) {
            tail = null
        }
        return result
    }

    fun removeLast(): T? {
        val head = head ?: return null

        if (head.next == null) {
            return pop()
        }

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



    fun middleElementInList(): T? {
        var fast = nodeAt(0)
        var slow = nodeAt(0)
        while (fast != null){
            fast = fast.next
            if (fast != null){
                fast = fast.next
                slow = slow?.next
            }
        }
        return slow?.value
    }

}