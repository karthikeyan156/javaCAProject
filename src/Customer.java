package po;
public class Customer {
    private double budget; // A gene influencing spending behavior

    public Customer(double budget) {
        this.budget = budget;
    }

    // Fitness function: Determines how good this customer is (based on spending)
    public double calculateFitness(ShoppingCenter shoppingCenter) {
        // Define how spending is calculated
        return shoppingCenter.simulatePurchase(this);
    }

    // Getters and setters
    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
}
