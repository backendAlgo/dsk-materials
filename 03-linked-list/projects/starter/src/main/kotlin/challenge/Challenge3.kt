package challenge

import LinkedList
import Node

fun <T : Any> LinkedList<T>.reversed(): LinkedList<T> {
  val result = LinkedList<T>()
  for (element in this) {
    result.push(element)
  }
  return result
}

fun <T : Any> LinkedList<T>.reverse() {
  var prev: Node<T>? = null
  var curr = head
  while (curr != null) {
    val next = curr.next
    curr.next = prev
    prev = curr
    curr = next
  }
  val temp = tail
  tail = head
  head = temp
}