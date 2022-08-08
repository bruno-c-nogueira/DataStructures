package stack

interface Stack<T> {

    fun push(element: T)

    fun pop(): T?

    fun peek(): T?

    val count: Int

    val isEmpty: Boolean

}

class StackImpl<T>() : Stack<T> {
    private val storage = arrayListOf<T>()
    override val count: Int
        get() = storage.size

    override val isEmpty: Boolean = storage.isEmpty()
    override fun push(element: T) {
        storage.add(element)
    }

    override fun pop(): T? {
        if (storage.size == 0) {
            return null
        }
        return storage.removeLast()
    }

    override fun peek(): T? {
        return storage.lastOrNull()
    }

    override fun toString() = buildString {
        appendLine("----top----")
        storage.asReversed().forEach {
            appendLine("$it")
        }
        appendLine("-----------")
    }



    companion object {
        fun <T> create ( elements: Iterable<T>): Stack<T> {
            val stack = StackImpl<T>()
            for (item in elements){
                stack.push(item)
            }
            return stack
        }
    }
}
fun String.checkParentheses(): Boolean{
    val stack = StackImpl<Char>()

    this.forEach {
        if (it == '('){
            stack.push(it)
        }else if (it == ')'){
            stack.pop()
        }
    }
    return stack.isEmpty

}