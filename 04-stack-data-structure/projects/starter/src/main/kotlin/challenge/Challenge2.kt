package challenge

import stack.StackImpl

fun String.checkParentheses(): Boolean {
  val stack = StackImpl<Char>()
  for (c in this) {
    when (c) {
      '(', '{', '[' -> stack.push(c)
      ')' -> if (stack.peek() == '(') {
        return false
      } else {
        stack.pop()
      }

      '}' -> if (stack.peek() == '{') {
        return false
      } else {
        stack.pop()
      }
    }
  }
  return true
}