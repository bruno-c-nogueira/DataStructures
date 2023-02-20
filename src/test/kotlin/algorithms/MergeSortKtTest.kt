package algorithms

import org.junit.jupiter.api.Test
import java.util.*


class MergeSortKtTest {

    @Test
    fun `testing the merge sorting algorithm`() {
        val list = listOf(7, 2, 6, 3, 9)
        println(list)
        println(list.mergeSort())
    }
}