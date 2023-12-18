package src;
public class Plan {
    private static Plan instance;
    private PlanStrategy strategy;

    // Private constructor
    private Plan() {
        this.strategy = new MyPlanStrategy();
    }

    // Public method to get the instance
    //Synchronized used for thread safety 
    public static synchronized Plan getInstance() {
         // Singleton pattern: Check if instance is null and if so then it will create new instance
        if (instance == null) {
            instance = new Plan();
        }
        return instance;
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