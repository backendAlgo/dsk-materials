package challenge

import LinkedList

fun <T : Comparable<T>> LinkedList<T>.mergeSorted(otherList: LinkedList<T>): LinkedList<T> {
  val result = LinkedList<T>()
  val firstIterator = iterator()
  val secondIterator = otherList.iterator()
  var first: T? = null
  var second: T? = null
  while (firstIterator.hasNext() && secondIterator.hasNext()) {
    first = first ?: firstIterator.next()
    second = second ?: secondIterator.next()
    if (first < second) {
      result += first
      first = null
    } else {
      result += second
      second = null
    }
  }
  if (first != null) {
    result += first
  }
  while (firstIterator.hasNext()) {
    result += firstIterator.next()
  }
  if (second != null) {
    result += second
  }
  while (secondIterator.hasNext()) {
    result += secondIterator.next()
  }
  return result
}