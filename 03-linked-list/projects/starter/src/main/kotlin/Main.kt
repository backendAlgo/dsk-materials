import challenge.*

fun main() {
  "creating node with linking nodes" example {
    val node1 = Node(1)
    val node2 = Node(2)
    val node3 = Node(3)

    node1.next = node2
    node2.next = node3
    println(node1)
  }

  "inserting at a particular index" example {
    val list = LinkedList<Int>()
    list.push(3)
    list.push(2)
    list.push(1)
    println("Before inserting: $list")
    var middleNode = list.nodeAt(1)!!
    for (i in 1..3) {
      middleNode = list.insert(-1 * i, middleNode)
    }
    println("After inserting: $list")
  }

  "removing the last node" example {
    val list = LinkedList<Int>()
    list.push(3)
    list.push(2)
    list.push(1)
    println("Before removing last node: $list")
    val removedValue = list.removeLast()
    println("After removing last node: $list")
    println("Removed value: $removedValue")
  }

  "removing a node after a particular node" example {
    val list = LinkedList<Int>()
    list.push(3)
    list.push(2)
    list.push(1)
    println("Before removing at particular index: $list")
    val index = 2
    val node = list.nodeAt(index - 1)!!
    val removedValue = list.removeAfter(node)
    println("After removing at index $index: $list")
    println("Removed value: $removedValue")
  }

  "printing doubles" example {
    val list = LinkedList<Int>()
    list.push(3)
    list.push(2)
    list.push(1)
    println(list)
    for (item in list) {
      println("Double: ${item * 2}")
    }
  }

  "removing elements" example {
    val list: MutableCollection<Int> = LinkedList()
    list.add(3)
    list.add(2)
    list.add(1)
    println(list)
    list.remove(2)
    println(list)
  }
  "retaining elements" example {
    val list: MutableCollection<Int> = LinkedList()
    list.add(3)
    list.add(2)
    list.add(1)
    list.add(4)
    list.add(5)
    println(list)
    list.retainAll(listOf(3, 5, 4))
    println(list)
  }
  "remove all elements" example {
    val list: MutableCollection<Int> = LinkedList()
    list.add(3)
    list.add(2)
    list.add(1)
    list.add(4)
    list.add(5)
    println(list)
    list.removeAll(listOf(3, 4, 5))
    println(list)
  }

  "print in reverse" example {
    val list = LinkedList<Int>()
    list.add(3)
    list.add(2)
    list.add(1)
    list.add(4)
    list.add(5)

    println(list)
    list.printInReverse()
  }

  "print middle using fast low pointer" example {
    val list = LinkedList<Int>()
    list.add(3)
    list.add(2)
    list.add(1)
    list.add(4)
    list.add(5)
    println(list)
    println(list.getMiddleSlowFast()?.value)
  }

  "print middle using size" example {
    val list = LinkedList<Int>()
    list.add(3)
    list.add(2)
    list.add(1)
    list.add(4)
    list.add(5)
    println(list)
    println(list.getMiddleSlowFast()?.value)
  }

  "reversed new list" example {
    val list = LinkedList<Int>()
    list.add(3)
    list.add(2)
    list.add(1)
    list.add(4)
    list.add(5)

    println("Original: $list")
    println("Reversed: ${list.reversed()}")
  }

  "reverse list" example {
    val list = LinkedList<Int>()
    list.add(3)
    list.add(2)
    list.add(1)
    list.add(4)
    list.add(5)
    println("Original: $list")
    list.reverse()
    println("Reversed: $list")
  }

  "merge lists" example {
    val list = LinkedList<Int>()
    list.add(1)
    list.add(2)
    list.add(3)
    list.add(4)
    list.add(5)

    val other = LinkedList<Int>()
    other.add(-1)
    other.add(0)
    other.add(2)
    other.add(2)
    other.add(7)

    println("Left: $list")
    println("Right: $other")
    println("Merged: ${list.mergeSorted(other)}")
  }
}
