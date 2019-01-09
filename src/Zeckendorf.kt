fun main(args: Array<String>) {
    args.forEach { println(zeckendorf(it.toInt())) }
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