import org.junit.jupiter.api.Test
import queue.QueueArrayList

internal class QueueArrayListTest {

    @Test
    fun `test the enqueue operation in queue`() {
        val queue = QueueArrayList<String>()
        queue.enqueue("Bruno")
        queue.enqueue("Ana")
        queue.enqueue("Pablo")
        queue.enqueue("Joaquim")
        println(queue)
        println(queue.dequeue())
        println("Next up: ${queue.peek()}")
    }
}