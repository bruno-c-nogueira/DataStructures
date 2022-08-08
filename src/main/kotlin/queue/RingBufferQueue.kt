package queue

class RingBuffer<T>(val maxSize: Int = 10) {
    val array = mutableListOf<T?>().apply {
        for (index in 0 until maxSize) {
            add(null)
        }
    }

    // Head - remove from the head (read index)
    var head = 0

    // Tail - add to the tail (write index)
    var tail = 0

    // How many items are currently in the queue
    var capacity = 0

    fun clear() {
        head = 0
        tail = 0
    }

    fun enqueue(item: T): RingBuffer<T> {
        // Check if there's space before attempting to add the item
        if (capacity == maxSize) throw OverflowException(
            "Can't add $item, queue is full")

        array[tail] = item
        // Loop around to the start of the array if there's a need for it
        tail = (tail + 1) % maxSize
        capacity++

        return this
    }

    fun dequeue(): T? {
        // Check if queue is empty before attempting to remove the item
        if (capacity == 0) throw UnderflowException(
            "queue.Queue is empty, can't dequeue()")

        val result = array[head]
        // Loop around to the start of the array if there's a need for it
        head = (head + 1) % maxSize
        capacity--

        return result
    }

    fun peek(): T? = array[head]

    /**
     * - Ordinarily, T > H ([isNormal]).
     * - However, when the queue loops over, then T < H ([isFlipped]).
     */
    fun isNormal(): Boolean {
        return tail > head
    }

    fun isFlipped(): Boolean {
        return tail < head
    }

    fun contents(): MutableList<T?> {
        return mutableListOf<T?>().apply {
            var itemCount = capacity
            var readIndex = head
            while (itemCount > 0) {
                add(array[readIndex])
                readIndex = (readIndex + 1) % maxSize
                itemCount--
            }
        }
    }

}

class OverflowException(msg: String) : RuntimeException(msg)
class UnderflowException(msg: String) : RuntimeException(msg)