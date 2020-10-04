import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val set = setOf<Int>()
    println(subsetsOfSet(set))
}

/**
 * removes all spaces with %20
 * require CharArray with enough space
 * n - size of String without spaces in the end
 */
fun URLify(a: CharArray, n: Int): CharArray {
    val pos: ArrayList<Int> = ArrayList()
    for (i in 0 until n) {
        if (a[i] == ' ') {
            pos.add(i)
        }
    }
    pos.add(n)
    for (i in pos.size - 1 downTo 1) {
        for (j in pos[i] - 1 downTo pos[i - 1]) {
            a[j + i * 2] = a[j]
        }
    }
    for (i in 0 until pos.size - 1) {
        a[pos[i] + i * 2] = '%'
        a[pos[i] + i * 2 + 1] = '2'
        a[pos[i] + i * 2 + 2] = '0'
    }
    return a
}

/**
 * checks whether String is a permutation of a palindrome
 */
fun isPalindromePermutation(a: String): Boolean {
    val letters = Array(26, { 0 })
    val chars = a.toLowerCase().filter { it in 'a'..'z' }.toCharArray()
    for (i in 0 until chars.size) {
        val c = chars[i] - 'a'
        letters[c]++
    }
    val f = letters.count { it % 2 != 0 }
    return if (f <= 1) true else false
}

/**
 * checks whether strings are different only by one char
 * char can be placed, removed or changed
 */
fun oneAway(a: String, b: String): Boolean {
    val n = a.length
    val m = b.length

    if (n - m !in -1..1) {
        return false
    }

    var flag = false
    var j = 0
    var i = 0
    while (i < n && j < m) {
        if (a[i] != b[j]) {
            if (flag == true) {
                return false
            }
            flag = true
            if (n > m) {
                i++
                continue
            } else if (m > n) {
                j++
                continue
            }
        }
        j++
        i++
    }

    return true
}

/**
 * removes duplicates from the list
 */
fun <T> removeDups(list: SinglyLinkedList<T>): SinglyLinkedList<T> {
    val elements = mutableSetOf<T>()
    for (element in list) {
        if (element in elements) {
            list.remove(element)
        } else {
            elements.add(element)
        }
    }
    return list
}

/**
 * puts all elements less than k before elements more than k
 */
fun <T : Comparable<T>> partition(head: Node<T>?, k: T): Node<T>? {
    var n: Node<T>? = head ?: return null

    var less: Node<T>? = null
    var more: Node<T>? = null
    var moreFirst: Node<T>? = null
    var lessFirst: Node<T>? = null

    while (n != null) {
        if (n.data < k) {
            less?.next = n
            less = n
            if (lessFirst == null) {
                lessFirst = n
            }
        } else {
            more?.next = n
            more = n
            if (moreFirst == null) {
                moreFirst = n
            }
        }
        n = n.next
    }

    more?.next = null

    if (less != null) {
        less.next = moreFirst
        return lessFirst
    }

    return moreFirst
}

/**
 * makes BST from sorted array
 */
fun <T> createBST(a: Array<T>): BinaryNode<T> {
    val left = 0
    val right = a.size
    val mid = (right - left) / 2
    val parent = BinaryNode(a[mid])
    addLeftChild(parent, left, mid, a)
    addRightChild(parent, mid + 1, right, a)
    return parent
}

private fun <T> addLeftChild(p: BinaryNode<T>, l: Int, r: Int, a: Array<T>) {
    if (l < r) {
        val mid = (r + l) / 2
        val ch = BinaryNode(a[mid])
        p.leftChild = ch
        addLeftChild(ch, l, mid, a)
        addRightChild(ch, mid + 1, r, a)
    }
}

private fun <T> addRightChild(p: BinaryNode<T>, l: Int, r: Int, a: Array<T>) {
    if (l < r) {
        val mid = (r + l) / 2
        val ch = BinaryNode(a[mid])
        p.rightChild = ch
        addLeftChild(ch, l, mid, a)
        addRightChild(ch, mid + 1, r, a)
    }
}

fun <T> inOrderTraversal(n: BinaryNode<T>?) {
    if (n != null) {
        inOrderTraversal(n.leftChild)
        print(n.data)
        print(' ')
        inOrderTraversal(n.rightChild)
    }
}

