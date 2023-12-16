package src;
public class Population {
    private Individual[] individuals;

    public Population(int size) {
        individuals = new Individual[size];
        for (int i = 0; i < size; i++) {
            individuals[i] = new Individual();
        }
    }

    // Get the individual at a given index
    public Individual getIndividual(int index) {
        return individuals[index];
    }

    // Save an individual at a given index
    public void saveIndividual(int index, Individual indiv) {
        individuals[index] = indiv;
    }

    // Get the size of the population
    public int size() {
        return individuals.length;
    }

    // Get the fittest individual in the population
    public Individual getFittest() {
        Individual fittest = individuals[0];
        for (int i = 1; i < size(); i++) {
            if (fittest.calculateFitness() < getIndividual(i).calculateFitness()) {
                fittest = getIndividual(i);
            }
        }
        return fittest;
    }
}