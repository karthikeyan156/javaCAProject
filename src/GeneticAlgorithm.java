package src;
public class GeneticAlgorithm {
    private GeneticAlgorithmStrategy strategy;

    public GeneticAlgorithm(GeneticAlgorithmStrategy strategy) {
        this.strategy = strategy;
    }

    public Population evolve(Population population) {
        Population newPopulation = new Population(population.size());

        // Elitism: Keep the best individual
        newPopulation.saveIndividual(0, population.getFittest());

        // Crossover and mutation
        for (int i = 1; i < population.size(); i++) {
            // Select parents
            Individual parent1 = strategy.select(population);
            Individual parent2 = strategy.select(population);

            // Crossover parents
            Individual child = strategy.crossover(parent1, parent2);

            // Mutate the offspring
            strategy.mutate(child);

            // Add child to new population
            newPopulation.saveIndividual(i, child);
        }

        return newPopulation;
    }

}