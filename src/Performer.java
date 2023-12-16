package src;
public interface Performer {

    void mutate(IndividualDiet individual);
    IndividualDiet crossover(IndividualDiet parent1, IndividualDiet parent2);
    IndividualDiet select(BestBodyBuilder population);
}