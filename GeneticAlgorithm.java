package po;
import java.util.*;

public class GeneticAlgorithm {
    private List<Customer> population;

    public GeneticAlgorithm(List<Customer> initialPopulation) {
        this.population = new ArrayList<>(initialPopulation);
    }

    // Selection: Select the top customers based on their fitness (spending)
    public void selection(ShoppingCenter shoppingCenter) {
        population.sort(Comparator.comparingDouble(customer -> customer.calculateFitness(shoppingCenter)).reversed());
        population = new ArrayList<>(population.subList(0, population.size() / 2)); // Keep top 50%
    }

    // Crossover: Create new customers by combining traits of existing customers
    public void crossover() {
        List<Customer> newGeneration = new ArrayList<>();
        for (int i = 0; i < population.size() - 1; i += 2) {
            Customer parent1 = population.get(i);
            Customer parent2 = population.get(i + 1);

            // Simple crossover: average of parents' budgets
            double childBudget = (parent1.getBudget() + parent2.getBudget()) / 2;
            newGeneration.add(new Customer(childBudget));
        }
        population.addAll(newGeneration);
    }

    // Mutation: Introduce random changes to customer traits
    public void mutation() {
        for (Customer customer : population) {
            if (Math.random() < 0.1) { // 10% chance of mutation
                // Simple mutation: randomize budget within a range
                customer.setBudget(customer.getBudget() * (0.8 + Math.random() * 0.4));
            }
        }
    }

    // Getters
    public List<Customer> getPopulation() {
        return population;
    }
}
