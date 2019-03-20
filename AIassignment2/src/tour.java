import java.util.*;

public class tour {
  // stores all the cities
  private ArrayList tours = new ArrayList<City>();
  private double fitness = 0;
  private int distance = 0;

  // creates a initial empty tour
  public tour() {
    for(int i = 0; i < TM.numOfCities(); i++) {
      tours.add(null);
    }
  }

  public tour(ArrayList tour) {
    this.tours = tour;
  }

  // creates a random destination path
  public void path() {
    // checks through all the destination and adds them to the tour
    for (int i = 0; i < TM.numOfCities(); i++) {
      setCity(i, TM.getCity(i));
    }
    Collections.shuffle(tours);
  }

  // gets the city
  public City getCity(int position) {
    return (City)tours.get(position);
  }

  // sets the position of the city
  public void setCity(int position, City city) {
    tour.set(position, city);
    fitness = 0;
    distance = 0;
  }

  public double getFitness() {
    if (fitness == 0) {
      fitness = 1/(double)getDistance();
    }
    return fitness;
  }

  // gets the total distance of the tour
  public int getDistance() {
    if(distance == 0) {
      int tour = 0;
      City destination;
      // goes through all the cities and adds the destionation distance to it
      for(int i = 0; i < tours.size(); i++) {
        City fromCity = getCity(i);
        // check to see if its the last destination on the tour
        if(i + 1 < tours.size()) {
          destination = getCity(i + 1);
        } else {
          destination = getCity(0);
        }
        tour += fromCity.distanceTo(destination);
      }
      distance = tour;
    }
    return distance;
  }

  // checks to see if the city is in the tour
  public boolean containsCity(City city) {
    return tours.contains(city);
  }

  @Override
  public String toString() {
    String string = "|";
    for(int i = 0; i < tours.size(); i++) {
      string += getCity(i) + "|";
    }
    return string;
  }
}
