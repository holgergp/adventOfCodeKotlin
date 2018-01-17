package main.kotlin

class Puzzle(val puzzleInput: String) {
    val puzzleInputDigits: List<Int> = puzzleInput.map({ c -> c.toString().toInt() })
    val empty = puzzleInputDigits.size <= 1
}
