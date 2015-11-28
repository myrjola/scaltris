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
    print("moving")
    if (board.isLegal(tetromino)) {
      currentTetromino = tetromino
    }
    parent.repaint
  }

  reactions += {
    case KeyPressed(_, Key.Down, _, _) => tryMove(currentTetromino.withMoveDown)

    case KeyPressed(_, Key.Space, _, _) => ???

    case KeyPressed(_, Key.Left, _, _) => tryMove(currentTetromino.withMoveLeft)

    case KeyPressed(_, Key.Right, _, _) => tryMove(currentTetromino.withMoveRight)

    case KeyPressed(_, Key.Up, _, _) => tryMove(currentTetromino.withRotation)
  }

  new Timer(250, new ActionListener {
              override def actionPerformed(e: ActionEvent) {
                println("timer")
                val newTetromino = currentTetromino.withMoveDown
                if (board.isLegal(newTetromino)) {
                  currentTetromino = newTetromino

                } else {
                  board = board.withTetromino(currentTetromino)
                  board.clearFullRows
                  currentTetromino = new Tetromino
                }
                parent.repaint
              }
            }).start
}
