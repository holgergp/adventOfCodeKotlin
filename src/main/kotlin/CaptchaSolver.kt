package main.kotlin

class CaptchaSolver {

    class Puzzle(val puzzleInput: String) {
        val puzzleInputDigits: List<Int> = puzzleInput.map({ c -> c.toString().toInt() })
        val empty = puzzleInputDigits.size <= 1

    }

    data class CalculationWindow(val previousDigit: Int, val accumulatedComputation: Int)

    fun solve(puzzleInput: String): Number {
        val puzzle = Puzzle(puzzleInput)
        val puzzleInputDigits = puzzle.puzzleInputDigits
        if (puzzle.empty) {
            return 0;
        }
        val amendedPuzzleInput = puzzleInputDigits + listOf<Int>(puzzleInputDigits.first());

        return amendedPuzzleInput.fold(
                CalculationWindow(0, 0),
                { calculationWindow, currentDigit: Int ->
                    updateCalculationWindow(calculationWindow, currentDigit)
                }).accumulatedComputation;
    }

    private fun updateCalculationWindow(calculationWindow: CalculationWindow, currentDigit: Int): CalculationWindow {
        return CalculationWindow(currentDigit,
                if (calculationWindow.previousDigit == currentDigit) {
                    calculationWindow.accumulatedComputation + currentDigit
                } else {
                    calculationWindow.accumulatedComputation
                })
    }
}
