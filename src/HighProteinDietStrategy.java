package src;

import java.util.Random;

public class HighProteinDietStrategy implements DietPlanStrategy {
    String[] foodlist01 = {
        "Chicken Breast", 
        "Turkey Breast", 
        "Egg Whites", 
        "Tuna", 
        "Salmon", 
        "Greek Yogurt", 
        "Lentils", 
        "Black Beans", 
        "Quinoa", 
        "Tofu"
    };
    String[] foodlist02 = {
        "Lean Beef", 
        "Pork Chops", 
        "Cottage Cheese", 
        "Tempeh", 
        "Edamame", 
        "Chickpeas", 
        "Almonds", 
        "Peanut Butter", 
        "Milk", 
        "Cheese"
    };

    @Override
    public  String[] crossover() {
        if (foodlist01.length != foodlist02.length) {
            throw new IllegalArgumentException("Arrays must be of the same length");
        }

        int halfLength = foodlist01.length / 2;
        String[] result = new String[foodlist01.length];

        // Copy first half from list1
        for (int i = 0; i < halfLength; i++) {
            result[i] = foodlist01[i];
        }

        // Copy second half from list2
        for (int i = halfLength; i < foodlist01.length; i++) {
            result[i] = foodlist02[i];
        }

        return result;
    }

    @Override
    public String select() {
        Random random = new Random();
        String[] foodlist = crossover();
        int i =random.nextInt(foodlist.length);
        
        return foodlist[i]; 
    }
}


