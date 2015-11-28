package scaltris

import org.scalatest._

/**
  * Run this spec to test that your Scaltris class works properly.
  *
  * @author mmyrjola
  */
class BoardTest extends FlatSpec with Matchers {
  val board = new Board

  it should "start with an empty board" in {
    board.cloneBoard.forall(_.forall(_.equals(Block.EMPTY)))
  }

  it should "place a tetromino correctly" in {
    val l = new Tetromino(Block.L)
    board.withTetromino(l) should be (Array(
      Array(Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.L, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY),
      Array(Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.L, Block.L, Block.L, Block.EMPTY, Block.EMPTY, Block.EMPTY),
      Array(Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY),
      Array(Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY),
      Array(Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY),
      Array(Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY),
      Array(Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY),
      Array(Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY),
      Array(Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY),
      Array(Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY),
      Array(Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY),
      Array(Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY),
      Array(Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY),
      Array(Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY),
      Array(Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY),
      Array(Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY),
      Array(Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY),
      Array(Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY),
      Array(Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY),
      Array(Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY),
      Array(Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY),
      Array(Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY),
      Array(Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY),
      Array(Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY, Block.EMPTY)))
  }
}
