package queue

class QueueArrayList<T>() : Queue<T> {

    private val list = arrayListOf<T>()

    override val count: Int
        get() = list.size

    override fun enqueue(element: T): Boolean {
        return list.add(element)
    }

    override fun dequeue(): T? {
        return if (isEmpty) null else list.removeAt(0)
    }

    override fun peek(): T? = list.firstOrNull()

    override fun toString(): String {
        return list.toString()
    }
}