data class BinaryNode<T>(var data: T, var leftChild: BinaryNode<T>? = null, var rightChild: BinaryNode<T>? = null,
                         var depth: Int = -1)