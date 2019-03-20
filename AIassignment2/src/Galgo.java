extends main; 

import java.util.*;

public class Galgo {

    // parameters for the algorithm 
    private static final double mutationRate = 0.015;
    private static final int tournamentSize = 5;
    private static final boolean elitism = true;

    // Evolves a population
    public static population ePopulation(population pop) {
        population newPopulation = new population(pop.populationSize(), false);

        // Keep our best individual if elitism is enabled
        int elitismOffset = 0;
        if (elitism) {
            newPopulation.saveTour(0, pop.getFittest());
            elitismOffset = 1;
        }

        // Crossover population which loops the new population size 
        for (int i = elitismOffset; i < newPopulation.populationSize(); i++) {
           
            Tour p1 = tourSelection(pop);
            Tour p2 = tourSelection(pop);
            Tour child = crossover(parent1, p2); //this is where the crossover happens with the child
            newPopulation.saveTour(i, child);
        }

        // Mutate the new population 
        for (int i = elitismOffset; i < newPopulation.populationSize(); i++) {
            mutate(newPopulation.getTour(i));
        }

        return newPopulation;
    }

    // Applies crossover, which is going to a set a parent and will create offsprings
    public static Tour crossover(Tour p1, Tour p2) {
        Tour child = new Tour();

        // start and end sub tour positions for p1
        int sPos = (int) (Math.random() * p1.tourSize());
        int ePos = (int) (Math.random() * p1.tourSize());

        // Loop and add the sub tour from p1 to the child
        for (int i = 0; i < child.tourSize(); i++) {
            if (sPos < ePos && i > sPos && i < ePos) { // If the start position is less than the end position
                child.setCity(i, p1.getCity(i));
            } 
            else if (sPos > ePos) {
                if (!(i < sPos && i > ePos)) {
                    child.setCity(i, p1.getCity(i));
                }
            }
        }

        // Loop through p2 city tour
        for (int i = 0; i < p2.tourSize(); i++) {
            // If child doesn't have the city add it
            if (!child.containsCity(p2.getCity(i))) {
                // Loop to find a spare position in the child's tour
                for (int ii = 0; ii < child.tourSize(); ii++) {
                    if (child.getCity(ii) == null) {
                        child.setCity(ii, p2.getCity(i));
                        break;
                    }
                }
            }
        }
        return child;
    }

    // Mutate a tour using swap mutation
    private static void mutate(Tour tour) {
        for(int tourPos1=0; tourPos1 < tour.tourSize(); tourPos1++){
            // Apply mutation rate
            if(Math.random() < mutationRate){
                // Get a second random position in the tour
                int tourPos2 = (int) (tour.tourSize() * Math.random());

                City city1 = tour.getCity(tourPos1);
                City city2 = tour.getCity(tourPos2);

                tour.setCity(tourPos2, city1);
                tour.setCity(tourPos1, city2);
            }
        }
    }

    // Selects candidate tour for crossover
    private static Tour touSelection(population pop) {
        population tournament = new Population(tournamentSize, false);
        // For each place in the tournament get a random candidate tour and then adds it
        for (int i = 0; i < tournamentSize; i++) {
            int randomId = (int) (Math.random() * pop.populationSize());
            tournament.saveTour(i, pop.getTour(randomId));
        }
        // Get the fittest tour
        Tour fittest = tournament.getFittest();
        return fittest;
    }
}