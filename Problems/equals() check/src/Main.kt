data class Client(val name: String, val age: Int, val balance: Int) {
    override fun equals(other: Any?): Boolean {
        return other is Client && name == other.name && age == other.age
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + age
        return result
    }
}

fun main() {
    val p1 = Client(readLine()!!, readLine()!!.toInt(), readLine()!!.toInt())
    val p2 = Client(readLine()!!, readLine()!!.toInt(), readLine()!!.toInt())
    println(p1 == p2)
}