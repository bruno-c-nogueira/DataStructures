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
}

fun main() {
    Playground().lengthOfLastWord("a ")
}