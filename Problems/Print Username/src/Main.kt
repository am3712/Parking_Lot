fun main() {
    val user = readLine()!!
    if (user != "HIDDEN")
        greeting(user)
    else
        greeting()
}

fun greeting(userName: String = "secret user") {
    println("Hello, $userName!")
}
