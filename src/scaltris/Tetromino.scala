package scaltris

class Tetromino(val block: Block.Value) {
  private var position = (Board.Width / 2, 1)
  private var orientation = 0

  def getBlockPositions: Array[(Int, Int)] = {
    Block.getPositions(block)(orientation).map {
      blockPosition => (blockPosition._1 + position._1, blockPosition._2 + position._2)
    }
  }

}
