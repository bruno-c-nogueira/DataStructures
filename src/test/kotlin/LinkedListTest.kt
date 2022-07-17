import org.junit.jupiter.api.Test
import sun.awt.image.ImageWatched.Link

class LinkedListTest {

    @Test
    fun `test the push operation`(){
        val linked = LinkedList<Int>()
        linked.push(1)
        linked.push(2)
        linked.push(3)
        println(linked.toString())
        assert(!linked.isEmpty())
    }

    @Test
    fun `test append operation`(){
        val linked = LinkedList<Int>()
        linked.append(1)
        linked.append(2)
        linked.append(3)
        println(linked.toString())
    }

    @Test
    fun `test insertAt operation`(){
        val linked = LinkedList<Int>()
        linked.append(1)
        linked.append(2)
        linked.append(3)
        println(linked.toString())
        var middleNode = linked.nodeAt(1)!!
        for (i in 1..3){
            middleNode = linked.insert(5 * i, middleNode)!!
        }
        println(linked.toString())
    }

    @Test
    fun `pop operation, removing first element`(){
        val linked = LinkedList<Int>()
        linked.append(1)
        linked.append(2)
        linked.append(3)
        println(linked)
        println(linked.pop())
        println(linked)
    }

    @Test
    fun `removeLast operation`(){
        val linked = LinkedList<Int>()
        linked.append(1)
        linked.append(2)
        linked.append(3)
        println(linked)
        println(linked.removeLast())
        println(linked)
    }

    @Test
    fun `removeAfter operation`(){
        val linked = LinkedList<Int>()
        linked.append(1)
        linked.append(2)
        linked.append(3)
        println(linked)
        println(linked.nodeAt(1)?.let { linked.removeAfter(it) })
        println(linked)
    }

    @Test
    fun `reversing linked list`(){
        val linkedList = LinkedList<Int>()
        linkedList.append(1)
        linkedList.append(2)
        linkedList.append(3)
        println(linkedList)
        println(linkedList.reverseLinkedList())
        println(linkedList)
    }
}
