import java.util.*

class SetOfStacks<T>(private val defaultCapacity: Int) {
    private var stacks = Stack<Stack<T>>()
    init {
        createStack()
    }

    fun push(value: T){
        if (stacks.peek().size < defaultCapacity){
            stacks.peek().push(value)
        } else {
            createStack()
            stacks.peek().push(value)
        }
    }

    fun pop(): T {
        val value = stacks.peek().pop()
        if (stacks.peek().isEmpty()){
            stacks.pop()
        }
        return value
    }

    fun popAt(number: Int): T {
        val value = stacks[number].pop()
        if (stacks.peek().isEmpty()){
            stacks.pop()
        }
        return value
    }

    fun isEmpty(): Boolean {
        return stacks.isEmpty()
    }

    private fun createStack(){
        val stack = Stack<T>()
        stacks.push(stack)
    }

    override fun toString(): String {
        return "SetOfStacks(stacks=$stacks)"
    }
}