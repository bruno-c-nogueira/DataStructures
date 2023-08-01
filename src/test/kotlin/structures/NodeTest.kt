package structures

import org.junit.jupiter.api.Test
import structures.Node

class NodeTest {
        @Test
        fun `creating and linking nodes`(){
            val node = Node(1)
            val node2 = Node(2)
            val node3 = Node(3)
            node.next = node2
            node2.next = node3

            println(node.toString())
            assert(true)
        }

}