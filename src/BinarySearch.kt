import kotlin.random.Random

fun <T> binarySearch(element: T, elements: List<T>, comparator: (T, T) -> Int): Int {
    var start = 0
    var end = elements.size - 1

    while (start <= end) {
        val middleIndex = (start + end) / 2
        val middle = elements[middleIndex]

        val result = comparator(element, middle)

        if (result < 0)
            end = middleIndex - 1
        else if (result > 0)
            start = middleIndex + 1
        else
            return middleIndex
    }

    return -1
}

fun main() {
    val element = Random(System.currentTimeMillis()).nextInt(1, 21)
    val elements = listOf(1,2,3,4,5,6,7,8,9,10)

    val index = binarySearch(element, elements){a, b ->
        if(a < b) -1 else if(a > b) 1 else 0
    }

    print("element: $element, index: ${index ?: "not found"}")
}