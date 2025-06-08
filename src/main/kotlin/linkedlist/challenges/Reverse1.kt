package linkedlist.challenges

import linkedlist.Node

fun reverseLinkedList2(node: Node<Int>): Node<Int>? {
    // 1 -> 2 -> 3
    // <- 1 , 2 -> 3
    // <- 1 <- 2, 3
    var prev: Node<Int>? = null
    var current: Node<Int>? = node
    while(current != null) {
        val next = current.next
        current.next = prev
        prev = current
        current = next
    }
    return prev
}
 class ListNode(var `val`: Int) {
         var next: ListNode? = null
     }
fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    var link1 = list1
    var link2 = list2
    val dummy = ListNode(0)
    var tail = dummy

    while (link1 != null && link2 != null) {
        if (link1.`val` <= link2.`val`) {
            tail.next = ListNode(link1.`val`)
            link1 = link1.next
        } else {
            tail.next = ListNode(link2.`val`)
            link2 = link2.next
        }
        tail = tail.next!!
    }

    // Append the remaining part (only one of these will be non-null)
    while (link1 != null) {
        tail.next = ListNode(link1.`val`)
        tail = tail.next!!
        link1 = link1.next
    }

    while (link2 != null) {
        tail.next = ListNode(link2.`val`)
        tail = tail.next!!
        link2 = link2.next
    }

    return dummy.next
}

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    var size = 0
    var current = head

    // First pass: get size
    while (current != null) {
        size++
        current = current.next
    }

    // Edge case: remove head
    if (n == size) {
        return head?.next
    }

    // Second pass: go to the node before the one to remove
    current = head
    for (i in 0 until size - n - 1) {
        current = current?.next
    }

    // Remove the nth node
    current?.next = current?.next?.next

    return head
}