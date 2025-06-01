package tree

import queue.QueueArrayList
import org.junit.jupiter.api.Test
import java.util.*

fun serializeBinary(node: BinaryTree<Int>): MutableList<Int?> {
    val list = mutableListOf<Int?>()

    val queue = QueueArrayList<BinaryTree<Int>>()
    queue.enqueue(node)
    while (!queue.isEmpty) {
        val dequeue = queue.dequeue()
        dequeue?.value?.let {  list.add(it) }
        dequeue?.leftChild?.let { queue.enqueue(it) }
        dequeue?.rightChild?.let { queue.enqueue(it) }
    }

    return list
}

fun deserialize(data: List<Int?>): BinaryTree<Int>? {
    if (data.isEmpty()) return null

    val root = BinaryTree(data[0]!!)
    val queue: Queue<BinaryTree<Int>> = LinkedList()
    queue.add(root)

    var i = 1
    while (i < data.size) {
        val parent = queue.remove()

        if (i < data.size && data[i] != null) {
            parent.leftChild = BinaryTree(data[i]!!)
            queue.add(parent.leftChild!!)
        }
        i++

        if (i < data.size && data[i] != null) {
            parent.rightChild = BinaryTree(data[i]!!)
            queue.add(parent.rightChild!!)
        }
        i++
    }

    return root
}
class SerializeBinaryTest {
    @Test
    fun `serialize binary tree`() {
        val tree = buildDefaultBinaryTree()
        val serialized = serializeBinary(tree)
        println(serialized?.joinToString())
        val deserialized = deserialize(serialized)
    }
}