import linkedlist.LinkedList

class Playground {
    fun lengthOfLastWord(s: String): Int {
        if (s.length == 1) return 1
        var lastWorld = 0
        for (i in s.length - 1 downTo 0) {
            if (s[i] != ' ') {
                lastWorld++
            }
            if (i > 0 && s[i - 1] == ' ' && lastWorld != 0) {
                break
            }
        }
        return lastWorld

    }

//    fun plusOne(digits: IntArray): IntArray {
//        val result = arrayListOf<Int>()
//        var digitsSum = ""
//        digits.forEach {
//            digitsSum = "${digitsSum}$it"
//        }
//        runCatching {
//            digitsSum.toBigDecimal().let { it ->
//                it.plus(1).toString().let { str ->
//                    str.forEach {char ->
//                    result.add(char.digitToInt())
//
//                    }
//                }
//            }
//        }
//        return result.toIntArray()
//    }

    fun plusOne1(digits: IntArray): IntArray {
        if (digits.isEmpty()) return digits
        if (digits.last() < 9) {
            digits[digits.lastIndex] = digits[digits.lastIndex] + 1
            return digits
        }

        val result = arrayListOf<Int>()
        for (i in digits.size - 1 downTo 0) {
            if (i == 0 && digits[i] < 9) {
                digits[i] = digits[i] + 1
                return digits
            }

            if (digits[i] == 9) {
                digits[i] = 0
            }
            if (i == 0 && digits[i] == 0) {
                result.add(1)
                digits.forEach {
                    result.add(it)
                }
                return result.toIntArray()
            }
        }

        return result.toIntArray()
    }

    fun isStrictlyPalindromic(n: Int): Boolean {
        var divRes = ""
        var currentN = n
        for (i in 2..n - 2) {
            while (currentN > 0) {
                divRes = "${divRes}${currentN.rem(i)}"
                currentN = currentN.div(i)
            }
            if (divRes.reversed() != divRes) {
                return false
            }
            divRes = ""
            currentN = n
        }
        return true

    }

    fun searchRange(nums: IntArray, target: Int): IntArray {
        if (nums.isEmpty()) {
            return intArrayOf(-1, -1)
        }
        if (nums.size == 1) {
            return if (nums[0] == target) {
                intArrayOf(0, 0)
            } else {
                intArrayOf(-1, -1)
            }
        }
        var positions = arrayListOf<Int>()
        if (nums[0] == target) {
            for (i in nums.indices) {
                if (nums[i] == target) {
                    positions.add(i)
                } else break
            }

            return positions.toIntArray()
        }
        var middlePosition = nums.size / 2
        var leftPointer = 0
        var rightPointer = nums.size - 1
        while (nums.size > middlePosition) {
            var middleElement = nums[middlePosition]
            if (middleElement == target) {
                positions.add(middlePosition)
                while (middleElement == target) {
                    middlePosition += 1
                    middleElement = nums[middlePosition]
                    if (middleElement == target) {
                        positions.add(middlePosition)
                    }
                }
            }

            if (target < middleElement) {
                rightPointer = middlePosition - 1
            }

            if (target > middlePosition) {
                leftPointer = middlePosition + 1
            }
            if (leftPointer > rightPointer) {
                return if (positions.size == 0) {
                    positions.add(-1)
                    positions.add(-1)
                    positions.toIntArray()
                } else {

                    positions.toIntArray()
                }
            }
            middlePosition = (leftPointer + rightPointer).div(2)


        }
        return if (positions.size == 0) {
            positions.add(-1)
            positions.add(-1)
            positions.toIntArray()
        } else {

            positions.toIntArray()
        }
    }


    fun addBinary(a: String, b: String): String {
        val builder = StringBuilder()
        for (i in b.length - 1 downTo 0) {
            if (a[i] == '1' && b[i] == '1') {
                builder.append('0')
                if (i == 0) {
                    builder.append('1')
                }
            } else {
                builder.append('1')
            }
        }
        return builder.toString()
    }




}

fun main() {
    println(Playground().addBinary("11", "1"))
}