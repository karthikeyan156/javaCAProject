package src;

public class DietPlanContext {
    private DietPlanStrategy strategy;

    public void setStrategy(DietPlanStrategy strategy) {
        this.strategy = strategy;
    }
    
    public String slectDiet() {
        return strategy.select();
    }
}
