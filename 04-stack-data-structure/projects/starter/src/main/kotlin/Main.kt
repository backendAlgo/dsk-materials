import challenge.printInReverse
import linkedlist.LinkedList
import stack.StackImpl
import stack.stackOf

fun main() {
  "initializing a stack from a list" example {
    val list = listOf(1, 2, 3, 4, 5)
    val stack = StackImpl.create(list)
    println(stack)
  }

  "initializing a stack from an array literal" example {
    val stack = stackOf(1, 2, 3, 4, 5)
    print(stack)
    println("Popped: ${stack.pop()}")
  }

  "print nodes in reverse" example  {
    val linkedList = LinkedList<Int>()
    linkedList.append(1)
    linkedList.append(2)
    linkedList.append(3)
    linkedList.append(4)
    linkedList.append(5)
    println("linkedlist: ${linkedList}")
    linkedList.printInReverse()
  }
}
