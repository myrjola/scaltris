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

  private val gameOverAnimation = new GameOverAnimation(this)

  private var gameRunning = true

  def tryMove(tetromino: Tetromino): Unit = {
    if (!gameRunning) return
    if (board.isLegal(tetromino)) {
      currentTetromino = tetromino
    }
    parent.repaint
  }

  def dropTetromino() {
    if (!gameRunning) return
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

    case KeyPressed(_, Key.P, _, _) => togglePause
  }

  val gameLoop = new ActionListener {
    override def actionPerformed(e: ActionEvent) {
      val newTetromino = currentTetromino.withMoveDown
      if (board.isLegal(newTetromino)) {
        currentTetromino = newTetromino

      } else {
        placeTetromino
        if (!board.isLegal(currentTetromino)) {
          gameOverAnimation.restart
          pauseGame
        }
      }
      parent.repaint
    }
  }

  def pauseGame = {
    gameRunning = false
    tetrisTick.stop
  }

  def resumeGame = {
    gameRunning = true
    tetrisTick.start
  }

  def togglePause = {
    if (gameRunning) {
      pauseGame
    } else {
      resumeGame
    }
  }

  def repaint = parent.repaint

  val tetrisTick: Timer = new Timer(250, gameLoop)

  tetrisTick.start
}
