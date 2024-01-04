package doublestack

import base.Queue

class StackQueue<T : Any> : Queue<T> {
  private val writeStack = StackImpl<T>()
  private val readStack = StackImpl<T>()
  private var peek: T? = null

  override val count: Int
    get() = writeStack.count + readStack.count

  override fun dequeue(): T? {
    if (readStack.isEmpty) {
      while (!writeStack.isEmpty) {
        readStack.push(writeStack.pop()!!)
      }
    }
    return readStack.pop()
  }

  override fun peek(): T? {
    if (readStack.isEmpty) {
      return peek
    }
    return readStack.peek()
  }

  override fun enqueue(element: T): Boolean {
    if (writeStack.isEmpty) {
      peek = element
    }
    writeStack.push(element)
    return true
  }

  override fun toString(): String {
    return "Read Stack: \n$readStack \n Write Stack: \n$writeStack"
  }
}