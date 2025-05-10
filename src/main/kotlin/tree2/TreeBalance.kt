package tree2

import tree.BinaryTree

fun isBalanced(root: BinaryNode<Int>?): Boolean {
    val leftHeight =  treeHeight(root?.leftChild)
    val rightHeight =  treeHeight(root?.rightChild)
    return leftHeight in rightHeight -1 .. rightHeight
}

fun treeHeight(tree: BinaryNode<Int>?): Int {
    if (tree == null) return 0

    return maxOf(treeHeight(tree.leftChild) + 1, treeHeight(tree.rightChild) + 1)
}