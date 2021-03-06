package parking

lateinit var input: List<String>
lateinit var spots: Array<ParkingLot?>
var count = 1

fun main() {
    var read = readLine()!!
    while (read != "exit") {
        input = read.split(" ")
        when (input[0]) {
            "create" -> {
                spots = arrayOfNulls(input[1].toInt() + 1)
                println("Created a parking lot with ${input[1].toInt()} spots.")
            }
            "park" -> catchNullSpots(::park)
            "leave" -> catchNullSpots(::leave)
            "status" -> catchNullSpots(::getStatus)
            "reg_by_color" -> catchNullSpots(::regByColor)
            "spot_by_color" -> catchNullSpots(::spotByColor)
            "spot_by_reg" -> catchNullSpots(::spotByReg)
        }
        read = readLine()!!
    }
}

fun catchNullSpots(function: () -> Unit) {
    if (::spots.isInitialized) {
        function()
    } else {
        println("Sorry, a parking lot has not been created.")
    }
}

fun getStatus() {
    if (count != 1) {
        spots.forEachIndexed { index: Int, parkingLot: ParkingLot? ->
            if (parkingLot != null) {
                println("${index + 1} $parkingLot")
            }
        }
    } else {
        println("Parking lot is empty.")
    }
}

fun leave() {
    val spotIndex = input[1].toInt()
    if (spots[spotIndex] == null) {
        println("There is no car in spot $spotIndex.")
    } else {
        println("Spot $spotIndex is free.")
        spots[spotIndex] = null
        count--
    }
}

fun park() {
    if (count != spots.size) {
        println("${input[2]} car parked in spot ${count}.")
        spots[count] = ParkingLot(input[1], input[2].toUpperCase())
        count++
    } else {
        println("Sorry, the parking lot is full.")
    }
}

fun regByColor() {
    val answer = spots.filter { input[1].toUpperCase() == it?.color }
    if (answer.isNotEmpty())
        answer.forEachIndexed { index, parkingLot ->
            print(if (index == answer.lastIndex) "${parkingLot?.regNumber}\n" else "${parkingLot?.regNumber}, ")
        }
    else {
        println("No cars with color ${input[1]} were found.")
    }
}

fun spotByColor() {
    val answer = spots.filter { input[1].toUpperCase() == it?.color }
    if (answer.isNotEmpty())
        answer.forEachIndexed { index: Int, parkingLot ->
            val spotIndex = spots.indexOf(parkingLot)
            print(if (index == answer.lastIndex) "$spotIndex\n" else "$spotIndex, ")
        }
    else {
        println("No cars with color ${input[1]} were found.")
    }
}

fun spotByReg() {
    val answer = spots.filter { input[1] == it?.regNumber }
    if (answer.isNotEmpty())
        answer.forEachIndexed { index: Int, parkingLot ->
            val spotIndex = spots.indexOf(parkingLot)
            print(if (index == answer.lastIndex) "$spotIndex\n" else "$spotIndex, ")
        }
    else {
        println("No cars with registration number ${input[1]} were found.")
    }
}

data class ParkingLot(val regNumber: String, val color: String) {
    override fun toString(): String {
        return "$regNumber $color"
    }
}