import linkedlist.LinkedList
import linkedlist.Node
import linkedlist.challenges.*
import linkedlist.challenges.ListNode
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

    @Test
    fun `reverse linked list` () {
        val linkedList = Node<Int>(1)
        linkedList.next = Node(2)
        linkedList.next!!.next = Node(3)

        val test = reverseLinkedList2(linkedList)
        assert(test!= null)
    }

    @Test
    fun `print linked list` () {
        val linkedList = Node<Int>(0)
        linkedList.next = Node(1)
        linkedList.next!!.next = Node(2)
        linkedList.next!!.next!!.next = Node(3)

        printReverse(linkedList)
        assert(true)
    }

    @Test
    fun `find middle` () {
        val linkedList = Node<Int>(0)
        linkedList.next = Node(1)
        linkedList.next!!.next = Node(2)

        findMiddle(linkedList)
        assert(true)
    }

    @Test
    fun `merged linked` () {
        val linkedList = Node<Int>(0)
        linkedList.next = Node(1)
        linkedList.next!!.next = Node(2)

       val linkedList2 = Node<Int>(1)
        linkedList2.next = Node(2)
        linkedList2.next!!.next = Node(3)

        mergeLinkedLists(linkedList, linkedList2)
        assert(true)
    }

    @Test
    fun `merged linked2` () {
        val linkedList = ListNode(0)
        linkedList.next = ListNode(1)
        linkedList.next!!.next = ListNode(2)

       val linkedList2 = ListNode(1)
        linkedList2.next = ListNode(2)
        linkedList2.next!!.next = ListNode(3)

        mergeTwoLists(linkedList, linkedList2)
        assert(true)
    }

    @Test
    fun `remove Nth number` () {
        val linkedList = ListNode(1)
        linkedList.next = ListNode(2)
//        linkedList.next!!.next = ListNode(2)
//        linkedList.next!!.next!!.next = ListNode(3)


        removeNthFromEnd(linkedList, 2)
        assert(true)
    }
}
