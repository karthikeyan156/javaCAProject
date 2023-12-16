package src;

public class FitnessCalc {

    // Example target nutritional values
    private static final int[] targetNutrients = {50, 30, 20, 10, 40}; // Placeholder values

    public static double getFitness(Individual individual) {
        int[] nutrients = individual.getNutrients();
        double fitness = 0.0;

        // Simple fitness calculation: sum of the differences from the target values
        for (int i = 0; i < nutrients.length; i++) {
            fitness += Math.abs(nutrients[i] - targetNutrients[i]);
        }

        // Inverting the sum, as lower values are better (closer to target)
        fitness = 1.0 / (fitness + 1.0);

        return fitness;
    }
}