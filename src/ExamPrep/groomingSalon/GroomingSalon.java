package ExamPrep.groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private List<Pet> data;
    private int capacity;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (this.data.size() < this.capacity) {
            this.data.add(pet);
        }
    }
    public boolean remove(String name) {
        return data.removeIf(pet -> pet.getName().equals(name));
    }
    public Pet getPet(String name, String owner) {
        Pet isFound = null;
        for (Pet pet : data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                isFound = pet;
            }
        }
        return isFound;
    }
    public int getCount() {
        return this.data.size();
    }
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The grooming salon has the following clients:%n"));
        for (Pet info : data) {
            sb.append(String.format("%s %s%n", info.getName().toString(), info.getOwner().toString()));
        }
        return sb.toString();
    }
}
