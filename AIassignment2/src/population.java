+
public class population {
  individual[] indivi;

    public population(int size, boolean initial) {
      indivi = new individual[size];
	    for (int i = 0; i < indivi.length; i++) {
		      individual newIndi = new individual();
	        newIndi.path();
	        saveIndividual(i, newIndi);
	    }
    }

    public individual getIndi(int index) {
      return indivi[index];
    }

    public individual getFittest() {
      individual fittest = indivi[0];
      for (int i = 0; i < indivi.length; i++) {
        if(fittest.getFitness() <= getIndi(i).getFitness()) {
          fittest = getIndi(i);
        }
      }
      return fittest;
    }

    public void saveIndividual(int index, individual indiv) {
      indivi[index] = indiv;
    }
}
