package algorithms

class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        val set = hashSetOf<Int>()
        for (i in 0 .. nums.size / 2) {
            if(set.contains(nums[i])){
                return true
            } else {
                set.add(nums[i])
            }

            if(set.contains(nums[nums.size -1 - i])) {
                return true
            } else {
                set.add(nums[nums.size -1 - i])
            }
        }
        return false
    }
}

fun isAnagram(s: String, t: String): Boolean {
    if(s.length != t.length) return false
    val sArray = s.toCharArray().sortedArray()
    val tArray = t.toCharArray().sortedArray()
    for (i in sArray.indices) {
        if (sArray[i] != tArray[i]) return false
    }
    return true
}
fun main() {
    Solution().containsDuplicate(intArrayOf(1000000000,1000000000,11))
}
fun IntArray.swipe(i: Int, j: Int) {
    val current = this[i]
    this[i] = this[j]
    this[j] = current
}