package structures.queue

import org.junit.jupiter.api.Test

class QueueTest {

    @Test
    fun `queue with array list`() {
        val queue = QueueImpl<String>().apply {
            enqueue("Bruno")
            enqueue("Marcos")
            enqueue("Lucas")
        }
        println(queue)
        println("${queue.dequeue()} was removed")
        println(queue)
        println("Next in line ${queue.peek()}")

    }
}