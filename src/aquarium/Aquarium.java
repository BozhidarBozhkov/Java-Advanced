package aquarium;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Aquarium {
    private Set<Fish> fishInPool;
    private String name;
    private int capacity;
    private int size;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        fishInPool = new LinkedHashSet<>();
    }

    public int getFishInPool() {
        return fishInPool.size();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public void add(Fish fish) {
        boolean haveSameFish = false;
        for (Fish fish1 : fishInPool) {
            if (fish1.equals(fish.getName())) {
                haveSameFish = true;
            }
        }
        if (!haveSameFish && this.fishInPool.size() < this.capacity) {
            this.fishInPool.add(fish);
        }
    }
    public boolean remove(String name) {
       // return fishInPool.removeIf(fish -> fish.getName().equals(name));
        for (Fish fish : this.fishInPool) {
            if (fish.getName().equals(name)) {
                this.fishInPool.remove(fish);
                return true;
            }
        }
        return false;
    }
    public Fish findFish(String name) {
        return fishInPool.stream().filter(fish -> fish.getName().equals(name)).findFirst().orElse(null);
    }
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Aquarium: %s ^ Size: %d%n", name, size));

        fishInPool.forEach(fish -> sb.append(fish.toString()).append(String.format("%n")));
        return sb.toString();
    }
}
