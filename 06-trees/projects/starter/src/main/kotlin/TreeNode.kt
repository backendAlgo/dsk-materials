class TreeNode<T>(val value: T) {
  val children = mutableListOf<TreeNode<T>>()
  fun add(vararg child: TreeNode<T>) = children.addAll(child)
  fun forEachDepthFirst(visitor: Visitor<T>) {
    visitor(this)
    children.forEach {
      it.forEachDepthFirst(visitor)
    }
  }

  fun forEachLevelOrder(visitor: Visitor<T>) {
    val queue = ArrayDeque<TreeNode<T>>()
    queue.addLast(this)
    while (queue.isNotEmpty()) {
      val curr = queue.removeFirst()
      visitor(curr)
      for (child in curr.children) {
        queue.addLast(child)
      }
    }
  }

  fun search(value: T): TreeNode<T>? {
    var result: TreeNode<T>? = null
    forEachLevelOrder {
      if (value == it.value) {
        result = it
      }
    }
    return result
  }
}
typealias Visitor<T> = (TreeNode<T>) -> Unit

fun makeBeverageTree(): TreeNode<String> {
  val tree = TreeNode("Beverages")
  val hot = TreeNode("hot")
  val cold = TreeNode("cold")
  val tea = TreeNode("tea")
  val coffee = TreeNode("coffee")
  val chocolate = TreeNode("cocoa")
  val blackTea = TreeNode("black")
  val greenTea = TreeNode("green")
  val chaiTea = TreeNode("chai")
  val soda = TreeNode("soda")
  val milk = TreeNode("milk")
  val gingerAle = TreeNode("ginger ale")
  val bitterLemon = TreeNode("bitter lemon")
  tree.add(hot)
  tree.add(cold)
  hot.add(tea)
  hot.add(coffee)
  hot.add(chocolate)
  cold.add(soda)
  cold.add(milk)
  tea.add(blackTea)
  tea.add(greenTea)
  tea.add(chaiTea)
  soda.add(gingerAle)
  soda.add(bitterLemon)
  return tree
}