package DefiningClasses.P06PokemonTrainer;
import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int badges;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.badges = badges;
        this.pokemons = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBadges() {
        return badges;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }
    public void setNumberOfBadges() {
        this.badges++;
    }
    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
    public void removeDeadPokemons() {
        pokemons.removeIf(pokemon -> pokemon.getHealth() <= 0);
    }
}
