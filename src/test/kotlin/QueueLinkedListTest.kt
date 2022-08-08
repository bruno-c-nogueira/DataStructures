import org.junit.jupiter.api.Test
import queue.QueueLinkedList

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