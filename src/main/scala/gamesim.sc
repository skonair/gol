object gamesim {
  //val filledGrid = Grid(Set(Cell(2,2), Cell(3,2), Cell(2,3), Cell(2, 4)))
  val filledGrid = Grid(Set(Cell(2,2), Cell(3,2), Cell(4,2)))
                                                  //> filledGrid  : Grid = Grid(Set(Cell(2,2), Cell(3,2), Cell(4,2)))
  var currentGrid = filledGrid                    //> currentGrid  : Grid = Grid(Set(Cell(2,2), Cell(3,2), Cell(4,2)))
  for (x <- 1 to 10) {
  	println(x + ":")
  	println(currentGrid.display)
  	println()
  	currentGrid = currentGrid.cycle
  }                                               //> 1:
                                                  //| oooo
                                                  //| o***
                                                  //| 
                                                  //| 2:
                                                  //| oo*
                                                  //| oo*
                                                  //| oo*
                                                  //| 
                                                  //| 3:
                                                  //| oooo
                                                  //| o***
                                                  //| 
                                                  //| 4:
                                                  //| oo*
                                                  //| oo*
                                                  //| oo*
                                                  //| 
                                                  //| 5:
                                                  //| oooo
                                                  //| o***
                                                  //| 
                                                  //| 6:
                                                  //| oo*
                                                  //| oo*
                                                  //| oo*
                                                  //| 
                                                  //| 7:
                                                  //| oooo
                                                  //| o***
                                                  //| 
                                                  //| 8:
                                                  //| oo*
                                                  //| oo*
                                                  //| oo*
                                                  //| 
                                                  //| 9:
                                                  //| oooo
                                                  //| o***
                                                  //| 
                                                  //| 10:
                                                  //| oo*
                                                  //| oo*
                                                  //| oo*
                                                  //| 
  
}