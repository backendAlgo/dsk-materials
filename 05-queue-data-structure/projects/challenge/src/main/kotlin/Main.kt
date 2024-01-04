/*
 * Copyright (c) 2021 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

import challenge.nextPlayer
import challenge.reverse
import doublestack.StackQueue
import linkedlist.LinkedListQueue
import array.ArrayListQueue
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

  "Boardgame manager with Queue" example {
    val queue = ArrayListQueue<String>().apply {
      enqueue("Vincent")
      enqueue("Remel")
      enqueue("Lukiih")
      enqueue("Allison")
    }
    println(queue)

    println("===== boardgame =======")
    queue.nextPlayer()
    println(queue)
    queue.nextPlayer()
    println(queue)
    queue.nextPlayer()
    println(queue)
    queue.nextPlayer()
    println(queue)
  }

  "Reverse queue" example {
    val queue = ArrayListQueue<String>().apply {
      enqueue("1")
      enqueue("21")
      enqueue("18")
      enqueue("42")
    }
    println("before: $queue")
    queue.reverse()
    println("after: $queue")
  }
}
