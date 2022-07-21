import org.junit.jupiter.api.Test

class StackTest {

    @Test
    fun `using a stack`() {
        val stack: Stack<Int> = StackImpl()

        stack.push(1)
        stack.push(2)
        stack.push(3)
        println(stack)
        val popElement = stack.pop()
        popElement?.let {
            println("Popped : $popElement")
        }
        println(stack)
    }

    @Test
    fun `initializing a stack with list`() {
        val names = listOf("Bruno", "Ana", "Jose")

        val stack = StackImpl.create(names)
        println(stack)
        //println(stack.pop())
        println(stack)

    }

    @Test
    fun `check parentheses in the string`(){
        val test = "h((e))llo(world)()"
        assert(test.checkParentheses())

    }
}