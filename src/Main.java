package src;
public class Main {
    public static void main(String[] args) {
        // Define the genetic algorithm strategy
        // GeneticAlgorithmStrategy strategy = new MyGeneticAlgorithmStrategy(); // need to define this class
        double[] fitnessArry =new double[10000];
            double fitnessCalc;
        // Create the genetic algorithm with the defined strategy
        DietPlan ga =  DietPlan.getInstance();

        // Initialize population
        Population population = new Population(50); // Example size
        int generationCount = 0;

        // Evolution loop
        while (generationCount < 100) { // Example condition
            generationCount++;

            // Evolve the population
            population = ga.evolve(population);

            // Display information about the population
            System.out.println("Generation: " + generationCount);
            fitnessCalc = population.getFittest().findFitness();
            fitnessArry[generationCount]=fitnessCalc;
            System.out.println("Fittest Individual's Fitness: " + fitnessCalc);
            // Optionally, you can print more details about the fittest individual or other statistics
        }
        ConcreteCumulativeFitnessFactory cumulativeFitnessFactory = new ConcreteCumulativeFitnessFactory();
        // After the loop, you can display the final best solution
        double bestIndividual = cumulativeFitnessFactory.createCumulativeFitness().findFitness(fitnessArry);
        System.out.println("Final Best Individual's Fitness: " + bestIndividual);
        // Optionally, print details of the best individual's diet plan
    }
}