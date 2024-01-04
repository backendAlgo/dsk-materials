import array.ArrayListQueue
import doublestack.StackQueue
import linkedlist.LinkedListQueue
import ringbuffer.RingBufferQueue

fun main() {
  "Queue with ArrayList" example {
    val queue = ArrayListQueue<String>().apply {
      enqueue("Ray")
      enqueue("Brian")
      enqueue("Eric")
    }
    println(queue)
    queue.dequeue()
    println(queue)
    println("Next up: ${queue.peek()}")
  }
  "Queue with Doubly Linked List" example {
    val queue = LinkedListQueue<String>().apply {
      enqueue("Ray")
      enqueue("Brian")
      enqueue("Eric")
    }
    println(queue)
    queue.dequeue()
    println(queue)
    println("Next up: ${queue.peek()}")
  }
  "Queue with Ring Buffer" example {
    val queue = RingBufferQueue<String>(10).apply {
      enqueue("Ray")
      enqueue("Brian")
      enqueue("Eric")
    }
    println(queue)
    queue.dequeue()
    println(queue)
    println("Next up: ${queue.peek()}")
  }
  "Queue with Double Stack" example {
    val queue = StackQueue<String>().apply {
      enqueue("Ray")
      enqueue("Brian")
      enqueue("Eric")
    }
    println(queue)
    queue.dequeue()
    println(queue)
    println("Next up: ${queue.peek()}")
  }
}

