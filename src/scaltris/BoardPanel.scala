package scaltris

import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.Timer
import scala.swing.Graphics2D
import scala.swing.Panel

class BoardPanel extends Panel {
  var board = new Board
  var currentTetromino = new Tetromino(Block.L)

  new Timer(50, new ActionListener {
              override def actionPerformed(e: ActionEvent) {
                val newTetromino = currentTetromino.withMoveDown
                println(newTetromino.getBlockPositions.mkString(", "))
                if (board.isLegal(newTetromino)) {
                  currentTetromino = newTetromino

                } else {
                  board = board.withTetromino(currentTetromino)
                  currentTetromino = new Tetromino(Block.L)
                }
                repaint()
              }
            }).start

  override def paintComponent(g: Graphics2D) {
    super.paintComponent(g)

    board.withTetromino(currentTetromino).board.zipWithIndex.foreach{
      case(row, y) => row.zipWithIndex.foreach {
        case(block, x) =>
          val img = Block.getBlockImage(block)
          g.drawImage(img, null, x * Block.BlockSize, y * Block.BlockSize)
      }
    }
  }
}
