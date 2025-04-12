package stack.challenges

import java.util.*

fun isValid(s: String): Boolean {
    if (s.length == 1) return false
    val stack = Stack<Char>()
    s.forEach { c ->
        if (c == '(' || c == '{' || c == '[') {
            stack.push(c)
        }
        if (c == ')') {
            if (!stack.isEmpty() && stack.peek() == '(') {
                stack.pop()
            } else stack.push(c)
        }
        if (c == '}') {
            if (!stack.isEmpty() && stack.peek() == '{') {
                stack.pop()
            } else {
                stack.push(c)
            }
        }
        if (c == ']') {
            if (!stack.isEmpty() && stack.peek() == '[') {
                stack.pop()
            } else {
                stack.push(c)
            }
        }

    }
    return stack.isEmpty()
}