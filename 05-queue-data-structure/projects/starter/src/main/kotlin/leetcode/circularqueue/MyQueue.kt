package leetcode.circularqueue

class MyQueue() {
  private val readStack = ArrayDeque<Int>()
  private val writeStack = ArrayDeque<Int>()
  private var peek: Int? = null

  fun push(x: Int) {
    if (writeStack.isEmpty()) {
      peek = x
    }
    writeStack.addFirst(x)
  }

  fun pop(): Int {
    if (readStack.isEmpty()) {
      // if read stack is empty
      // we will copy all elements from write stack
      // but this not often
      // so amortized cost is O(1)
      while (writeStack.isNotEmpty()) {
        readStack.addFirst(writeStack.removeFirst())
      }
    }
    return readStack.removeFirst()
  }

  fun peek(): Int {
    return if (readStack.isNotEmpty()) {
      readStack.first()
    } else {
      peek!!
    }
  }

  fun empty(): Boolean {
    return readStack.isEmpty() && writeStack.isEmpty()
  }
}

fun main() {
  val queue = MyQueue()
  queue.push(1)
  queue.push(2)
}