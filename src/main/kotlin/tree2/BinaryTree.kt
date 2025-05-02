package tree2

import queue.QueueArrayList
import tree.BinaryTree


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
}
// left -> root -> right
fun BinaryNode<Int>.inOrder() {
    this.leftChild?.inOrder()
    println(this.value)
    this.rightChild?.inOrder()
}

// root -> left -> right
fun preOrder( tree: BinaryNode<Int>?) {
    if (tree == null)
        return

    // First deal with the node
    print(tree.value.toString() + " ");

    // Then recur on left subtree
    preOrder(tree.leftChild);

    // Finally recur on right subtree
    preOrder(tree.rightChild);
}
// left -> right -> root
fun postOrder(tree: BinaryNode<Int>?) {
    if (tree == null) return

    tree.leftChild?.let { postOrder(it) }
    tree.rightChild?.let { postOrder(it) }
    println(tree.value)
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
    println(treeLevelList(root))
}