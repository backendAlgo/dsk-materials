package array

import base.Queue

class ArrayListQueue<T : Any> : Queue<T> {
  private val list = arrayListOf<T>()
  override fun enqueue(element: T): Boolean {
    return list.add(element)
  }

  override fun dequeue(): T? {
    if (isEmpty) {
      return null
    }
    return list.removeAt(0)
  }

  override val count: Int
    get() = list.size

  override fun peek(): T? {
    if (isEmpty) {
      return null
    }
    return list[0]
  }

  override fun toString(): String {
    return list.toString()
  }
}