package linkedlist

import base.Queue

class LinkedListQueue<T : Any> : Queue<T> {
  val linkedList = DoublyLinkedList<T>()
  var size = 0
  override val count: Int
    get() = size

  override fun dequeue(): T? {
    if (isEmpty) {
      return null
    }
    val removedNode = linkedList.node(0)!!
    size--
    return linkedList.remove(removedNode)
  }

  override fun peek(): T? = linkedList.first?.value

  override fun enqueue(element: T): Boolean {
    linkedList.append(element)
    size++
    return true
  }

  override fun toString(): String {
    return linkedList.toString()
  }
}