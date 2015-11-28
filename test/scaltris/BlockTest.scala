package scaltris

import org.scalatest._
import scaltris._

/**
  * Run this spec to test that your Scaltris class works properly.
  *
  * @author mmyrjola
  */
class BlockTest extends FlatSpec with Matchers {
  it should "have square images" in {
    val tBlock = Block.T
    val tImg = Block.getBlockImage(tBlock)
    tImg.getHeight should be (tImg.getWidth)
  }
}
