typealias Visitor<T> = (T) -> Unit

class BinaryNode<T : Any>(val value: T) {
  var left: BinaryNode<T>? = null
  var right: BinaryNode<T>? = null

  fun traverseInOrder(visit: Visitor<T>) {
    left?.traverseInOrder(visit)
    visit(value)
    right?.traverseInOrder(visit)
  }

  fun traversePreOrder(visit: Visitor<T>) {
    visit(value)
    left?.traversePreOrder(visit)
    right?.traversePreOrder(visit)
  }

  fun traversePostOrder(visit: Visitor<T>) {
    left?.traversePostOrder(visit)
    right?.traversePostOrder(visit)
    visit(value)
  }

  fun height(node: BinaryNode<T>? = this): Int {
    return node?.let { 1 + maxOf(height(it.left), height(it.right)) } ?: 0
  }

  fun serialize(root: BinaryNode<T>? = this): String {
    val queue = ArrayDeque<T?>()
    traverPreOrderWithNull(root, queue)
    return queue.joinToString(",")
  }

  private fun traverPreOrderWithNull(node: BinaryNode<T>?, queue: ArrayDeque<T?>) {
    queue.addFirst(node?.value)
    if (node == null) {
      return
    }
    traverPreOrderWithNull(node.left, queue)
    traverPreOrderWithNull(node.right, queue)
  }

  // Decodes your encoded data to tree.
  fun deserialize(data: String): BinaryNode<T>? {
    val queue = ArrayDeque(data.split(","))
    return deserialize(queue)
  }

  private fun deserialize(queue: ArrayDeque<String>): BinaryNode<T>? {
    if (queue.isEmpty() || queue.last() == "null") {
      queue.removeLast()
      return null
    }
    val curr = BinaryNode(queue.removeLast() as T)
    curr.left = deserialize(queue)
    curr.right = deserialize(queue)
    return curr
  }


  override fun toString() = diagram(this)
  private fun diagram(
    node: BinaryNode<T>?,
    top: String = "",
    root: String = "",
    bottom: String = ""
  ): String {
    return node?.let {
      if (node.left == null && node.right == null) {
        "$root${node.value}\n"
      } else {
        diagram(node.right, "$top ", "$top┌──", "$top│ ") +
            root + "${node.value}\n" + diagram(
          node.left,
          "$bottom│ ", "$bottom└──", "$bottom "
        )
      }
    } ?: "${root}null\n"
  }
}