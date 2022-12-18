package heap

class ComparatorHeapImpl<Element>(private val comparator: Comparator<Element>) : AbstractHeap<Element>() {
    override fun compare(a: Element, b: Element): Int {
        return comparator.compare(a, b)
    }

    companion object {
        fun <Element> create(
            elements: ArrayList<Element>,
            comparator: Comparator<Element>
        ): Heap<Element> {
            val heap = ComparatorHeapImpl(comparator)
            heap.heapify(elements)
            return heap
        }
    }
}