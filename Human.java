// ============================
// Human.java
// ============================

public class Human extends Person {

    public Human(String name, String clue) {

        super(name, clue);
    }

    @Override
    public boolean isZombie() {

        return false;
    }
}