package ringbuffer

import base.Queue


class RingBufferQueue<T : Any>(size: Int) : Queue<T> {
  private val ringBuffer = RingBuffer<T>(size)
  override val count: Int
    get() = ringBuffer.count

  override fun dequeue(): T? {
    return if (isEmpty) null else ringBuffer.read()
  }

  override fun peek(): T? {
    return ringBuffer.first
  }

  override fun enqueue(element: T): Boolean {
    return ringBuffer.write(element)
  }

  override fun toString(): String {
    return ringBuffer.toString()
  }
}