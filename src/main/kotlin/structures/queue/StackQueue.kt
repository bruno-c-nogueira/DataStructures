package structures.queue

import structures.StackImpl

class StackQueue<T>: Queue<T> {
    private val leftStack = StackImpl<T>()
    private val rightStack = StackImpl<T>()

    override val isEmpty: Boolean
        get() = leftStack.isEmpty() && rightStack.isEmpty()

    override val count: Int
        get() = maxOf(rightStack.count, leftStack.count)

    private fun transferElement() {
        var nextElement = rightStack.pop()
        while (nextElement != null) {
            leftStack.append(nextElement)
            nextElement = rightStack.pop()
        }
    }

    override fun peek(): T? {
        if(leftStack.isEmpty()) transferElement()
        return leftStack.peek()
    }

    override fun enqueue(element: T): Boolean {
        rightStack.append(element)
        return true
    }

    override fun dequeue(): T? {
        if(leftStack.isEmpty()) transferElement()
        return leftStack.pop()
    }

    override fun toString(): String {
        return "Left stack: \n$leftStack \n Right stack: $rightStack"
    }


}