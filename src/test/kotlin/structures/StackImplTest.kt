package structures

import org.junit.jupiter.api.Test

class StackImplTest {

    @Test
    fun `testing pop fun`() {
        val stackImpl = StackImpl<Int>()
        stackImpl.append(1)
        stackImpl.append(2)
        stackImpl.append(3)
        println(stackImpl.toString())
        println(stackImpl.pop())
        println(stackImpl.toString())
    }
}