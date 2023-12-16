package src;
public class BestBodyBuilder {
    private IndividualDiet[] individuals;

    public BestBodyBuilder(int size) {
        individuals = new IndividualDiet[size];
        for (int i = 0; i < size; i++) {
            individuals[i] = new IndividualDiet();
        }
    }

    // Get the individual at a given index
    public IndividualDiet getIndividual(int index) {
        return individuals[index];
    }

    // Save an individual at a given index
    public void saveIndividual(int index, IndividualDiet indiv) {
        individuals[index] = indiv;
    }

    // Get the size of the population
    public int size() {
        return individuals.length;
    }

    // Get the fittest individual in the population
    public IndividualDiet getFittest() {
        IndividualDiet fittest = individuals[0];
        for (int i = 1; i < size(); i++) {
            if (fittest.calculateFitness() < getIndividual(i).calculateFitness()) {
                fittest = getIndividual(i);
            }
        }
        return fittest;
    }
}