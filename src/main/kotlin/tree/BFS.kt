package tree

//BREADTH-FIRST ORDER
fun <T>TreeNode<T>.bfs() {
    val queue = mutableListOf(this)
    while(queue.isNotEmpty()){
        val current = queue.removeFirst()
        println(current.value)
        queue.addAll(current.children)
    }
}