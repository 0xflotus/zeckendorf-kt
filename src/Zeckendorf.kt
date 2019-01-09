fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("Please enter some integers")
    } else {
        try {
            args.forEach { println(zeckendorf(it.toInt())) }
        } catch (e: Exception) {
            println("You entered a non integer value")
        }
    }
}

fun zeckendorf(m: Int): String {
    var n = m
    if (n == 0) {
        return "0"
    }

    val fibs = mutableListOf(1)
    var next = 2
    while (next <= n) {
        fibs.add(next)
        next += fibs.get(fibs.size - 2)
    }

    var sb = ""
    fibs.reverse()
    fibs.forEach {
        sb += if (it <= n) "1" else "0"
        if (it <= n) {
            n -= it
        }
    }
    return sb
}