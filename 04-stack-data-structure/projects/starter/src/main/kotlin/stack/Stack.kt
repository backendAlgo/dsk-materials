package stack

interface Stack<T : Any> {
  val count: Int
  fun peek(): T?
  fun push(element: T)
  fun pop(): T?
  val isEmpty: Boolean
    get() = count == 0
}

class StackImpl<T : Any> : Stack<T> {
  private val storage = arrayListOf<T>()

  companion object {
    fun <T : Any> create(items: Iterable<T>): Stack<T> {
      val stack = StackImpl<T>()
      for (itm in items) {
        stack.push(itm)
      }
      return stack
    }
  }

  override val count: Int
    get() = storage.size

  override fun peek(): T? {
    return storage.getOrNull(storage.lastIndex)
  }

  override fun push(element: T) {
    storage.add(element)
  }

  override fun pop(): T? {
    if (isEmpty) {
      return null
    }
    return storage.removeAt(count - 1)
  }

  override fun toString(): String = buildString {
    appendLine("----top----")
    storage.asReversed().forEach {
      appendLine("$it")
    }
    appendLine("-----------")
  }
}

fun <T : Any> stackOf(vararg elements: T): Stack<T> {
  return StackImpl.create(elements.asList())
}