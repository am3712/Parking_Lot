fun main() {
    val stringBuilder = StringBuilder()
    repeat(5) { stringBuilder.append("${readLine()!!} ") }
    println(stringBuilder)
}