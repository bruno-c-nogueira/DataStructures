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

    @Test
    fun `Search in a tree`() {
        val tree = makeBeverageTree()
        tree.search("ginger ale")?.let {
            println("Found node: ${it.value}")
        }
        tree.search("WKD Blue")?.let {
            println(it.value)
        } ?: println("Couldn't find WKD Blue")
    }

    //Challenge 1
    @Test
    fun `Print values in a tree in an order based on their level`() {
        val oneLevel = TreeNode(15)

        val twoLevel1 = TreeNode(1)
        val twoLevel2 = TreeNode(17)
        val twoLevel3 = TreeNode(20)

        val threeLevel1 = TreeNode(1)
        val threeLevel2 = TreeNode(5)
        val threeLevel3 = TreeNode(0)

        val threeLevel4 = TreeNode(2)

        val threeLevel5 = TreeNode(5)
        val threeLevel6 = TreeNode(7)

        oneLevel.add(twoLevel1)
        oneLevel.add(twoLevel2)
        oneLevel.add(twoLevel3)

        twoLevel1.add(threeLevel1)
        twoLevel1.add(threeLevel2)
        twoLevel1.add(threeLevel3)

        twoLevel2.add(threeLevel4)

        twoLevel3.add(threeLevel5)
        twoLevel3.add(threeLevel6)

        oneLevel.printEachLevel()

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