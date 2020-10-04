import java.util.*

fun main() {
    val l = readLine()!!.toInt()
    val stack = Stack<Long>()
    var x: Long = 0
    var flag = false
    for (i in 0 until l) {
        val command = readLine()!!.split(' ')
        if (command[0] == "end") {
            stack.pop()
        }
        if (command[0] == "for") {
            stack.push(command[1].toLong())
        }
        if (command[0] == "add") {
            var howMuchToAdd: Long = 1
            for (j in 0 until stack.size) {
                howMuchToAdd *= stack[j]
            }
            if (x + howMuchToAdd <= Int.MAX_VALUE) {
                x += howMuchToAdd
            } else {
                flag = true
                break
            }
        }
    }
    if (!flag) {
        println(x)
    } else {
        println("OVERFLOW!!!")
    }
}