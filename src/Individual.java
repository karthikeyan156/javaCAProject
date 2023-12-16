package src;
import java.util.Random;

public class Individual {
    private int[] nutrients;
    private static final int NUTRIENT_COUNT = 5; // Example, can be adjusted
    private static final int MAX_NUTRIENT_VALUE = 100; // Example upper limit

    public Individual() {
        nutrients = new int[NUTRIENT_COUNT];
        Random rand = new Random();
        // Randomly generate a diet plan
        for (int i = 0; i < nutrients.length; i++) {
            nutrients[i] = rand.nextInt(MAX_NUTRIENT_VALUE);
        }
    }

    // Copy constructor
    public Individual(Individual other) {
        this.nutrients = other.nutrients.clone();
    }

    // Getters
    public int[] getNutrients() {
        return nutrients;
    }

    // Setters
    public void setNutrients(int[] nutrients) {
        this.nutrients = nutrients;
    }

    // Additional methods like mutate a single nutrient, etc.
    public void mutateNutrient(int index, int value) {
        if (index >= 0 && index < nutrients.length) {
            nutrients[index] = value;
        }
    }

    // You might also want a method to calculate fitness, or it can be in another class
    public double calculateFitness() {
        // Implement fitness calculation logic
        // Placeholder
        return 0.0;
    }
}