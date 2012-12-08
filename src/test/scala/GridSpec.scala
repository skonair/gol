import org.scalatest.FunSpec

class GridSpec extends FunSpec {
  
  /**
   * 000
   * 011
   * 010
   */
  val filledGrid = Grid(Set(Cell(2,2), Cell(3,2), Cell(2,3)))
  
  describe("The Cell") {
    it ("should consists of a x and y koordinate"){
      val cell = Cell(22,12)
       
      assert(cell.x === 22)
      assert(cell.y === 12)
      
    }
  }
   
  describe("The Grid") {
    it("should contain live cells") {
      val grid = Grid()
      val cell = Cell(22,12) 
      
      val newGrid = grid.addCell(cell)
      assert(newGrid.contains(cell))
      
      assert(newGrid.contains(Cell(0,0)) === false)
 
    }
    it("should have correct amount of neighbors") {
      
      assert(filledGrid.amountOfNeighbors(Cell(1,1)) === 1)
      
      assert(filledGrid.amountOfNeighbors(Cell(2,4)) === 1)      
      assert(filledGrid.amountOfNeighbors(Cell(2,2)) === 2)
            
    }
  }

}