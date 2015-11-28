package scaltris

import java.awt.image.BufferedImage
import javax.imageio.ImageIO
import java.io.File

/**
  * Block types and related information.
  */
object Block extends Enumeration {
  type Block = Value
  val T, S, Z, O, I, L, J = Value

  val BlockSize = 32
  val spriteSheet: BufferedImage = ImageIO.read(new File("data/tetblocks.png"))

  val blockSprites =  oa

  def getBlockImage(block: Block): BufferedImage = Block.apply(0)

  def getPositions(block: Block): Array[Array[Tuple2[Int, Int]]] = block match {
    case T => Array(Array((0, 0), (-1, 0), (1, 0), (0, -1)),
                    Array((0, 0), (0, 1), (0, -1), (-1, 0)),
                    Array((0, 0), (1, 0), (-1, 0), (0, 1)),
                    Array((0, 0), (0, -1), (0, 1), (1, 0)))
    case S => Array(Array((0, 0), (1, 0), (0, -1), (-1, -1)),
                    Array((0, 0), (0, 1), (1, 0), (1, -1)),
                    Array((0, 0), (1, 0), (0, -1), (-1, -1)),
                    Array((0, 0), (0, 1), (1, 0), (1, -1)))
    case Z => Array(Array((0, 0), (-1, 0), (0, -1), (1, -1)),
                    Array((0, 0), (0, 1), (-1, 0), (-1, -1)),
                    Array((0, 0), (-1, 0), (0, -1), (1, -1)),
                    Array((0, 0), (0, 1), (-1, 0), (-1, -1)))
    case O => Array(Array((0, 0), (1, 0), (0, -1), (1, -1)),
                    Array((0, 0), (1, 0), (0, -1), (1, -1)),
                    Array((0, 0), (1, 0), (0, -1), (1, -1)),
                    Array((0, 0), (1, 0), (0, -1), (1, -1)))
    case I => Array(Array((0, 0), (-1, 0), (1, 0), (2, 0)),
                    Array((0, 0), (0, -1), (0, 1), (0, 2)),
                    Array((0, 0), (-1, 0), (1, 0), (2, 0)),
                    Array((0, 0), (0, -1), (0, 1), (0, 2)))
    case L => Array(Array((0, 0), (1, 0), (-1, 0), (-1, -1)),
                    Array((0, 0), (0, -1), (0, 1), (-1, 1)),
                    Array((0, 0), (-1, 0), (1, 0), (1, 1)),
                    Array((0, 0), (0, 1), (0, -1), (1, -1)))
    case J => Array(Array((0, 0), (-1, 0), (1, 0), (1, -1)),
                    Array((0, 0), (0, 1), (0, -1), (-1, -1)),
                    Array((0, 0), (1, 0), (-1, 0), (-1, 1)),
                    Array((0, 0), (0, -1), (0, 1), (1, 1)))
  }
}
