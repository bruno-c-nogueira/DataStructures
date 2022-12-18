package heap

class ComparableHeapImpl<Element : Comparable<Element>>() :
    AbstractHeap<Element>() {
    override fun compare(a: Element, b: Element): Int =
        a.compareTo(b)

    companion object {
        fun <Element : Comparable<Element>> create(
            elements: ArrayList<Element>
        ): Heap<Element> {
            val heap = ComparableHeapImpl<Element>()
            heap.heapify(elements)
            return heap
        }
    }
}