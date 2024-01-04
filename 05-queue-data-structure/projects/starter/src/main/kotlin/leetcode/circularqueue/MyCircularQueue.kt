package leetcode.circularqueue

import kotlin.reflect.KMutableProperty0

class MyCircularQueue(k: Int) {
  private var size = k
  private val array = IntArray(k)
  private var read = 0
  private var write = 0
  private var count = 0
  fun enQueue(value: Int): Boolean {
    if (isFull()) {
      return false
    }
    array[write] = value
    ::write.circularIncrement(size)
    count++
    return true
  }

  private fun KMutableProperty0<Int>.circularIncrement(size: Int): Unit {
    set((get() + 1) % size)
  }

  fun deQueue(): Boolean {
    if (isEmpty()) {
      return false
    }
    ::read.circularIncrement(size)
    count--
    return true
  }

  fun Front(): Int {
    if (isEmpty()) {
      return -1
    }
    return array[read]
  }

  fun Rear(): Int {
    if (isEmpty()) {
      return -1
    }
    return array[write - 1]
  }

  fun isEmpty(): Boolean {
    return count == 0
  }

  fun isFull(): Boolean {
    return count == size
  }

}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * var obj = MyCircularQueue(k)
 * var param_1 = obj.enQueue(value)
 * var param_2 = obj.deQueue()
 * var param_3 = obj.Front()
 * var param_4 = obj.Rear()
 * var param_5 = obj.isEmpty()
 * var param_6 = obj.isFull()
 */