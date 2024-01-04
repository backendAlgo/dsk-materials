package challenge

import LinkedList
import Node

fun <T : Any> LinkedList<T>.printInReverse() {
  this.nodeAt(0)?.printInReverse()
}

fun <T : Any> Node<T>.printInReverse() {
  this.next?.printInReverse()?.let {
    print(" <- ")
  }
  print(value)
}
