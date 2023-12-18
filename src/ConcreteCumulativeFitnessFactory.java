package src;

public class ConcreteCumulativeFitnessFactory implements CummulativeFitnessFactory {
    @Override
    public CumulativeFitness createCumulativeFitness() {
        return new CumulativeFitness();
    }
}

