package example.chess.problem

import example.chess.problem.ChessBoard.{Square, Board}
import org.junit.Test

/**
  * Created by govind.bhone on 1/27/2017.
  */
class ChessBoardTest {

  @Test
  def movePiecesOnBoard(): Unit = {
    val board = Board(1, 1)
    val square = Square(1, 1)
    assert(King.filterCriteria(square, board.x, board.y) == true)
    assert(Queen.filterCriteria(square, board.x, board.y) == true)
    assert(Knight.filterCriteria(square, board.x, board.y) == false)
    assert(Rook.filterCriteria(square, board.x, board.y) == true)
    assert(Bishop.filterCriteria(square, board.x, board.y) == true)

  }

  @Test
  def checkVulnerabilityofPieces(): Unit = {
    var board = Board(1, 1)
    val square = Square(1, 1)
    assert(!King.isVulnerable(square, board, List(square)) == true)
    board = Board(2, 2)
    val square1 = Square(1, 1)
    val square2 = Square(2, 2)
    assert(King.isVulnerable(square1, board, List(square2)) == true)
    assert(King.isVulnerable(square1, ChessBoard(board)
      .addPiece(King, square1)
      .addPiece(King, square2).board, List(square1)) == false)
  }

  @Test
  def dumpingOutputMatch(): Unit = {
    val board = Board(8, 8)
    val center = Square(5, 4)
    val corner = Square(1, 1)
    val wall = Square(5, 8)

    assert(ChessBoard(board)
      .addPiece(King, center)
      .addPiece(King, corner)
      .addPiece(King, wall).toString ==
      "King*------\n" +
        "**------\n" +
        "---***--\n" +
        "---*King*--\n" +
        "---***--\n" +
        "--------\n" +
        "---***--\n" +
        "---*King*--\n"
    )
  }

}
