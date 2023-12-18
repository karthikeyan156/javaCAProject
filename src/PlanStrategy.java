package src;
public interface PlanStrategy {

    void mutate(Individual individual);
    Individual crossover(Individual parent1, Individual parent2);
    Individual select(Population population);
}