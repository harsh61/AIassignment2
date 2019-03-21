public class population {

  // stores alls the tours
  tour[] tours;

  // creates different types of tours
  public population(int size, boolean initial) {
    tours = new tour[size];
    for (int i = 0; i < tours.length; i++) {
	      tour newTour = new tour();
        newTour.path();
        savetour(i, newTour);
    }
  }

  // gets the tour from all the tours
  public tour getTour(int index) {
    return tours[index];
  }

  // gets the best possible route
  public tour getFittest() {
    tour fittest = tours[0];
    for (int i = 0; i < tours.length; i++) {
      if(fittest.getFitness() <= getTour(i).getFitness()) {
        fittest = getTour(i);
      }
    }
    return fittest;
  }

  // saves the tour that we were on
  public void savetour(int index, tour tour) {
    tours[index] = tour;
  }

  // Gets population size
  public int populationSize() {
    return tours.length;
  }
}
