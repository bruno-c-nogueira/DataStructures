package structures

interface Stack<T> {

    fun pop(): T?

    fun append(value: T)

    fun peek(): T?

    fun isEmpty(): Boolean

    val count: Int
}

class StackImpl<T> : Stack<T> {

    override val count: Int
        get() = storage.size

    private var storage = arrayListOf<T>()

    override fun pop(): T? {
        return if (storage.size == 0) return null
        else storage.removeLast()
    }

    override fun append(value: T) {
        storage.add(value)
    }

    override fun peek(): T? {
        return storage.lastOrNull()
    }

    override fun isEmpty(): Boolean {
        return storage.isEmpty()
    }

    override fun toString(): String {
        return storage.joinToString()
    }

    companion object {
        fun <T> create(items: Iterable<T>): Stack<T> {
            val stack = StackImpl<T>()
            for (i in items){
                stack.append(i)
            }
            return stack
        }
    }
}

fun String.parenthesesValidator(): Boolean {
    val stack = StackImpl<Char>()

    this.forEach {
        if (it == '('){
            stack.append(it)
        } else if(it == ')'){
            if (stack.isEmpty()) return false
        } else {
            stack.pop()
        }
    }
    return stack.isEmpty()

}