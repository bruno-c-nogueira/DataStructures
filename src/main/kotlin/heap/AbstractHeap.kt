package heap

import java.util.*
import kotlin.collections.ArrayList
import jdk.nashorn.internal.objects.NativeArray.sort as sort1

abstract class AbstractHeap<Element>() : Heap<Element> {
    abstract fun compare(a: Element, b: Element): Int

    var elements: ArrayList<Element> = ArrayList<Element>()

    override val count: Int
        get() = elements.size

    override fun peek(): Element? = elements.firstOrNull()

    private fun leftChild(index: Int) = (2 * index) + 1

    private fun rightChild(index: Int) = (2 * index) + 2

    private fun parent(index: Int) = (index - 1) / 2

    override fun insert(element: Element) {
        elements.add(element)
        siftUp(count - 1)
    }

    fun siftUp(index: Int) {
        var child = index
        var parent = parent(child)
        while (child > 0 && compare(elements[child], elements[parent]) > 0) {
            Collections.swap(elements, child, parent)
            child = parent
            parent = parent(child)
        }
    }

    override fun remove(): Element? {
        if (isEmpty) return null
        Collections.swap(elements, 0, count - 1)
        val item = elements.removeAt(count - 1)
        siftDown(0)
        return item
    }

    override fun remove(index: Int): Element? {
        if (index >= count) return null
        return if (index == count - 1) {
            elements.removeAt(count - 1)
        } else {
            Collections.swap(elements, index, count - 1)
            val item = elements.removeAt(count - 1)
            siftDown(index)
            siftUp(index)
            item
        }
    }

    private fun siftDown(index: Int) {
        var parent = index // 1
        while (true) { // 2
            val left = leftChild(parent) //3
            val right = rightChild(parent)
            var candidate = parent // 4
            if (left < count &&
                compare(elements[left], elements[candidate]) > 0) {
                candidate = left //5
            }
            if (right < count &&
                compare(elements[right], elements[candidate]) > 0) {
                candidate = right // 6
            }
            if (candidate == parent) {
                return // 7
            }
            Collections.swap(elements, parent, candidate) // 8
            parent = candidate
        }
    }

    private fun index(element: Element, i: Int): Int? {
        if (i >= count) {
            return null // 1
        }
        if (compare(element, elements[i]) > 0) {
            return null // 2
        }
        if (element == elements[i]) {
            return i // 3
        }
        val leftChildIndex = index(element, leftChild(i))
        if (leftChildIndex != null) return leftChildIndex // 4
        val rightChildIndex = index(element, rightChild(i))
        if (rightChildIndex != null) return rightChildIndex // 5
        return null // 6
    }

    protected fun heapify(values: ArrayList<Element>) {
        elements = values
        if (!elements.isEmpty()) {
            (count / 2 downTo 0).forEach {
                siftDown(it)
            }
        }
    }

}