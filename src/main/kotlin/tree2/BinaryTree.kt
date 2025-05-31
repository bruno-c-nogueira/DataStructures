package tree2

import queue.QueueArrayList
import tree.BinaryTree
import tree2.traverse.inOrder
import tree2.traverse.levelOrder
import tree2.traverse.postOrder
import tree2.traverse.preOrder


/**
 * traversal algorithms has both a time and space complexity of O(n)
 */

typealias Visitor<T> = (T) -> Unit

class BinaryNode<T>(val value: T) {
    var leftChild: BinaryNode<T>? = null
    var rightChild: BinaryNode<T>? = null

    override fun toString() = diagram(this)

    private fun diagram(
        node: BinaryNode<T>?,
        top: String = "",
        root: String = "",
        bottom: String = ""
    ): String {
        return node?.let {
            if (node.leftChild == null && node.rightChild == null) {
                "$root${node.value}\n"
            } else {
                diagram(node.rightChild, "$top ", "$top┌──", "$top│ ") +
                        root + "${node.value}\n" + diagram(
                    node.leftChild,
                    "$bottom│ ", "$bottom└──", "$bottom "
                )
            }
        } ?: "${root}null\n"
    }

    fun traversePreOrder(visit: Visitor<T>) {
        visit(value)
        leftChild?.traversePreOrder(visit)
        rightChild?.traversePreOrder(visit)
    }

}
fun binaryHeight(tree: BinaryNode<Int>?): Int {
    if (tree == null) return 0
     return maxOf(binaryHeight(tree.rightChild) + 1, binaryHeight(tree.leftChild) + 1)
}

fun treeLevelList(tree: BinaryNode<Int>?): Int {
    val list = QueueArrayList<BinaryNode<Int>?>()

    list.enqueue(tree)
    var level = 0
    while (!list.isEmpty) {

        repeat(list.count) {
            val dequeue = list.dequeue()
            dequeue?.leftChild?.let { list.enqueue(dequeue.leftChild) }
            dequeue?.rightChild?.let { list.enqueue(dequeue.rightChild) }
        }
        level +=1
    }
    return level
}

fun serialize(tree: BinaryTree<Int>): MutableList<Int?> {
    val list = mutableListOf<Int?>()
    tree.traversePreOrder {
        list.add(it)
    }
    return list
}

fun main() {
    val root = BinaryNode(1)

    root.leftChild = BinaryNode(2)
    root.rightChild = BinaryNode(3)

    root.leftChild?.leftChild = BinaryNode(4)
    root.leftChild?.rightChild = BinaryNode(5)

    root.rightChild?.leftChild = BinaryNode(6)
    root.rightChild?.rightChild = BinaryNode(7)

    root.leftChild?.leftChild?.leftChild = BinaryNode(8)
    root.leftChild?.leftChild?.leftChild?.leftChild = BinaryNode(10)

    root.rightChild?.leftChild?.rightChild = BinaryNode(9)

    println("Traverse Tree In-Order ----")
    inOrder(root)
    println("---------------------------")

    println("Traverse Tree Pre-Order ----")
    preOrder(root)
    println("---------------------------")

    println("Traverse Tree Post-Order ----")
    postOrder(root)
    println("---------------------------")

    println("Traverse Tree Level-Order ----")
    levelOrder(root)
    println("---------------------------")
}