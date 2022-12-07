package tree

class TrieNode<Key>(var key: Key?, var parent: TrieNode<Key>?) {
    val children: HashMap<Key, TrieNode<Key>?> = HashMap()
    var isTerminating = false
}

class Trie<Key> {
    private val root = TrieNode<Key>(key = null, parent = null)

    private val storedLists: MutableSet<List<Key>> = mutableSetOf()
    val lists: List<List<Key>>
        get() = storedLists.toList()

    val count: Int
        get() = storedLists.count()

    val isEmpty: Boolean
        get() = storedLists.isEmpty()

    fun insert(list: List<Key>) {
        var current = root
        list.forEach {
            if (current.children[it] == null) {
                current.children[it] = TrieNode(it, current)
            }
            current = current.children[it]!!
        }
        current.isTerminating = true
        storedLists.add(list)
    }

    fun contains(list: List<Key>): Boolean {
        var current = root
        list.forEach {
            val child = current.children[it] ?: return false
            current = child
        }
        return current.isTerminating
    }

    fun remove(collection: Collection<Key>) {
        var current = root
        collection.forEach {
            val child = current.children[it] ?: return
            current = child
        }
        if (!current.isTerminating) return
        // 2
        storedLists.remove(collection)
        current.isTerminating = false
        // 3
        val parent = current.parent
        while (current.children.isEmpty() && !current.isTerminating) {
            parent?.let {
                current.key?.let { key ->
                    it.children[key] = null
                    current = it

                }
            }
        }
    }


    fun collections(prefix: List<Key>): List<List<Key>> {
        var current = root

        prefix.forEach { element ->
            val child = current.children[element] ?: return emptyList()
            current = child
        }

        return collections(prefix, current)
    }

    private fun collections(prefix: List<Key>, node: TrieNode<Key>?): List<List<Key>> {
        val results = mutableListOf<List<Key>>()

        if (node?.isTerminating == true) {
            results.add(prefix)
        }
        node?.children?.forEach { (key, node) ->
            results.addAll(collections(prefix + key, node))
        }
        return results
    }

}