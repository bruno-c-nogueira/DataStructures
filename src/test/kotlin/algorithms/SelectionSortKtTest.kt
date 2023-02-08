package algorithms

import org.junit.jupiter.api.Test


class SelectionSortKtTest {

    @Test
    fun `selection sort`() {
        val list = arrayListOf(9, 4, 10, 3)
        println("Original $list")
        list.selectionSort1()
        println("Bubble sorted: $list")
    }
}