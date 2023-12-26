class LinkedList<T : Any> {
  private var head: Node<T>? = null
  private var tail: Node<T>? = null
  private var size = 0

  fun push(value: T) {
    head = Node(value, head)
    if (size == 0) {
      tail = head
    }
    size++
  }

  fun append(value: T) {
    if (size == 0) {
      push(value)
    } else {
      val newNode = Node(value)
      tail!!.next = newNode
      tail = newNode
      size++
    }
  }

  fun nodeAt(index: Int): Node<T>? {
    var i = 0
    var iterator = head
    while (i < index && iterator != null) {
      iterator = iterator.next
      i++
    }
    return iterator
  }

  fun insert(value: T, afterNode: Node<T>): Node<T> {
    // if it is tail
    if (tail == afterNode) {
      append(value)
      return tail!!
    }

    val newNode = Node(value, afterNode.next)
    afterNode.next = newNode
    size++
    return newNode
  }

  fun pop(): T? {
    if (size == 0) {
      return null
    }
    val returnedValue = head!!.value
    head = head!!.next
    if (size == 1) {
      tail = null
    }
    size--
    return returnedValue
  }

  fun isEmpty() = size == 0
  override fun toString(): String {
    return if (head == null) "empty list" else head.toString()
  }

}