package challenge

import TreeNode
import example

fun <T : Any> TreeNode<T>.printEachLevel() {
  val queue = ArrayDeque<TreeNode<T>>()
  queue.addFirst(this)
  while (queue.isNotEmpty()) {
    val size = queue.size
    println(
      (0 until size).map {
        val curr = queue.removeLast()
        for (child in curr.children) {
          queue.addFirst(child)
        }
        curr.value
      }.joinToString(" ")
    )
  }
}

fun main() {
  val head = TreeNode(15)
  head.add(TreeNode(1).apply {
    add(
      TreeNode(1), TreeNode(5), TreeNode(0)
    )
  }, TreeNode(17).apply {
    add(
      TreeNode(2)
    )
  }, TreeNode(20).apply {
    add(TreeNode(5), TreeNode(7))
  })
  "level order traversal" example {
    head.printEachLevel()
  }

}