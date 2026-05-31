// ============================
// Person.java
// ============================

public abstract class Person implements Describable {

    private String name;
    private String clue;

    public Person(String name, String clue) {

        this.name = name;
        this.clue = clue;
    }

    public String getName() {
        return name;
    }

    public String getClue() {
        return clue;
    }

    public abstract boolean isZombie();

    @Override
    public String describe() {

        return name + " -> " + clue;
    }
}