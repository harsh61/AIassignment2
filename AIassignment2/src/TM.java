extends main; 

import java.util.*;

public class TM {
  // stores allt the cities
  private static ArrayList destination = new ArrayList<City>();

  public static void addCity(City  city) {
    destination.add(city);
  }

  // gets the city
  public static City getCity(int index) {
    return (City)destination.get(index);
  }

  // total number of cities
  public static int numOfCities() {
    return destination.size();
  }
}
