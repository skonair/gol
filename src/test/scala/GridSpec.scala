import org.scalatest.FunSpec

class GridSpec extends FunSpec {
  
  /**
   * 000
   * 011
   * 010
   */
  val filledGrid = Grid(Set(Cell(2,2), Cell(3,2), Cell(2,3)))
  val filledGridAfterCycle = Grid(Set(Cell(2,2), Cell(3,2), Cell(2,3), Cell(3,3)))
  
  describe("The Cell") {
    val cell = Cell(22,12)
    it ("should consists of a x and y koordinate"){
       
      assert(cell.x === 22)
      assert(cell.y === 12)      
    }

    it ("should return a set of neighbors") {
      assert(cell.surroundingSet == 
        Set(Cell(21,11),  Cell(22,11), Cell(23,11), 
            Cell(21,12), Cell(22,12), Cell(23,12), 
            Cell(21,13), Cell(22,13), Cell(23,13)))
          
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
      assert(filledGrid.amountOfNeighbors(Cell(2,1)) === 2)
      
      assert(filledGrid.amountOfNeighbors(Cell(2,4)) === 1)      
      assert(filledGrid.amountOfNeighbors(Cell(2,2)) === 2)

    }
    
    it("should implement the game cycle") {
       assert(filledGrid.cycle === filledGridAfterCycle)
    }
    
    it("should display the checker board") {
      
      val displayOutput =  """|...
                              |.**
                              |.*.""".stripMargin
        
      println(displayOutput)
      println("'" + filledGrid.display + "'")
      
       assert(filledGrid.display === displayOutput)
    }
    
  }

  
  
}