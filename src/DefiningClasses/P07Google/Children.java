package DefiningClasses.P07Google;

public class Children {
    private String childName;
    private String childBirthdate;

    public Children(String childName, String childBirthdate) {
        this.childName = childName;
        this.childBirthdate = childBirthdate;
    }

    public String getChildName() {
        return childName;
    }

    public String getChildBirthdate() {
        return childBirthdate;
    }

    @Override
    public String toString() {
        return String.format("%s %s", getChildName(), getChildBirthdate());
    }
}
