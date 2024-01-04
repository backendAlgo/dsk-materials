package challenge

import base.Queue

fun <T : Any> Queue<T>.nextPlayer(): T? {
  val curr = dequeue() ?: return null
  enqueue(curr)
  return curr
}