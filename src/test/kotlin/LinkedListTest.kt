import linkedlist.LinkedList
import org.junit.jupiter.api.Test

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
        //println(linked.toString())
        var middleNode = linked.nodeAt(1)!!
        for (i in 1..3){
            middleNode = linked.insert(5 * i, middleNode)!!
        }
        //println(linked.toString())

        val linkedList = LinkedList<Int>()
        linkedList.append(1)
        linkedList.append(3)
        linkedList.append(4)

        linkedList.nodeAt(0)?.let { linkedList.insert(2, it) }
        println(linkedList)
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

    @Test
    fun `mergin nodes between zero`(){
        val linkedList = LinkedList<Int>()
        linkedList.append(0)
        linkedList.append(3)
        linkedList.append(1)
        linkedList.append(0)
        linkedList.append(4)
        linkedList.append(5)
        linkedList.append(2)
        linkedList.append(0)
        println(linkedList)
        //println(linkedList.mergerNodesBetweenZero())
        println(linkedList.mergerNodesBetweenZero(linkedList.head))
    }

    @Test
    fun `reverse linkedlist with stack`(){
        val linkedList = LinkedList<Int>()
        linkedList.append(0)
        linkedList.append(1)
        linkedList.append(2)
        linkedList.append(3)
        linkedList.append(4)
        linkedList.append(5)
        println(linkedList)
        linkedList.printInReverse()
    }

    @Test
    fun `test the remove`(){
        val linkedList = LinkedList<Int>()
        linkedList.append(7)
        linkedList.append(7)
        linkedList.append(7)
        linkedList.append(7)
        linkedList.removeElements(7)
    }
}
