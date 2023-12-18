# Diet Plan Optimization Program

### Team Members
- Tamilarasan Thangaiah (23250665) - 33.33% Contribution
- Karthikeyan Nagarajan (23250753) - 33.33% Contribution
- Nithish Kumar Narravula (23250752) - 33.33% Contribution

### 1. Introduction
#### Purpose
The purpose of the Diet Plan Optimization Program is to use a genetic algorithm to optimize a diet plan based on nutritional requirements. This program aims to find the best combination of nutrients that meet specific dietary goals.

#### Scope
The program takes into account a predefined set of nutrients and their target values. The genetic algorithm is employed to evolve a population of diet plans to find the optimal diet plan that meets the nutrient requirements.

### 2. Detailed Process Steps
####  Initialization
1. The program defines the following parameters:
   - Nutrient Count: The number of nutrients in the diet plan.
   - Maximum Nutrient Value: The upper limit for each nutrient value.
   - Population Size: The number of diet plans in the population.
   - Mutation Rate: The probability of mutation during the evolution process.
   - Target Nutrient Values: The desired values for each nutrient.

2. The program initializes a population of diet plans:
   - Each diet plan contains randomly generated nutrient values within the specified range.

#### Genetic Algorithm
###### The Genetic Algorithm begins the evolution process:
   - Initialize a generation counter.
   - Evaluate the fitness of each individual in the population based on how well their diet plan meets the nutrient requirements.

###### Repeat the following steps until the termination condition is met:
   a. Selection:
      - Select individuals from the population for the next generation based on their fitness. Higher fitness individuals have a higher chance of being selected.

   b. Crossover:
      - Pair selected individuals and perform crossover to create offspring diet plans.
      - Offspring inherit genetic material from their parents.

   c. Mutation:
      - Apply mutation to some offspring diet plans with a probability determined by the mutation rate.
      - Mutation introduces small random changes to nutrient values.

   d. Fitness Evaluation:
      - Evaluate the fitness of each individual in the new generation based on how well their diet plan meets the nutrient requirements.

   e. Replacement:
      - Replace the old generation with the new generation based on fitness.
      - Higher fitness individuals from the new generation replace lower fitness individuals from the old generation.

   f. Increment the generation counter.

#### Termination
###### Check the termination condition:
   - If the specified number of generations is reached, terminate the evolution process.

#### How To Compile and Run the code
- To compile the program, use the command `javac Main.java'
- To run the program, use the command 'java Main.java'
- The program does not require user input; it processes data based on predefined input and adapts dynamically at runtime.

#### Singleton Pattern
- The Singleton Pattern is implemented in the file called `Plan.java` to guarantee the existence of a single, uniform instance across the entire application.
- Employs a synchronized `getInstance()` method, guaranteeing thread safety during the creation of the Singleton instance.
```
public static synchronized Plan getInstance() {
         // Singleton pattern: Check if instance is null and if so then it will create new instance
        if (instance == null) {
            instance = new Plan();
        }
        return instance;
    }
```

#### Strategy Pattern
- The Strategy Pattern is implemented in the file called `DietPlanStrategy` to allow flexible and interchangeable algorithms or behaviors within a class, making it easy to switch or extend functionality without altering the class itself. 
- It promotes better code organization, reusability, and adaptability by encapsulating different strategies as separate objects, enabling dynamic selection of the appropriate strategy at runtime.
- In the program, we've implemented the "DietPlanStrategy" interface, and within the setters, we've defined the high and low carbohydrate foods. When the program is executed, it provides information about the best options for foods with both the highest and lowest carbohydrate content.
```
public class StatergySelector {
    private StatergySelector strategy;
    public StatergySelector(StatergySelector strategy) {
        this.strategy = strategy;
    }
    public void setStrategy(StatergySelector strategy) {
        this.strategy = strategy;
    }
}
```

#### Factory Pattern
- In Factory Pattern, we have implemented Abstract pattern inorder to provide an interface for creating families of related or dependent objects without specifying their concrete classes. 
- It allows for the creation of object groups with consistent interfaces, promoting modularity and flexibility in software design while hiding the implementation details.
- The Abstract Factory Pattern has been employed to implement a mechanism for finding both the best fitness for an individual and the cumulative best fitness across a population.
- Created concrete class `ConcreteIndividualFactory.java` and `ConcreteCummualtiveFactory.java` and its iterfaces are `IndividualFitness` and `CummualtiveFitness` as repectively.
```
class ConcreteIndividualFactory implements IndividualFitnessFactory {
    @Override
    public Individual createIndividualFitness() {
         return new Individual();
    }
}
```
```
public class ConcreteCumulativeFitnessFactory implements CummulativeFitnessFactory {
    @Override
    public CumulativeFitness createCumulativeFitness() {
        return new CumulativeFitness();
    }
}
```

#### Result
###### Output the best diet plan found by the GA:
   - The diet plan with the highest fitness represents the optimized diet plan.
   - Utilizing the Strategy design pattern, we are displaying the food items with both the highest and lowest carbohydrate content.

