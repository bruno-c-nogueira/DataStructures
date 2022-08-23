package tree

import org.junit.jupiter.api.Test


class TreeNodeTest {

    @Test
    fun add() {
        val hot = TreeNode("Hot")
        val cold = TreeNode("Cold")

        val beverages = TreeNode("Beverages").run {
            add(hot)
            add(cold)
        }
    }

    @Test
    fun `Depth-first traversal`() {

        makeBeverageTree().forEachDepthFirst {
            println(it.value)
        }

    }

    @Test
    fun `Level order traversal`() {
        val tree = makeBeverageTree()
        tree.forEachLevelOrder {
            println(it.value)
        }
    }

    private fun makeBeverageTree(): TreeNode<String> {
        val tree = TreeNode("Beverages")

        val hot = TreeNode("Hot")
        val cold = TreeNode("Cold")

        val tea = TreeNode("Tea")
        val coffee = TreeNode("Coffee")
        val chocolate = TreeNode("Chocolate")

        val blackTea = TreeNode("black")
        val greenTea = TreeNode("green")
        val chaiTea = TreeNode("chai")
        val gingerAle = TreeNode("ginger ale")
        val bitterLemon = TreeNode("bitter lemon")
        val soda = TreeNode("Soda")
        val milk = TreeNode("Milk")

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
}