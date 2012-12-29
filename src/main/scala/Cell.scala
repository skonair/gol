case class Cell(x: Int, y: Int) {
  def surroundingSet: Set[Cell] = {
    (for {
      x <- -1 to 1
      y <- -1 to 1
    } yield Cell(this.x + x, this.y + y)).toSet
  }
}

case class Grid(cells: Set[Cell] = Set.empty) {

  def addCell(cell: Cell): Grid = {
    Grid(cells + cell)
  }

  def contains(cell: Cell): Boolean = {
    cells.contains(cell)
  }

  def containsAsNumber(cell: Cell): Int = {
    if (cells.contains(cell)) 1 else 0
  }

  def amountOfNeighbors(cell: Cell): Int = {
    val neigbours =
      for {
        x <- -1 to 1
        y <- -1 to 1
        if (x != 0) || (y != 0)
      } yield {
        containsAsNumber(Cell(cell.x + x, cell.y + y))
      }
    neigbours.sum
  }

  def cycle: Grid = {
    val cellCandidates: Set[Cell] = cells map (_.surroundingSet) flatten
    val neighbours = cellCandidates diff cells
    val livingNeighbours = neighbours filter (cell => amountOfNeighbors(cell) == 3)
    val survivingCell = cells filter (Set(2, 3) contains amountOfNeighbors(_))
    Grid(livingNeighbours union survivingCell)
  }
  
  def display: String = {
    val maxX = cells map (_.x) max
    val maxY = cells map (_.y) max
    val displayString = for {
      y <- 1 to maxY
      x <- 1 to maxX
    } yield {
      val mark = if (cells contains Cell(x,y)) "*" else "."
      if (x == maxX && y < maxY) mark + "\n" else mark  
    } 
    displayString mkString
  }
}