fun main() {
  val tree = makeBeverageTree()
  tree.forEachDepthFirst { println(it.value) }
  println("-------")
  tree.forEachLevelOrder { println(it.value) }
}
