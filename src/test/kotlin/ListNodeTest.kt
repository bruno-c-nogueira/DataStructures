import org.junit.jupiter.api.Test

data class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class ListNodeTest {
    var head: ListNode? = null
    var tail: ListNode? = null
    var size = 0
    fun push(value: Int): ListNode? {
        head = ListNode(value).apply { next = head }
        if (tail == null) tail = head
        size++
        return head
    }

    fun append(value: Int) {
        if (size == 0) {
            push(value)
            return
        }
        tail?.next = ListNode(value)
        tail = tail?.next
        size++
    }

    @Test
    fun `testing append`() {
        append(1)
        append(2)
        isPalindrome(head)
        println(head)

        println(mergeNodes(head))

    }

    fun mergeNodes(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        var current = head.next
        var preivous = head

        while (current?.next != null) {
            if (current.`val` == 0) {

                preivous?.next = current
                preivous = current
                current = current.next
            } else {
                preivous?.`val` = preivous?.`val`?.plus(current.`val`)!!
                current = current.next
            }
        }
        preivous?.next = null

        return head
    }

    fun isPalindrome(head: ListNode?): Boolean {
        var totalNum = ""
        var current = head
        while(current != null){
            totalNum = "${totalNum}${head?.`val`}"
            current = current?.next
        }
        return totalNum == totalNum.reversed()
    }

}