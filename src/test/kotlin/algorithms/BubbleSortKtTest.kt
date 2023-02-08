package algorithms

import org.junit.jupiter.api.Test

class BubbleSortKtTest {

    @Test
    fun `bubble sort`() {
        val array = arrayListOf(9,4,10,3)
        println("Original List : $array")
        array.bubbleSort1(true)
        println("Bubble sorted: $array")
    }
}