package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun countRightPosition(secret: String, guess: String): Int {
    val secretList = secret.toMutableList()
    val guessList = guess.toMutableList()

    var rightPosition = 0

    for (i in 0..guessList.size - 1) {
        if (guessList[i] == secretList[i]) rightPosition++
    }

    return rightPosition
}

fun countWrongPositionTest(secret: String, guess: String): Int {
    val secretList = secret.toMutableList()
    val guessList = guess.toMutableList()
    var guessAux = ""
    var secretAux = ""


    var count = 0

    var wrongPosition = 0

    while (count < secretList.size) {
        if (guessList[count] != secretList[count]) {
            guessAux += guessList[count]
            secretAux += secretList[count]
        }
        count++
    }

    count = 0

    val guessAuxList = guessAux.toMutableList()
    val secretAuxList = secretAux.toMutableList()

    while (count < guessAuxList.size) {
        val item = guessAuxList[count];
        if (secretAuxList.contains(item)) {
            wrongPosition++
            val index = secretAuxList.indexOf(item)
            if (index != count) secretAuxList.removeAt(index)
        }
        count++
    }

    return wrongPosition
}

fun evaluateGuess(secret: String, guess: String): Evaluation {

    val rightPosition = countRightPosition(secret, guess)

    val wrongPosition = countWrongPositionTest(secret, guess)

    return Evaluation(rightPosition, wrongPosition)
}




