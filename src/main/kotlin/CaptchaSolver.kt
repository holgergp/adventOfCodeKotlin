package main.kotlin
class CaptchaSolver {

    data class CalculationWindow(val currentChar: String, val accumulatedComputation: Int)

    fun solve(puzzleInput: List<String>): Number {
        if (puzzleInput.size <= 1) {
            return 0;
        }
        val amendedPuzzleInput = puzzleInput + listOf<String>(puzzleInput.first());

        return amendedPuzzleInput.fold(
                CalculationWindow("", 0),
                { calculationWindow, current: String ->
                    CalculationWindow(current, conditionalCalculate(calculationWindow, current))
                }).accumulatedComputation;
    }

    private fun conditionalCalculate(calculationWindow: CalculationWindow, current: String): Int {
        var newAcc: Int = calculationWindow.accumulatedComputation;
        if (calculationWindow.currentChar == current) {
            newAcc += current.toInt();
        }
        return newAcc;
    }
}