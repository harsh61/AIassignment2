public class main {

    public static void main(String[] args) {

        // Create and add our cities
        City city = new City(60, 200);
        TM.addCity(city);
        City city2 = new City(180, 200);
        TM.addCity(city2);
        City city3 = new City(80, 180);
        TM.addCity(city3);
        City city4 = new City(140, 180);
        TM.addCity(city4);
        City city5 = new City(20, 160);
        TM.addCity(city5);
        City city6 = new City(100, 160);
        TM.addCity(city6);
        City city7 = new City(200, 160);
        TM.addCity(city7);
        City city8 = new City(140, 140);
        TM.addCity(city8);
        City city9 = new City(40, 120);
        TM.addCity(city9);
        City city10 = new City(100, 120);
        TM.addCity(city10);
        City city11 = new City(180, 100);
        TM.addCity(city11);
        City city12 = new City(60, 80);
        TM.addCity(city12);
        City city13 = new City(120, 80);
        TM.addCity(city13);
        City city14 = new City(180, 60);
        TM.addCity(city14);
        City city15 = new City(20, 40);
        TM.addCity(city15);
        City city16 = new City(100, 40);
        TM.addCity(city16);
        City city17 = new City(200, 40);
        TM.addCity(city17);
        City city18 = new City(20, 20);
        TM.addCity(city18);
        City city19 = new City(60, 20);
        TM.addCity(city19);
        City city20 = new City(160, 20);
        TM.addCity(city20);

        // Initialize population
        population pop = new population(50, true);
        System.out.println("Initial distance: " + pop.getFittest().getDistance());

        // Evolve population for 100 generations
        pop = Galgo.ePopulation(pop);
        for (int i = 0; i < 100; i++) {
            pop = Galgo.ePopulation(pop);
        }

        // Print final results
        System.out.println("Finished");
        System.out.println("Final distance: " + pop.getFittest().getDistance());
        System.out.println("Solution:");
        System.out.println(pop.getFittest());
    }
}
