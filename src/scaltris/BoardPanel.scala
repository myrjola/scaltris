package scaltris

import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.Timer
import scala.swing.Graphics2D
import scala.swing.Panel

class BoardPanel extends Panel {
  val controller = new BoardController(this)
  controller.listenTo(this.keys)

  override def paintComponent(g: Graphics2D) {
    super.paintComponent(g)

    controller.board.withTetromino(controller.currentTetromino).board.zipWithIndex.foreach{
      case(row, y) => row.zipWithIndex.foreach {
        case(block, x) =>
          val img = Block.getBlockImage(block)
          g.drawImage(img, null, x * Block.BlockSize, y * Block.BlockSize)
      }
    }
  }
}
