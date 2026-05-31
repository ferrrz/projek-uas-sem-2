// ============================
// Zombie.java
// ============================

public class Zombie extends Person {

    private int infectionLevel;

    public Zombie(
            String name,
            String clue,
            int infectionLevel
    ) {

        super(name, clue);

        this.infectionLevel = infectionLevel;
    }

    public int getInfectionLevel() {

        return infectionLevel;
    }

    @Override
    public boolean isZombie() {

        return true;
    }
}