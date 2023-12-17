package src;
import java.util.Random;

public class Individual {
    private int[] nutrients;
    private static final int[] targetNutrients = {52,35,20,10,40,70,60,55,95,15,25,67,89,23,45,12,46,7,18,5}; 
    public final int NUTRIENT_COUNT = 20; 
    public final int MAX_NUTRIENT_VALUE = 100; 

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
        return nutrients.clone(); // Return a clone for encapsulation
    }

    // Setters
    public void setNutrients(int[] nutrients) {
        if (nutrients != null && nutrients.length == NUTRIENT_COUNT) {
            this.nutrients = nutrients.clone(); // Clone for encapsulation
        }
    }

    // Mutate a single nutrient
    public void mutateNutrient(int index, int value) {
        if (index >= 0 && index < nutrients.length) {
            nutrients[index] = Math.min(Math.max(value, 0), MAX_NUTRIENT_VALUE); // Ensure within valid range
        }
    }

    // Calculate fitness
    public double calculateFitness() {
        double fitness = 0.0;

        // Advanced fitness calculation: normalized inverse sum of squared differences
        for (int i = 0; i < nutrients.length; i++) {
            double normalizedDifference = (double)(nutrients[i] - targetNutrients[i]) / MAX_NUTRIENT_VALUE;
            fitness += normalizedDifference * normalizedDifference;
        }

        return 1 / (1.0 + Math.sqrt(fitness)); // Squared root to normalize, then invert
    }
}
