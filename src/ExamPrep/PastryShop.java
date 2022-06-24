package ExamPrep;

import java.util.*;
import java.util.stream.Collectors;

public class PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] liquidsInput = scanner.nextLine().split("\\s+");
        String[] ingredientsInput = scanner.nextLine().split("\\s+");

        List<Integer> liquids = Arrays.stream(liquidsInput).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> ingredients = Arrays.stream(ingredientsInput).map(Integer::parseInt).collect(Collectors.toList());

        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();
        for (Integer integer : liquids) {
            liquidsQueue.offer(integer);
        }

        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();
        for (Integer el : ingredients) {
            ingredientsStack.push(el);
        }

        Map<String, Integer> cookedFoods = new LinkedHashMap<>();
        cookedFoods.put("Biscuit", 0);
        cookedFoods.put("Cake", 0);
        cookedFoods.put("Pie", 0);
        cookedFoods.put("Pastry", 0);
        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {
            int lastIngredient = ingredientsStack.pop();
            int firstLiquid = liquidsQueue.poll();
            int sum = firstLiquid + lastIngredient;

            String cookedFood;
            switch (sum) {
                case 25:
                    int newBiscuitAmount = cookedFoods.get("Biscuit") + 1;
                    cookedFoods.put("Biscuit", newBiscuitAmount);
                    break;
                case 50:
                    int newCakeAmount = cookedFoods.get("Cake") + 1;
                    cookedFoods.put("Cake", newCakeAmount);
                    break;
                case 75:
                    int newPastryAmount = cookedFoods.get("Pastry") + 1;
                    cookedFoods.put("Pastry", newPastryAmount);
                    break;
                case 100:
                    int newPieAmount = cookedFoods.get("Pie") + 1;
                    cookedFoods.put("Pie", newPieAmount);
                    break;
                default:
                    lastIngredient += 3;
                    ingredientsStack.push(lastIngredient);
                    break;
            }
        }
        boolean allFoodsAreCooked = cookedFoods.entrySet().stream()
                .allMatch(e-> e.getValue() > 0);
        if (allFoodsAreCooked) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        String remainingLiquids = liquidsQueue.isEmpty() ? "none" : liquidsQueue.stream().map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println("Liquids left: " + remainingLiquids);

        String remainingIngredients = ingredientsStack.isEmpty() ? "none" : ingredientsStack.stream().map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println("Ingredients left: " + remainingIngredients);

        cookedFoods.entrySet()
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }
}
