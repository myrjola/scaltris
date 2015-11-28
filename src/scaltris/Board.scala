package scaltris

object Board {
  val Width = 10
  val Height = 24

  def emptyBoard: Array[Array[Block.Value]] = {
    val emptyBoardRow = Array.fill[Block.Value](Width)(Block.EMPTY)
    Array.fill[Array[Block.Value]](Height)(emptyBoardRow)
  }
}

class Board {
  private var board: Array[Array[Block.Value]] = Board.emptyBoard

  def withTetromino(tetromino: Tetromino): Array[Array[Block.Value]] = {
    val boardCopy = cloneBoard
    val positions = tetromino.getBlockPositions
    positions.foreach {
      position => boardCopy(position._2)(position._1) = tetromino.block
    }
    boardCopy
  }

  def cloneBoard: Array[Array[Block.Value]] = board.map(_.clone)
}
