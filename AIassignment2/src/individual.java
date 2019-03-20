
public class indiviual {
  static int len = 64;
  private int[] genes = new int[len];

  private int fitness = 0;

// creates the random path which is individual
  public void path() {
    for(int i = 0; i < genes.length; i++) {
      int gene = (int) Math.round(Math.random());
      genes[i] = gene;
    }
  }

  // access fittest individual from FitnessCalc
  public int getFitness() {
    if(fitness == 0) {
      fitness = FitnessCalc.getFitness(this);
    }
    return fitness;
  }
}
