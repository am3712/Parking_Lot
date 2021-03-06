import kotlin.math.abs

fun main(args: Array<String>) {
    when (readLine()!!) {
        "old" -> cost(old = readLine()!!.toInt())
        "passed" -> cost(passed = readLine()!!.toInt())
        "speed" -> cost(speed = readLine()!!.toInt())
        "auto" -> cost(auto = readLine()!! == "1")
    }
}

fun cost(old: Int = 5, passed: Int = 100_000, speed: Int = 120, auto: Boolean = false) {
    var price = 20_000

    // years
    price -= 2000 * old

    // speed
    val diff = abs((speed - 120) * 100)
    price = if (speed >= 120) price + diff else price - diff

    // kilometers
    price -= passed / 10_000 * 200

    // automatic transmission
    if (auto) {
        price += 1500
    }

    println(price)
}