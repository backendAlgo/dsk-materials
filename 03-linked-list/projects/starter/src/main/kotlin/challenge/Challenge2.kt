package challenge

import LinkedList
import Node


fun <T : Any> LinkedList<T>.getMiddleSlowFast(): Node<T>? {
  val head = head ?: return null
  var slow = head
  var fast = head
  while (fast.next != null && fast.next!!.next != null) {
    slow = slow.next!!
    fast = fast.next!!.next!!
  }
  return if (fast.next != null) {
    slow.next
  } else {
    slow
  }
}

fun <T : Any> LinkedList<T>.getMiddleRefactoreAfterReadingSolution(): Node<T>? {
  var slow = head
  var fast = head
  while (fast != null) {
    fast = fast.next
    if (fast != null) {
      fast = fast.next
      slow = slow!!.next
    }
  }
  return slow
}

fun <T : Any> LinkedList<T>.getMiddle(): Node<T>? {
  if (isEmpty()) {
    return null
  }
  return nodeAt(size / 2)
}