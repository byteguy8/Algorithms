import kotlin.random.Random

fun <T> selectionSortFind(elements: List<T>, comparator: (T, T) -> Int): Int {
    if (elements.isEmpty()) return -1

    var element = elements[0]
    var elementIndex = 0

    for (i in 1..<elements.size) {
        if (comparator(elements[i], element) < 0) {
            element = elements[i]
            elementIndex = i
        }
    }

    return elementIndex
}

fun <T> selectionSort(elements: List<T>, comparator: (T, T) -> Int): List<T> {
    val unsortedElements = elements.toMutableList()
    val sortedElements = mutableListOf<T>()

    for (i in 0..<elements.size) {
        val index = selectionSortFind(unsortedElements, comparator)
        sortedElements.add(unsortedElements.removeAt(index))
    }

    return sortedElements
}

fun sortRandomInts() {
    val random = Random(System.currentTimeMillis())
    val elements = List(random.nextInt(7, 29)) {
        random.nextInt(1, 1000)
    }

    val sorted = selectionSort(elements) { a, b ->
        if (a < b) -1 else if (a > b) 1 else 0
    }

    println("Sorted list of ${sorted.size} elements:")
    println(sorted)
}

data class ArtistReproductions(
    val name: String,
    val reproductions: Int
)

fun sortArtistsReproductions() {
    val random = Random(System.currentTimeMillis())
    val artists = listOf(
        ArtistReproductions("Coldplay", random.nextInt(0, 1000)),
        ArtistReproductions("Guns N' Roses", random.nextInt(0, 1000)),
        ArtistReproductions("Alice in Chains", random.nextInt(0, 1000)),
        ArtistReproductions("Radio Head", random.nextInt(0, 1000)),
        ArtistReproductions("Soundgarden", random.nextInt(0, 1000)),
        ArtistReproductions("Mad Season", random.nextInt(0, 1000)),
        ArtistReproductions("Buckedhead", random.nextInt(0, 1000))
    )

    val sorted = selectionSort(artists) { a, b ->
        val aReproductions = a.reproductions
        val bReproductions = b.reproductions

        if (aReproductions < bReproductions) -1
        else if (aReproductions > bReproductions) 1
        else 0
    }

    for (artist in sorted)
        println("${artist.name} - ${artist.reproductions}")
}

fun main() {
    println("Random Ints Sort:")
    sortRandomInts()

    println("\nArtists Reproductions Sort:")
    sortArtistsReproductions()
}