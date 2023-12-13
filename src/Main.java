package po;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ShoppingCenter shoppingCenter = ShoppingCenter.getInstance();
        shoppingCenter.addProduct("Laptop", 1000.0);
        shoppingCenter.addProduct("Smartphone", 500.0);

        // Create an initial population of customers
        List<Customer> initialPopulation = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            initialPopulation.add(new Customer(Math.random() * 1000));
        }

        GeneticAlgorithm ga = new GeneticAlgorithm(initialPopulation);

        // Run the genetic algorithm for a certain number of generations
        for (int generation = 0; generation < 10; generation++) {
            System.out.println("Generation: " + generation);
            ga.selection(shoppingCenter);
            ga.crossover();
            ga.mutation();

            // Optional: Output population details here
            // e.g., print average budget of the population
        }

        // Optional: Final population analysis can be done here
    }
}
