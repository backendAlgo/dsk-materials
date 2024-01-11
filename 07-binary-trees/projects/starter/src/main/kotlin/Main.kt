fun main() {
  val zero = BinaryNode(0)
  val one = BinaryNode(1)
  val fife = BinaryNode(5)
  val seven = BinaryNode(7)
  val nine = BinaryNode(9)
  val eight = BinaryNode(8)
  one.left = zero
  one.right = fife
  seven.left = one
  seven.right = nine
  nine.left = eight
  val tree = seven
  println(tree)
//  tree.traverseInOrder { println(it) }
//  println(tree.height())
  val str = tree.serialize()
  println(str)
  val deserializedTree = tree.deserialize(str)
  println(deserializedTree)
}