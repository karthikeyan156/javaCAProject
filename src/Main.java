package src;
public class Main {
    public static void main(String[] args) {
        // Define the genetic algorithm strategy
        // GeneticAlgorithmStrategy strategy = new MyGeneticAlgorithmStrategy(); // need to define this class

        // Create the genetic algorithm with the defined strategy
        GymMembers ga =  GymMembers.getInstance();

        // Initialize population
        BestBodyBuilder population = new BestBodyBuilder(50); // Example size
        int generationCount = 0;

        // Evolution loop
        while (generationCount < 100) { // Example condition
            generationCount++;

            // Evolve the population
            population = ga.evolve(population);

            // Display information about the population
            System.out.println("Generation: " + generationCount);
            System.out.println("Fittest Individual's Fitness: " + population.getFittest().calculateFitness());
            // Optionally, you can print more details about the fittest individual or other statistics
        }

        // After the loop, you can display the final best solution
        IndividualDiet bestIndividual = population.getFittest();
        System.out.println("Final Best Individual's Fitness: " + bestIndividual.calculateFitness());
        // Optionally, print details of the best individual's diet plan
    }
}