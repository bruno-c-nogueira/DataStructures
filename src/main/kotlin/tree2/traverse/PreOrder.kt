package tree2.traverse

import tree2.BinaryNode

// pre-order (Root -> Left -> Right)

fun preOrder(node: BinaryNode<Int>?) {
    if (node == null) return
    println(node.value)
    preOrder(node.leftChild)
    preOrder(node.rightChild)
}
