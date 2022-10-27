package tree

import kotlin.math.max

typealias VisitorBinaryTree<T> = ((T?) -> Unit)

class BinaryTree<T>(var value: T) {
    var leftChild: BinaryTree<T>? = null
    var rightChild: BinaryTree<T>? = null

    val min: BinaryTree<T>?
        get() = leftChild?.min?: this

    override fun toString() = diagram(this)

    private fun diagram(
        node: BinaryTree<T>?,
        top: String = "",
        root: String = "",
        bottom: String = ""
    ): String {
        return node?.let {
            if (node.leftChild == null && node.rightChild == null) {
                "$root${node.value}\n"
            } else {
                diagram(node.rightChild, "$top ", "$top┌──", "$top│ ") +
                        root + "${node.value}\n" + diagram(
                    node.leftChild,
                    "$bottom│ ", "$bottom└──", "$bottom "
                )
            }
        } ?: "${root}null\n"
    }

    fun traversePreOrder(visit: VisitorBinaryTree<T>) {
        leftChild?.traversePreOrder(visit)
        visit(value)
        rightChild?.traversePreOrder(visit)
    }

    fun height(node: BinaryTree<T>? = this): Int {
        return node?.let { 1 + max(height(node.leftChild),
            height(node.rightChild)) } ?: -1
    }

    fun traversePreOrderWithNull(visit: VisitorBinaryTree<T>) {
        visit(value)
        leftChild?.traversePreOrderWithNull(visit) ?: visit(null)
        rightChild?.traversePreOrderWithNull(visit) ?: visit(null)
    }

    fun serialize(node: BinaryTree<T> = this): MutableList<T?> {
        val list = mutableListOf<T?>()
        node.traversePreOrderWithNull { list.add(it) }
        return list
    }

    fun deserialize(list: MutableList<T?>): BinaryTree<T?>? {
        // 1
        val rootValue = list.removeAt(list.size - 1) ?: return null
        // 2
        val root = BinaryTree<T?>(rootValue)
        root.leftChild = deserialize(list)
        root.rightChild = deserialize(list)
        return root
    }

}