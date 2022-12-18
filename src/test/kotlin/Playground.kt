


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
   var right: TreeNode? = null
}

class Solution {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        var first = mutableListOf<Int?>()
        var counter = 0
        var isSame = true

        if(q == null && p == null) return true
        if(p == null) return false
        if(q == null) return false
        p.traversePreOrder{
            first.add(it?.`val`)
        }

        q.traversePreOrder(isSame) {
            if(it?.`val` != first.getOrNull(counter)){
                isSame = false
            }
            counter ++
        }
        return isSame
    }

    private fun TreeNode.traversePreOrder(shouldContinue: Boolean? = null, visit: Visitor<TreeNode?>){
        if(shouldContinue != false){
            left?.traversePreOrder( shouldContinue, visit)
            visit(this)
            right?.traversePreOrder( shouldContinue, visit)
        }
    }
}
typealias Visitor<T> = (T) -> Unit

