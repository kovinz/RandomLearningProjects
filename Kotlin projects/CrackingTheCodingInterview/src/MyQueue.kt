import java.util.*


class MyQueue<T> {
    var firstStack = Stack<T>()
    var secondStack = Stack<T>()

    fun add(value: T) {
        firstStack.push(value)
    }

    fun isEmpty(): Boolean {
        return firstStack.isEmpty() && secondStack.isEmpty()
    }

    fun remove(): T {
        fromFirstToSecond()
        return secondStack.pop()
    }

    fun peek(): T {
        fromFirstToSecond()
        return secondStack.peek()
    }

    private fun fromFirstToSecond() {
        if (secondStack.isEmpty()) {
            while (!firstStack.isEmpty()) {
                val value = firstStack.pop()
                secondStack.push(value)
            }
        }
    }
}