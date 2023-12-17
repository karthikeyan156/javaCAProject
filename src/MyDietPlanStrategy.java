package src;

import java.util.Random;

public class MyDietPlanStrategy implements DietPlanStrategy {
    @Override
    public void mutate(Individual individual) {
        Random rand = new Random();
        int nutrientToMutate = rand.nextInt(individual.NUTRIENT_COUNT); // Randomly select a nutrient to mutate
        int newValue = rand.nextInt(individual.MAX_NUTRIENT_VALUE + 1); // Generate a new random value
    
        individual.mutateNutrient(nutrientToMutate, newValue);
    }


@Override
public Individual crossover(Individual parent1, Individual parent2) {
    Individual offspring = new Individual();

    Random rand = new Random();
    int crossoverPoint = rand.nextInt(offspring.NUTRIENT_COUNT); // Randomly select a crossover point

    for (int i = 0; i < offspring.NUTRIENT_COUNT; i++) {
        if (i < crossoverPoint) {
            offspring.getNutrients()[i] = parent1.getNutrients()[i];
        } else {
            offspring.getNutrients()[i] = parent2.getNutrients()[i];
        }
    }

    return offspring;
}

@Override
public Individual select(Population population) {
    Random rand = new Random();
    double totalFitness = 0.0;

    // Calculate the total fitness of the population
    for (int i = 0; i < population.size(); i++) {
        totalFitness += population.getIndividual(i).calculateFitness();
    }

    // Generate a random value between 0 and the total fitness
    double randomValue = rand.nextDouble() * totalFitness;

    // Iterate through the population and select the individual that corresponds to the random value
    double cumulativeFitness = 0.0;
    for (int i = 0; i < population.size(); i++) {
        cumulativeFitness += population.getIndividual(i).calculateFitness();
        if (cumulativeFitness >= randomValue) {
            return population.getIndividual(i);
        }
    }

    // If no individual is selected, return the last one (fallback)
    return population.getIndividual(population.size() - 1);
}

}
