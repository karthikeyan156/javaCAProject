package src;

class ConcreteIndividualFactory implements IndividualFitnessFactory {
    @Override
    public Individual createIndividualFitness() {
         return new Individual();
    }
}

