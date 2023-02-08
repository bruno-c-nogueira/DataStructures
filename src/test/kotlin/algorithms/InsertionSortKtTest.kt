package algorithms

import org.junit.jupiter.api.Test
import kotlin.random.Random

class InsertionSortKtTest {

    @Test
    fun `insertion sort`() {
        val list = arrayListOf(9, 4, 10, 3)
        var shuffledList = ArrayList((0..40).toList())
        shuffledList.shuffle()

        println("Original $list")
        list.insertSort1(false)
        println("Insert sorted: $list")
    }
}