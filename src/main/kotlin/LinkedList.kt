class LinkedList<T> {
    var head : Node<T>? = null
    var tail : Node<T>? = null
    private var size = 0

    fun isEmpty() = size == 0

    override fun toString(): String {
        return if (isEmpty()){
            return "Empty List"
        }else {
            head.toString()
        }
    }

    fun push(value: T): LinkedList<T>?{
        head = Node(value, head)
        if (tail == null){
            tail = head
        }
        size ++
        return this
    }

    fun append(value: T) {
        if (isEmpty()){
            push(value)
            return
        }
        tail?.next = Node(value)
        tail = tail?.next
        size++
    }

    fun nodeAt(index: Int): Node<T>?{
        var currentNode = head
        var currentIndex = 0

        while(currentNode != null && currentIndex < index){
            currentNode = currentNode.next
            currentIndex ++
        }
        return currentNode
    }

    fun insert(value: T, afterNode: Node<T>): Node<T>?{
        if (tail == afterNode){
            append(value)
            return tail
        }
        val newNode = Node(value, afterNode.next)
        afterNode.next = newNode
        size ++
        return newNode
    }
}