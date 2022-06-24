package ExamPrep;

import java.util.*;
import java.util.stream.Collectors;

public class AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] ingredientsInput = scanner.nextLine().split("\\s+");
        String[] freshnessInput = scanner.nextLine().split("\\s+");

        List<Integer> ingredients = Arrays.stream(ingredientsInput).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> freshness = Arrays.stream(freshnessInput).map(Integer::parseInt).collect(Collectors.toList());

        ArrayDeque<Integer> ingredientsBucket = new ArrayDeque<>();
        for (Integer element : ingredients) {
            ingredientsBucket.offer(element);
        }
        ArrayDeque<Integer> freshnessBucket = new ArrayDeque<>();
        for (Integer element : freshness) {
            freshnessBucket.push(element);
        }

        Map<String, Integer> cocktails = new TreeMap<>();

        while (!ingredientsBucket.isEmpty() && !freshnessBucket.isEmpty()) {
            if (ingredientsBucket.peek() == 0) {
                ingredientsBucket.poll();
                continue;
            }

            int firstIngredient = ingredientsBucket.poll();
            int lastFreshness = freshnessBucket.pop();

            if (firstIngredient * lastFreshness == 150){ //Pear Sour
                cocktails.putIfAbsent("Pear Sour",0);
                cocktails.put("Pear Sour", cocktails.get("Pear Sour") + 1);
            }else if (firstIngredient * lastFreshness == 250 ){//The Harvest
                cocktails.putIfAbsent("The Harvest",0);
                cocktails.put("The Harvest", cocktails.get("The Harvest") + 1);
            }else if (firstIngredient * lastFreshness == 300){ //Apple Hinny
                cocktails.putIfAbsent("Apple Hinny",0);
                cocktails.put("Apple Hinny", cocktails.get("Apple Hinny") + 1);
            }else if (firstIngredient * lastFreshness == 400){ //High Fashion
                cocktails.putIfAbsent("High Fashion",0);
                cocktails.put("High Fashion", cocktails.get("High Fashion") + 1);
            }else{
                ingredientsBucket.offer(firstIngredient+5);
            }

        }

        System.out.println(cocktails.size() == 4 ? "It's party time! The cocktails are ready!" : "What a pity! " +
                "You didn't manage to prepare all cocktails.");
        if (!ingredientsBucket.isEmpty()){
            int sumOfIngredients = 0;
            for (Integer el : ingredientsBucket) {
                sumOfIngredients += el;
            }
            System.out.println("Ingredients left: " + sumOfIngredients);
        }
        cocktails.entrySet().stream().filter(c -> c.getValue() > 0).forEach(c -> System.out.printf(" # %s --> %d%n", c.getKey(), c.getValue()));
    }

}
