package structures

import org.junit.jupiter.api.Test
import structures.linkedlist.LinkedList

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
    fun `test pop`(){
        val linkedList = LinkedList<Int>()
        linkedList.append(1)
        linkedList.append(2)
        linkedList.append(3)
        assert(linkedList.pop()?.value == 1)
    }

    @Test
    fun `test removeLast`() {
        val linkedList = LinkedList<Int>()
        linkedList.append(1)
        linkedList.append(2)
        linkedList.append(3)
        assert(linkedList.removeLast()?.value == 3)
    }

    @Test
    fun `test removeAfter`() {
        val linkedList = LinkedList<Int>()
        linkedList.append(1)
        linkedList.append(2)
        linkedList.append(3)
        linkedList.append(4)
        val target = linkedList.nodeAt(1)
        assert(target?.let { linkedList.removeAfter(it) } == 3)
        println(linkedList)
    }

    @Test
    fun `test reverse linked list`() {
        val linkedList = LinkedList<Int>()
        linkedList.append(1)
        linkedList.append(2)
        linkedList.append(3)
        linkedList.append(4)

        println(linkedList)
        println(linkedList.reverseLinkedList())
    }

    @Test
    fun `test reverse linked list recursively`() {
        val linkedList = LinkedList<Int>()
        linkedList.append(1)
        linkedList.append(2)
        linkedList.append(3)
        linkedList.append(4)

        println(linkedList)
        println(linkedList.reverseLinkedList())
    }

    @Test
    fun `find middle`() {
        val linkedList = LinkedList<Int>()
        linkedList.append(1)
        linkedList.append(2)
        linkedList.append(3)
        linkedList.append(4)
        linkedList.append(5)
        linkedList.append(6)

        println(linkedList.getMiddle())
    }

    @Test
    fun `merge two linked list`() {
        val linkedList = LinkedList<Int>()
        val linkedList2 = LinkedList<Int>()
        linkedList.append(1)
        linkedList.append(2)
        linkedList.append(3)
        linkedList2.append(4)
        linkedList2.append(5)
        linkedList2.append(6)

        println(linkedList.mergeTwoLinkedList(linkedList.head, linkedList2.head))
    }
}