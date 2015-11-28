package scaltris

import scala.swing.Reactor
import scala.swing.event.Key
import scala.swing.event.KeyPressed

class BoardController extends Reactor {
  reactions += {
    case KeyPressed(_, Key.Down, _, _) => ???

    case KeyPressed(_, Key.Space, _, _) => ???

    case KeyPressed(_, Key.Left, _, _) => ???

    case KeyPressed(_, Key.Right, _, _) => ???

    case KeyPressed(_, Key.Up, _, _) => ???
  }
}
