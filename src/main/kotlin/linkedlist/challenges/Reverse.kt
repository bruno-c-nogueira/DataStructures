package linkedlist.challenges

import linkedlist.Node

fun reverseLinkedList(node: Node<Int>): Node<Int>? {
    var prev: Node<Int>? = null
    var current: Node<Int>? = node
    // 0 -> 1 -> 2
    while (current != null) {
        val next = current.next
        current.next = prev
        prev = current
        current = next
    }
    return prev
}

fun printReverse(node: Node<Int>?) {
    if (node?.next != null) printReverse(node.next)
    if (node?.next != null) {
        print(" -> ")
    }
    print(node?.value)
}

fun findMiddle(node: Node<Int>?): Int {
    var items = mutableListOf<Int>()
    var current = node


    while(current?.next != null) {
        items.add(current.value ?: 0)
        current = current.next
    }
    return items[items.size / 2]
}

fun mergeLinkedLists(node1: Node<Int>, node2: Node<Int>): Node<Int>? {
    var head: Node<Int>? = null
    var tail: Node<Int>? = null

    var right:Node<Int>? = node1
    var left:Node<Int>? = node2

    while(right?.next != null && left?.next != null) {
        val smaller = if(right.value!! < node2.value!!) {
            val value = right.value
            right = right.next
            value
        } else {
            val value = left.value
            left = left.next
            value
        }
        if (head == null) {
            head = Node(smaller, null)
            tail = head
        } else {
            tail?.next = Node(smaller, null)
            tail = Node(smaller, null)
        }
    }
    return head
}