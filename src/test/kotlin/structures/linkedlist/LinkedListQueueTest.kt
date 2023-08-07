package structures.linkedlist

import org.junit.jupiter.api.Test

class LinkedListQueueTest {
    @Test
    fun `Queue with Doubly Linked List`() {
        val queue = LinkedListQueue<String>().apply {
            enqueue("Ray")
            enqueue("Brian")
            enqueue("Eric")
        }
        println(queue)
        println("Removing -> ${queue.dequeue()}")
        println(queue)
        println("Next up: ${queue.peek()}")
    }
}