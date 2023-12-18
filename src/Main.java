package src;
public class Main {
    public static void main(String[] args) {
        // Define the genetic algorithm strategy
        // GeneticAlgorithmStrategy strategy = new MyGeneticAlgorithmStrategy(); // need to define this class
        double[] fitnessArry =new double[100];
            double fitnessCalc;
        // Create the genetic algorithm with the defined strategy
        Plan ga =  Plan.getInstance();

        // Initialize population
        Population population = new Population(5); // Example size
        int generationCount = 0;

        // Evolution loop
        while (generationCount < 5) { // Example condition
            generationCount++;

            // Evolve the population
            population = ga.evolve(population);

            // Display information about the population
            System.out.println("Gnerating 5 random individuals for analysing their fitness:");
            System.out.println("Generation: " + generationCount);
            ConcreteIndividualFactory individualFitnessFactory = new ConcreteIndividualFactory();       
            fitnessCalc = individualFitnessFactory.createIndividualFitness().findFitness();;
            fitnessArry[generationCount]=fitnessCalc;
            System.out.println("Individual's Fitness: " + fitnessCalc);
            // Optionally, you can print more details about the fittest individual or other statistics
        }
       
        ConcreteCumulativeFitnessFactory cumulativeFitnessFactory = new ConcreteCumulativeFitnessFactory();
        // After the loop, you can display the final best solution
        double bestIndividual = cumulativeFitnessFactory.createCumulativeFitness().findFitness(fitnessArry);
        System.out.println("Final Best Individual's Fitness: " + bestIndividual);


        // Optionally, print details of the best individual's diet plan
        DietPlanContext context = new DietPlanContext();

        // Using high protein diet strategy
        context.setStrategy(new HighProteinDietStrategy());
        System.out.println("The Best High Protien Diet : " + context.slectDiet());

        context.setStrategy(new LowCarbDietStrategy());
        System.out.println("The Best Low Carb Diet : " + context.slectDiet());

        System.out.println("Make a Recipe with these Items to Attain Best Fitness.");
        System.out.println("For More Recipe with this Items visit our Web site www.myrecipe.com");
    }
}