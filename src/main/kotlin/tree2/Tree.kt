package tree2

import queue.QueueArrayList
import java.util.*


class TreeNode<T>(val value: T) {
    private val children: MutableList<TreeNode<T>> = mutableListOf()

    fun add(child: TreeNode<T>) = children.add(child)

    fun depthFirst(tree: TreeNode<T>) {
        println(tree.value)
        tree.children.forEach {
            depthFirst(it)
        }
    }

    fun levelOrderTraversal(tree: TreeNode<T>) {
        val queue: QueueArrayList<TreeNode<T>> = QueueArrayList<TreeNode<T>>()
        queue.enqueue(tree)
        while (!queue.isEmpty) {
            var nodesLeftInCurrentLevel = queue.count
            while (nodesLeftInCurrentLevel > 0) {
                queue.dequeue()?.let { node ->
                    print(node.value.toString() + " ")
                    node.children.let { queue.enqueueList(it) }
                    nodesLeftInCurrentLevel--
                } ?: break
            }
            println()
        }
    }
}

fun main() {
    makeBeverageTree().run {
        levelOrderTraversal(this)
    }
}

fun makeBeverageTree(): TreeNode<String> {
    val tree = TreeNode("Beverages")
    val hot = TreeNode("hot")
    val cold = TreeNode("cold")
    val tea = TreeNode("tea")
    val coffee = TreeNode("coffee")
    val chocolate = TreeNode("cocoa")
    val blackTea = TreeNode("black")
    val greenTea = TreeNode("green")
    val chaiTea = TreeNode("chai")
    val soda = TreeNode("soda")
    val milk = TreeNode("milk")
    val gingerAle = TreeNode("ginger ale")
    val bitterLemon = TreeNode("bitter lemon")
    tree.add(hot)
    tree.add(cold)

    hot.add(tea)
    hot.add(coffee)
    hot.add(chocolate)

    cold.add(soda)
    cold.add(milk)
    tea.add(blackTea)
    tea.add(greenTea)
    tea.add(chaiTea)
    soda.add(gingerAle)
    soda.add(bitterLemon)
    return tree
}