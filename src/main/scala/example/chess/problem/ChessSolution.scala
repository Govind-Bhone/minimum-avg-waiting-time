package example.chess.problem

import java.util.concurrent.TimeUnit
import example.chess.problem.ChessBoard._
import scala.annotation.tailrec
import scala.concurrent.duration.Duration

/**
  * Created by govind.bhone on 1/24/2017.
  */

object ChessSolution {

  def solveChessProblem(chess: ChessBoard, pieces: List[PieceInfo]): List[ChessBoard] = {

    @tailrec
    def placePossiblePiece(chess: ChessBoard, piece: Piece, acc: List[(ChessBoard, Square)], squares: List[Square]): List[(ChessBoard, Square)] = {
      squares match {
        case Nil => acc
        case head :: tail => placePossiblePiece(chess, piece,
          (chess.addPiece(piece, head), head) :: acc, tail)
      }
    }

    def placePossiblePiecesOfSameKind(chess: ChessBoard, piece: Piece, count: Int) = {
      @tailrec
      def loop(count: Int, acc: List[(ChessBoard, Square)]): List[ChessBoard] = {
        count match {
          case 0 => acc.map(_._1)
          case i if i > 0 => loop(i - 1,
            acc.foldLeft(List[(ChessBoard, Square)]()) {
              case (list, (chess, square)) =>
                placePossiblePiece(chess, piece, list, chess.availableSquaresAfterfromSquareList(piece, square))
            })
        }
      }
      loop(count - 1,
        placePossiblePiece(chess, piece, List(), chess.availableSquaresFor(piece)))
    }

    pieces.tail.foldLeft(placePossiblePiecesOfSameKind(chess, pieces.head.piece, pieces.head.count)) { (l, r) =>
      l.flatMap(placePossiblePiecesOfSameKind(_, r.piece, r.count))
    }
  }

  def main(args: Array[String]): Unit = {
    println("*********************[7×7 board ,2 Kings, 2 Queens, 2 Bishops and 1 Knight problem]***************")
    val start = System.currentTimeMillis()
    val solution = solveChessProblem(ChessBoard(7, 7), List(PieceInfo(King, 2), PieceInfo(Queen, 2), PieceInfo(Bishop, 2), PieceInfo(Knight, 1)))
    val end = System.currentTimeMillis()
    val elapsed = Duration.create(end - start, TimeUnit.MILLISECONDS)
    println("Completed the execution successfully")
    println(f"Required time to execute ${elapsed.toMinutes} min, ${elapsed.toSeconds % 60} sec, ${elapsed.toMillis % 1000} millis (total ${elapsed.toMillis} millis)")
    println(f"Total ${solution.size} solutions. No more 5 of them follow:")
    solution.take(5).map(println)
  }

}
