package tree

import sun.misc.Queue


class TreeNode<T>(val value: T) {
    private val children: MutableList<TreeNode<T>> = mutableListOf()

    fun add(child: TreeNode<T>) = children.add(child)

    //Depth-first traversal starts at the root node and explores the tree as far as possible
    //along each branch before reaching a leaf and then backtracking.
    fun forEachDepthFirst(visit: Visitor<T>){
        visit(this)
        children.forEach{
            it.forEachDepthFirst(visit)
        }
    }

    //Level-order traversal is a technique that visits each node of the tree based on the
    //depth of the nodes. Starting at the root, every node on a level is visited before going
    //to a lower level.
    fun forEachLevelOrder(visit: Visitor<T>){
        visit(this)
        val queue = Queue<TreeNode<T>>()
        children.forEach{queue.enqueue(it) }
        var node = queue.dequeue()
        while (node != null){
            visit(node)
            node.children.forEach { queue.enqueue(it) }
            node = queue.dequeue()
        }
    }
}

typealias Visitor<T> = (TreeNode<T>) -> Unit