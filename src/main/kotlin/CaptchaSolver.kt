package main.kotlin

class CaptchaSolver {

    data class CalculationWindow(val previousChar: String, val accumulatedComputation: Int)

    fun solve(puzzleInput: List<String>): Number {
        if (puzzleInput.size <= 1) {
            return 0;
        }
        val amendedPuzzleInput = puzzleInput + listOf<String>(puzzleInput.first());

        return amendedPuzzleInput.fold(
                CalculationWindow("", 0),
                { calculationWindow, currentChar: String ->
                    updateCalculationWindow(calculationWindow, currentChar)
                }).accumulatedComputation;
    }

    private fun updateCalculationWindow(calculationWindow: CalculationWindow, currentChar: String): CalculationWindow {
        val updatedAccumulatedComputation: Int = if (calculationWindow.previousChar == currentChar) {
            calculationWindow.accumulatedComputation + currentChar.toInt()
        } else {
            calculationWindow.accumulatedComputation
        }

        return CalculationWindow(currentChar, updatedAccumulatedComputation)
    }
}