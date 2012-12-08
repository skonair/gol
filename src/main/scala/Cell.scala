case class Cell(x: Int, y: Int) 

case class Grid(cells: Set[Cell] = Set.empty) {
  
  def addCell(cell: Cell): Grid = {
    Grid(cells + cell)
  }
  
  def contains(cell: Cell): Boolean = {
    cells.contains(cell)
  }

  def containsAsNumber(cell: Cell): Int = {
    if (cells.contains(cell) ) 1 else 0
  }
  
  
  def amountOfNeighbors(cell: Cell): Int = {
    containsAsNumber(Cell(cell.x + 1, cell.y)) + containsAsNumber(Cell(cell.x, cell.y + 1))
    + containsAsNumber(Cell(cell.x - 1, cell.y - 1))
 
  }
}