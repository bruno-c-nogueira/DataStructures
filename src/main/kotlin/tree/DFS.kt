package tree

import java.util.*


//DEPTH-FIRST ORDER
fun <T>TreeNode<T>.dfs(){
    val stack = Stack<TreeNode<T>>()
    stack.push(this)
    while (stack.isNotEmpty()){
        val current = stack.pop()
        println(current.value)
        current.children.reversed().forEach {
            stack.push(it)
        }
    }
}