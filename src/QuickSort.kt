fun <T> quickSort(elements: List<T>, comparator: (T, T) -> Int): List<T> {
    if (elements.size <= 1)
        return elements

    val pivotIndex = 0
    val pivot = elements[pivotIndex]

    val less = elements.filterIndexed { index, t ->
        comparator(t, pivot) <= 0 && index != pivotIndex
    }
    
    val greater = elements.filter {
        comparator(it, pivot) > 0
    }

    return quickSort(less, comparator) + pivot + quickSort(greater, comparator)
}

fun main() {
    val elements = listOf(9,7,13,1,25,11)
    val sortedElements = quickSort(elements){a, b ->
        if(a < b) 0 else if(a > b) 1 else 0
    }

    println(sortedElements)
}