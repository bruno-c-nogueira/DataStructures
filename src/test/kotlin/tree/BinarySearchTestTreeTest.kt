package tree

import org.junit.jupiter.api.Test


class BinarySearchTestTreeTest {
    private val example = BinarySearchTree<Int>().apply {
        insert(3)
        insert(1)
        insert(4)
        insert(0)
        insert(2)
        insert(5)
    }

    @Test
    fun `building a Binary Search Tree`() {
        val bst = BinarySearchTree<Int>()
        (0..4).forEach {
            bst.insert(it)
        }
        println(bst)
    }

    @Test
    fun `self-balancing trees`() {

        println(example.contains(5))
        println(example)
    }

    @Test
    fun `removing a node`() {
        println("Tree before removal:")
        println(example)
        example.remove(3)
        println("Tree after removing root:")
        println(example)
    }


}