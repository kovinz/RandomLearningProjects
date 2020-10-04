class SinglyLinkedList<T>(): Iterable<T>{
    var head: Node? = null

    inner class Node(data_: T){
        var data = data_
        var next: Node? = null
        override fun toString(): String {
            return "Node(data=$data)"
        }

    }

    inner class SinglyLinkedListIterator(): Iterator<T> {
        var currentNode = head
        override fun hasNext(): Boolean {
            return currentNode?.next != null
        }

        override fun next(): T {
            currentNode = currentNode?.next
            return currentNode?.next!!.data
        }

    }

    override fun iterator(): Iterator<T> {
        return SinglyLinkedListIterator()
    }

    fun add(data: T){
        val end = Node(data)
        if (head == null){
            head = end
            return
        }
        var n = head
        while (n?.next != null){
            n = n.next
        }
        n?.next = end
    }

    fun remove(data: T){
        if (head?.data == data){
            head = head?.next
        }
        var n = head
        while (n?.next != null){
            if (n.next!!.data == data){
                n.next = n.next!!.next
            }
            n = n.next
        }
    }

    fun get(index: Int){
        var n = head

    }
}