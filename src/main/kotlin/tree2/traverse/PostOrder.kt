package tree2.traverse

import tree2.BinaryNode

// post-order (Left -> Right-> Root)
fun postOrder(node: BinaryNode<Int>?) {
    if (node == null) return
    postOrder(node.leftChild)
    postOrder(node.rightChild)
    print( "${node.value} ")
}
