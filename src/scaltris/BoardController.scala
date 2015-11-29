package scaltris

import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.Timer
import scala.swing.Reactor
import scala.swing.event.Key
import scala.swing.event.KeyPressed

class BoardController(val parent: BoardPanel) extends Reactor {

  var board = new Board
  var currentTetromino = new Tetromino

  def tryMove(tetromino: Tetromino) = {
    if (board.isLegal(tetromino)) {
      currentTetromino = tetromino
    }
    parent.repaint
  }

  def dropTetromino() {
    while (board.isLegal(currentTetromino.withMoveDown)) {
      currentTetromino = currentTetromino.withMoveDown
    }
    placeTetromino
  }

  def placeTetromino() {
    board = board.withTetromino(currentTetromino)
    board.clearFullRows
    currentTetromino = new Tetromino
  }

  reactions += {
    case KeyPressed(_, Key.Down, _, _) => tryMove(currentTetromino.withMoveDown)

    case KeyPressed(_, Key.Space, _, _) => dropTetromino

    case KeyPressed(_, Key.Left, _, _) => tryMove(currentTetromino.withMoveLeft)

    case KeyPressed(_, Key.Right, _, _) => tryMove(currentTetromino.withMoveRight)

    case KeyPressed(_, Key.Up, _, _) => tryMove(currentTetromino.withRotation)
  }

  new Timer(250, new ActionListener {
              override def actionPerformed(e: ActionEvent) {
                val newTetromino = currentTetromino.withMoveDown
                if (board.isLegal(newTetromino)) {
                  currentTetromino = newTetromino

                } else {
                  placeTetromino
                  if (!board.isLegal(currentTetromino)) {
                    // Game over
                    board.board.reverse.foreach {
                      row => row.indices.foreach {
                        i => row(i) = Block.nextBlock
                      }
                      parent.repaint
                      Thread.sleep(50)
                    }
                  }
                }
                parent.repaint
              }
            }).start
}
