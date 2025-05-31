package tree2.traverse

import tree2.BinaryNode

// in-order (Left -> Root -> Right)

fun inOrder(node: BinaryNode<Int>?) {
    if (node == null) return
    inOrder(node.leftChild)
    println(node.value)
    inOrder(node.rightChild)
}