package src;
public class GymMembers {
    private static GymMembers instance;
    private Performer strategy;

    // Private constructor
    private GymMembers() {
        this.strategy = new TopPerformer();
    }

    // Public method to get the instance
    //Synchronized used for thread safety 
    public static synchronized GymMembers getInstance() {
         // Singleton pattern: Check if instance is null and if so then it will create new instance
        if (instance == null) {
            instance = new GymMembers();
        }
        return instance;
    }

    public BestBodyBuilder evolve(BestBodyBuilder population) {
        BestBodyBuilder newPopulation = new BestBodyBuilder(population.size());

        // Elitism: Keep the best individual
        newPopulation.saveIndividual(0, population.getFittest());

        // Crossover and mutation
        for (int i = 1; i < population.size(); i++) {
            // Select parents
            IndividualDiet parent1 = strategy.select(population);
            IndividualDiet parent2 = strategy.select(population);

            // Crossover parents
            IndividualDiet child = strategy.crossover(parent1, parent2);

            // Mutate the offspring
            strategy.mutate(child);

            // Add child to new population
            newPopulation.saveIndividual(i, child);
        }

        return newPopulation;
    }

}