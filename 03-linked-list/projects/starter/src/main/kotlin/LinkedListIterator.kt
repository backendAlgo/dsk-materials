class LinkedListIterator<T : Any>(private val list: LinkedList<T>) : MutableIterator<T> {
  private var nextIndex = 0
  private var lastNode: Node<T>? = null
  override fun hasNext(): Boolean {
    return nextIndex < list.size
  }

  override fun next(): T {
    if (!hasNext()) {
      throw IndexOutOfBoundsException()
    }
    lastNode = if (nextIndex == 0) {
      list.nodeAt(0)
    } else {
      lastNode?.next
    }
    nextIndex++
    return lastNode!!.value
  }

  override fun remove() {
    if (nextIndex == 1) {
      list.pop()
    } else {
      val prevNode = list.nodeAt(nextIndex - 2) ?: return
      list.removeAfter(prevNode)
    }
    nextIndex--
  }
}