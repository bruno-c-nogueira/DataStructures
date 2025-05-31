package tree2.traverse

import queue.Queue
import queue.QueueArrayList
import tree2.BinaryNode

fun levelOrder(node: BinaryNode<Int>) {
    val queue = QueueArrayList<BinaryNode<Int>>()
    queue.enqueue(node)
    while (!queue.isEmpty){
        val element = queue.dequeue()
        println(element?.value)
        element?.leftChild?.let { queue.enqueue(it) }
        element?.rightChild?.let { queue.enqueue(it) }
    }
}