fun <T> listOfDepths(n: BinaryNode<T>): MutableMap<Int, MutableList<BinaryNode<T>>> {
    val map = mutableMapOf<Int, MutableList<BinaryNode<T>>>()
    val queue = ArrayDeque<BinaryNode<T>>()
    n.depth = 0
    queue.add(n)
    while (queue.isNotEmpty()) {
        val cur = queue.remove()
        addVertexToRowOfDepth(map, cur)
        if (cur.leftChild?.depth == -1) {
            cur.leftChild?.depth = cur.depth + 1

            queue.add(cur.leftChild)
        }
        if (cur.rightChild?.depth == -1) {
            cur.rightChild?.depth = cur.depth + 1
            queue.add(cur.rightChild)
        }
    }
    return map
}

private fun <T> addVertexToRowOfDepth(map: MutableMap<Int, MutableList<BinaryNode<T>>>, node: BinaryNode<T>) {
    if (map.containsKey(node.depth)) {
        map[node.depth]?.add(node)
    } else {
        map.put(node.depth, mutableListOf(node))
    }
}

fun <T> isBalanced(node: BinaryNode<T>?): Boolean {
    return depthSearch(node) != Long.MIN_VALUE
}

fun <T> depthSearch(node: BinaryNode<T>?): Long {
    if (node == null) {
        return 0
    }
    val depthLeft = depthSearch(node.leftChild)
    if (depthLeft == Long.MIN_VALUE) return Long.MIN_VALUE

    val depthRight = depthSearch(node.rightChild)
    if (depthRight == Long.MIN_VALUE) return Long.MIN_VALUE

    val depthDif = Math.abs(depthLeft - depthRight)
    if (depthDif > 1) {
        return Long.MIN_VALUE
    } else {
        return Math.max(depthLeft, depthRight) + 1
    }
}

fun isBST(node: BinaryNode<Long>?): Boolean {
    return isBST(node, Long.MIN_VALUE, Long.MAX_VALUE)
}

fun isBST(node: BinaryNode<Long>?, leftBorder: Long, rightBorder: Long): Boolean {
    if (node == null) {
        return true
    }
    if (node.data !in leftBorder..rightBorder) {
        return false
    }
    val left = isBST(node.leftChild, leftBorder, node.data - 1)
    val right = isBST(node.rightChild, node.data, rightBorder)
    return left && right
}

fun findPath(a: Array<BooleanArray>): List<Pair<Int, Int>> {

    if (a.isEmpty() || a[0].isEmpty()) {
        return emptyList()
    }

    val b: Array<BooleanArray> = Array(a.size) { BooleanArray(a[0].size) { false } }

    for (i in 0 until a.size)
        for (j in 0 until a[0].size)
            b[i][j] = when{
                !a[i][j] -> false
                i - 1 >= 0 && j - 1 >= 0 -> b[i - 1][j] || b[i][j - 1]
                i - 1 >= 0 -> b[i - 1][j]
                j - 1 >= 0 -> b[i][j - 1]
                else -> true
            }

    val result: Stack<Pair<Int, Int>> = Stack()
    result.push(a.size - 1 to a[0].size - 1)
    loop@ while (true){
        if (result.peek() == 0 to 0){
            break
        }
        when {
            result.peek().first - 1 >= 0 && a[result.peek().first - 1][result.peek().second] -> {
                result.push(result.peek().first - 1 to result.peek().second)
            }
            result.peek().second - 1 >= 0 && a[result.peek().first][result.peek().second - 1] -> {
                result.push(result.peek().first to result.peek().second - 1)
            }
            result.peek().first == 0 && result.peek().second == 0 -> {
                result.push(result.peek().first to result.peek().second)
                break@loop
            }
            else -> return emptyList()
        }
    }
    return result.reversed()
}


fun magicIndex(a: Array<Int>): Int{
    return magicIndex(a, 0, a.size - 1)
}

fun magicIndex(a: Array<Int>, left: Int, right: Int): Int{
    val mid: Int = (right + left) / 2
    when {
        right < left -> return -1
        a[mid] < mid -> return magicIndex(a, mid + 1, right)
        a[mid] > mid -> return magicIndex(a, left, mid - 1)
    }
    return mid
}

fun <T>subsetsOfSet(set: Set<T>): List<List<T>>{
    val subsets = mutableListOf<List<T>>()
    for (item in set){
        for (i in 0 until subsets.size){
            subsets.add(subsets[i].plus(listOf(item)))
        }
        subsets.add(listOf(item))
    }
    return subsets
}