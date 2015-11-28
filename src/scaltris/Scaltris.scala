package scaltris

import scala.swing.Dimension
import scala.swing.MainFrame
import scala.swing.SimpleSwingApplication

object Scaltris extends SimpleSwingApplication {
  val boardPanel = new BoardPanel

  def top = new MainFrame {
    title = "Scaltris"

    preferredSize = new Dimension(Block.BlockSize * Board.Width,
                                  Block.BlockSize * Board.Height)

    contents = boardPanel
  }
}
