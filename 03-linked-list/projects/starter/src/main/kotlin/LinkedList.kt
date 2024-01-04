class LinkedList<T : Any> : Collection<T>, MutableIterable<T>, MutableCollection<T> {
  var head: Node<T>? = null
  var tail: Node<T>? = null
  override var size = 0
    private set

  override fun clear() {
    head = null
    tail = null
    size = 0
  }

  override fun addAll(elements: Collection<T>): Boolean {
    for (element in elements) {
      append(element)
    }
    return true
  }

  override fun add(element: T): Boolean {
    append(element)
    return true
  }

  override fun containsAll(elements: Collection<T>): Boolean {
    for (element in elements) {
      if (!contains(element)) {
        return false
      }
    }
    return true
  }

  override fun contains(element: T): Boolean {
    for (value in this) {
      if (value == element) {
        return true
      }
    }
    return false
  }

  fun push(value: T) {
    head = Node(value, head)
    if (isEmpty()) {
      tail = head
    }
    size++
  }

  fun append(value: T) {
    if (isEmpty()) {
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
    if (isEmpty()) {
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

  fun removeLast(): T? {
    if (isEmpty()) {
      return null
    }
    if (size == 1) {
      return pop()
    }
    val head = head ?: return null
    // find the last element
    var curr = head
    var prev = head
    var next = curr.next
    while (next != null) {
      prev = curr
      curr = next
      next = next.next
    }
    // remove element
    prev.next = null
    tail = prev
    return curr.value
  }

  fun removeAfter(node: Node<T>): T? {
    // if removed one is tail
    if (node.next == tail) {
      tail = node
    }
    // store removed value before unlinking
    val removedValue = node.next?.value
    // decrement size
    if (node.next != null) {
      size--
    }
    // skip next node, or link current node to the node after removed node
    node.next = node.next?.next
    return removedValue
  }

  override fun isEmpty() = size == 0
  override fun iterator(): MutableIterator<T> {
    return LinkedListIterator(this)
  }

  override fun retainAll(elements: Collection<T>): Boolean {
    val iterator = iterator()
    var result = false
    while (iterator.hasNext()) {
      val value = iterator.next()
      if (!elements.contains(value)) {
        iterator.remove()
        result = true
      }
    }
    return result
  }

  override fun removeAll(elements: Collection<T>): Boolean {
    var result = false
    for (element in elements) {
      result = remove(element) || result
    }
    return result
  }

  override fun remove(element: T): Boolean {
    if (isEmpty()) {
      return false
    }
    val head = head ?: throw IllegalStateException("head cannot be null")
    if (head.value == element) {
      pop()
      return true
    }
    // start from after head, because we already checked head
    var prev = head
    var current = prev.next
    while (current != null) {
      if (current.value == element) {
        removeAfter(prev)
        return true
      }
      prev = current
      current = current.next
    }
    return false
  }

  override fun toString(): String {
    return if (head == null) "empty list" else head.toString()
  }

}