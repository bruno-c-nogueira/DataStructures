package structures

data class NodePrev<T>(var value: T?, var next: NodePrev<T>? = null, var prev: NodePrev<T>? = null){
    override fun toString(): String {
        return if (next != null) {
            "$value -> ${next.toString()}"
        } else {
            "$value" }
    }
}
