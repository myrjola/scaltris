package scaltris

import java.awt.Color
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.awt.image.RescaleOp
import javax.swing.Timer
import scala.swing.Graphics2D
import scala.swing.Panel

class BoardPanel extends Panel {
  val controller = new BoardController(this)
  controller.listenTo(this.keys)

  override def paintComponent(g: Graphics2D) {
    super.paintComponent(g)

    // Clear board to black
    g.setPaint(Color.black)
    g.fillRect(0, 0, Board.Width * Block.BlockSize, Board.Height * Block.BlockSize)

    // Draw ghost tetromino
    val darkenOperation = new RescaleOp(0.5f, 0.0f, null);
    val ghostTetromino = controller.droppedTetromino
    ghostTetromino.getBlockPositions.foreach {
      case(x, y) =>
        val img = Block.getBlockImage(ghostTetromino.block)
        g.drawImage(img, darkenOperation, x * Block.BlockSize, y * Block.BlockSize)
    }

    // Draw board with current tetromino
    controller.board.withTetromino(controller.currentTetromino).board.zipWithIndex.foreach{
      case(row, y) => row.zipWithIndex.foreach {
        case(block, x) =>
          if (block != Block.EMPTY) {
            val img = Block.getBlockImage(block)
            g.drawImage(img, null, x * Block.BlockSize, y * Block.BlockSize)
          }
      }
    }
  }
}
