package tree

import org.junit.jupiter.api.Test


class BinaryTreeTest {

    @Test
    fun `building a simple binary tree`() {

        println(buildDefaultBinaryTree())
    }

    @Test
    fun `testing a pre order binary tree`() {
        buildDefaultBinaryTree().traversePreOrder { println(it) }

    }


    @Test
    fun `testing the height of binary tree`() {
        val tree = buildDefaultBinaryTree()
        assert(tree.height() == 2)
    }

//    @Test
//    fun `serialize binary tree`() {
//        val tree = buildDefaultBinaryTree()
//        val array = tree.serialize()
//        println(tree.deserialize(array))
//    }

    @Test
    fun deletingTreeByDeeperNodes() {
        val simpleTree = BinaryTree<Int>(1)
        simpleTree.leftChild = BinaryTree(2)
        simpleTree.leftChild?.leftChild = BinaryTree(4)
        simpleTree.leftChild?.rightChild = BinaryTree(5)

        simpleTree.rightChild = BinaryTree(3)

        simpleTree.deletingDeeperNodes(simpleTree)
    }


}

fun buildDefaultBinaryTree(): BinaryTree<Int> {
    val zero = BinaryTree(0)
    val one = BinaryTree(1)
    val five = BinaryTree(5)
    val seven = BinaryTree(7)
    val eight = BinaryTree(8)
    val nine = BinaryTree(9)

    seven.leftChild = one
    seven.rightChild = nine
    one.leftChild = zero
    one.rightChild = five
    nine.leftChild = eight
    return seven
}