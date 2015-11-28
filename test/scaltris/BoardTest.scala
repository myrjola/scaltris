package scaltris

import org.scalatest._

class BoardTest extends FlatSpec with Matchers {
  def fixture =
    new {
      val board = new Board
    }

  it should "start with an empty board" in {

    fixture.board.board.forall(_.forall(_.equals(Block.EMPTY)))
  }

  it should "place a tetromino" in {
    val l = new Tetromino(Block.L)
    fixture.board.withTetromino(l).board should be (
      Array(
        Array(Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.L,
              Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY),
        Array(Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.L,
              Block.L, Block.L, Block.EMPTY, Block.EMPTY, Block.EMPTY)) ++
        Array.fill[Array[Block.Value]](Board.Height-2)(Board.EmptyBoardRow)
    )
  }

  it should "clear full rows in board" in {
    val board = new Board(
      Array(
        Array(Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.L,
              Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY),
        Array(Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.L,
              Block.L, Block.L, Block.EMPTY, Block.EMPTY, Block.EMPTY),
        Array.fill[Block.Value](Board.Width)(Block.L),
        Board.EmptyBoardRow,
        Array.fill[Block.Value](Board.Width)(Block.O)) ++
        Array.fill[Array[Block.Value]](Board.Height-5)(Board.EmptyBoardRow))

    board.clearFullRows should be (2)

    board.board should be (
      Array.fill[Array[Block.Value]](2)(Board.EmptyBoardRow) ++
      Array(
        Array(Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.L,
              Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY),
        Array(Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.L,
              Block.L, Block.L, Block.EMPTY, Block.EMPTY, Block.EMPTY)) ++
        Array.fill[Array[Block.Value]](Board.Height-4)(Board.EmptyBoardRow)
    )
  }
}
