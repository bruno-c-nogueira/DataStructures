import linkedlist.LinkedList
import org.junit.jupiter.api.Test
import queue.QueueArrayList
import queue.QueueLinkedList

class QueueChallenges {

    /*
    Do this for the following queue implementations:
    1. ArrayList
    2. Linked list
    3. Ring buffer
    4. Double stack
    Assume that the list and ring buffer have an initial size of 5.
    */
    @Test
    fun `ArrayList`() {
        val queueArrayList = QueueArrayList<String>()
        queueArrayList.enqueueList(listOf<String>("D", "S", "A", "L", "G"))
        queueArrayList.apply {
            enqueue("R")
            enqueue("O")
            dequeue()
            enqueue("C")
            dequeue()
            dequeue()
            enqueue("K")
        }
        println(queueArrayList)
    }

    @Test
    fun `Linked list`() {
        val linkedList = QueueLinkedList<String>()

        linkedList.enqueueList(listOf<String>("D", "S", "A", "L", "G"))
        linkedList.apply {
            enqueue("R")
            enqueue("O")
            dequeue()
            enqueue("C")
            dequeue()
            dequeue()
            enqueue("K")
        }
        println(linkedList)
    }

    /*
    Creating a board game manager is straightforward. Your primary concern is whose
    turn it is. A queue data structure is a perfect choice to take care of game turns.
    */
    @Test
    fun `game queue turn manager`(){
        val queue = QueueArrayList<String>()
        queue.enqueueList(
            listOf("Bruno", "Ana", "Joao", "Felipe")
        )
        println(queue)
        println(queue.nextPlayer())
        println(queue)
        println(queue.nextPlayer())
        println(queue)
        println(queue.nextPlayer())
        println(queue)
        println(queue.nextPlayer())
        println(queue)

    }

}