package DefiningClasses.P06PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Pokemon pokemon = null;
        Trainer trainer = null;
        Map<String, Trainer> trainers = new LinkedHashMap<>();
        while (!command.equals("Tournament")) {
            String[] input = command.split("\\s+");
            String trainerName = input[0];
            String pokemonName = input[1];
            String pokemonElement = input[2];
            int pokemonHealth = Integer.parseInt(input[3]);

            pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            trainers.putIfAbsent(trainerName, new Trainer(trainerName));
            trainers.get(trainerName).getPokemons().add(pokemon);

            command = scanner.nextLine();
        }
        command = scanner.nextLine();
        while (!command.equals("End")) {

            for (Trainer value : trainers.values()) {
                for (Pokemon pokemon1 : value.getPokemons()) {
                    if (pokemon1.getElement().equals(command)) {
                        value.setNumberOfBadges();
                        break;
                    } else {
                        pokemon1.setHealth(pokemon1.getHealth() - 10);
                    }
                }
                value.removeDeadPokemons();
            }

            command = scanner.nextLine();
        }
        trainers.entrySet().stream()
                .sorted((t1, t2) -> Integer.compare(t2.getValue().getBadges(), t1.getValue().getBadges()))
                .forEach(e -> {
                    System.out.println(String.format("%s %d %d", e.getKey(), e.getValue().getBadges(), e.getValue().getPokemons().size()));
                });
    }

}
