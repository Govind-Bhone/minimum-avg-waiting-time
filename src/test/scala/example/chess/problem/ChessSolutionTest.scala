package example.chess.problem

import org.junit.Test

/**
  * Created by govind.bhone on 1/27/2017.
  */
class ChessSolutionTest {

  @Test
  def check3By3BoardContaining2King1Queen(): Unit = {
    val solution = ChessSolution.solveChessProblem(ChessBoard(3, 3), List(PieceInfo(King, 2), PieceInfo(Queen, 1)))
    println(solution.mkString("\n"))
    assert(solution.size == 4)
    assert(solution.mkString("\n") ==
      "*Queen*\n" +
        "***\n" +
        "King*King\n" +
        "\n" +
        "**King\n" +
        "Queen**\n" +
        "**King\n" +
        "\n" +
        "King**\n" +
        "**Queen\n" +
        "King**\n" +
        "\n" +
        "King*King\n" +
        "***\n" +
        "*Queen*\n")
  }


  @Test
  def check4by4BoardContaining2RooksAnd4Knight(): Unit = {
    val solution = ChessSolution.solveChessProblem(ChessBoard(4, 4), List(PieceInfo(Rook, 2), PieceInfo(Knight, 4)))
    assert(solution.size == 8)
    assert(solution.mkString("\n") == "Knight*Knight*\n" +
      "***Rook\n" +
      "Knight*Knight*\n" +
      "*Rook**\n" +
      "\n" +
      "*Knight*Knight\n" +
      "**Rook*\n" +
      "*Knight*Knight\n" +
      "Rook***\n" +
      "\n" +
      "Knight*Knight*\n" +
      "*Rook**\n" +
      "Knight*Knight*\n" +
      "***Rook\n" +
      "\n" +
      "*Knight*Knight\n" +
      "Rook***\n" +
      "*Knight*Knight\n" +
      "**Rook*\n" +
      "\n" +
      "***Rook\n" +
      "Knight*Knight*\n" +
      "*Rook**\n" +
      "Knight*Knight*\n" +
      "\n" +
      "**Rook*\n" +
      "*Knight*Knight\n" +
      "Rook***\n" +
      "*Knight*Knight\n" +
      "\n" +
      "*Rook**\n" +
      "Knight*Knight*\n" +
      "***Rook\n" +
      "Knight*Knight*\n" +
      "\n" +
      "Rook***\n" +
      "*Knight*Knight\n" +
      "**Rook*\n" +
      "*Knight*Knight\n")
  }
}
