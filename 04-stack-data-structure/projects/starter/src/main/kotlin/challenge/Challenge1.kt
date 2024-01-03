package challenge

import linkedlist.LinkedList
import stack.StackImpl

fun <T : Any> LinkedList<T>.printInReverse() {
  val stack = StackImpl.create(this)
  while (!stack.isEmpty) {
    println("${stack.pop()}")
  }
}