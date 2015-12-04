package scaltris

import scala.swing.Action
import scala.swing.Dimension
import scala.swing.MainFrame
import scala.swing.Menu
import scala.swing.MenuBar
import scala.swing.MenuItem
import scala.swing.Separator
import scala.swing.SimpleSwingApplication

object Scaltris extends SimpleSwingApplication {
  val boardPanel = new BoardPanel

  def top = new MainFrame {
    title = "Scaltris"

    preferredSize = new Dimension(Block.BlockSize * Board.Width,
                                  Block.BlockSize * Board.Height + 20)

    contents = boardPanel

    menuBar = new MenuBar {
      contents += new Menu("Game") {
        contents += new MenuItem(Action("New game") { boardPanel.controller.newGame })
        contents += new MenuItem(Action("Pause") { boardPanel.controller.togglePause })
        contents += new Separator
        contents += new MenuItem(Action("Exit") { sys.exit(0) })
      }
    }

    boardPanel.requestFocus
  }
}
