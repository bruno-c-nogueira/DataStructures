package tree

import org.junit.jupiter.api.Test

class TrieTest {
    @Test
    fun `insert and contains`() {
        val trie = Trie<Char>()
        trie.insert("cute".toList())
        assert(trie.contains("cute".toList()))
    }

    @Test
    fun `remove test`() {
        val trie = Trie<Char>()
        trie.insert("cut".toList())
        trie.insert("cute".toList())
        println("\n*** Before removing ***")
        assert(trie.contains("cut".toList()))
        println("\"cut\" is in the trie")
        assert(trie.contains("cute".toList()))
        println("\"cute\" is in the trie")
        println("\n*** After removing cut ***")
        trie.remove("cut".toList())
        assert(!trie.contains("cut".toList()))
        assert(trie.contains("cute".toList()))
        println("\"cute\" is still in the trie")
    }

    @Test
    fun `prefix matching`() {
        val trie = Trie<Char>().apply {
            insert("car".toList())
            insert("card".toList())
            insert("care".toList())
            insert("cared".toList())
            insert("cars".toList())
            insert("carbs".toList())
            insert("carapace".toList())
            insert("cargo".toList())

        }
        println("\nCollections starting with \"car\"")
        val prefixedWithCard = trie.collections("car".toList())
        println(prefixedWithCard.joinToString(separator = ""))

        println("\nCollections starting with \"care\"")
        val prefixedWithCare = trie.collections("care".toList())
        println(prefixedWithCare.joinToString())
    }
}