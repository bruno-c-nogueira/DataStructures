import org.junit.jupiter.api.Test

class BinarySearchTest {
    fun search(nums: IntArray, target: Int): Int {
        var leftPointer = 0
        var rightPointer = nums.size - 1
        var middlePointer = nums.size.div(2)
        while (leftPointer <= rightPointer) {
            val middleElement = nums[middlePointer]

            if (middleElement == target) {
                return middlePointer
            }

            if (target > middleElement) {
                leftPointer = middlePointer + 1
            }
            if (target < middleElement) {
                rightPointer = middlePointer - 1
            }

            middlePointer = (leftPointer + rightPointer).div(2)
        }
        return -1
    }

    @Test
    fun `case A`() {
        val elements = intArrayOf(1, 2, 3, 4, 5, 6, 33, 45, 50, 80)
        val target = 80
        assert(BinarySearchTest().search(elements, target) == 9)
    }

    @Test
    fun `case B`() {
        val elements = intArrayOf(1, 2, 3, 4, 5)
        val target = 3
        assert(BinarySearchTest().search(elements, target) == 2)
    }

    @Test
    fun `case C`() {
        val elements = intArrayOf(1, 2, 3, 4, 5)
        val target = 30
        assert(BinarySearchTest().search(elements, target) == -1)
    }

    fun nextGreatestLetter(letters: CharArray, target: Char): Char {
        var leftPosition = 0
        var rightPosition = letters.size - 1

        while (leftPosition <= rightPosition) {
            val middlePosition = rightPosition +( (leftPosition - rightPosition).div(2))

            if (letters[middlePosition] <= target) {
                leftPosition = middlePosition + 1
            }
            else {
                rightPosition = middlePosition -1
            }



        }
        return letters[rightPosition % letters.size]
    }


    @Test
    fun `case D`() {
        val elements = charArrayOf('c', 'f', 'j', 'x', 'z')
        assert(BinarySearchTest().nextGreatestLetter(elements, 'a') == 'c')
    }

    @Test
    fun `case F`() {
        val elements = intArrayOf(1, 2, 3, 4, 5)
        val target = 3
        assert(BinarySearchTest().search(elements, target) == 2)
    }

    @Test
    fun `case G`() {
        val elements = intArrayOf(1, 2, 3, 4, 5)
        val target = 30
        assert(BinarySearchTest().search(elements, target) == -1)
    }
}