import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class QueueLinkedListTest{

    @Test
    fun `queue with doubly linked list`(){
        val queue = QueueLinkedList<String>().apply {
            enqueue("Bruno")
            enqueue("Ana")
            enqueue("Kamily")
            enqueue("Erick")
        }
        println(queue)
        println("Nest up: ${queue.peek()}")
    }
}