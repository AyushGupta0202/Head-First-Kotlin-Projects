fun main() {
    val options = arrayOf("Rock", "Paper", "Scissors")
    val gameChoice = getGameChoice(options)
    val userChoice = getUserChoice(options)

    printResult(userChoice, gameChoice)

}


fun printResult(userChoice: String, gameChoice: String) {

    val result : String = if (userChoice == gameChoice) "Tie!"
    else if ((userChoice == "Rock" && gameChoice == "Scissors") || (userChoice == "Paper" && gameChoice == "Rock") || (userChoice == "Scissors" && gameChoice == "Paper"))
        "You Win!"
    else "You Lose"
    println("You chose $userChoice. I chose $gameChoice. $result")
}

fun getUserChoice(options: Array<String>): String {
    var userChoice = ""
    var isValidChoice = false

    while(!isValidChoice) {
        print("Please Enter one of the following choices:")
        for (item in options) print(" $item")
        println(".")
        val userInput = readLine()

        if (userInput != null && userInput.capitalize() in options) {
            isValidChoice = true
            userChoice = userInput.capitalize()
        }

        if (!isValidChoice) println("You must enter a valid choice.")
    }

    return userChoice
}

fun getGameChoice(options: Array<String>) = options[(Math.random() * options.size).toInt()]
