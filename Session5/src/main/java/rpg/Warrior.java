package rpg;

public class Warrior extends Character{
    private static final int BASE_DAMAGE = 15;
    private static final int HEALTH = 120;
    private static final int SPEED = 7;
    public Warrior(String name) {
        super(name, HEALTH, SPEED);
    }

    @Override
    public int attack() {
        int damage = BASE_DAMAGE + random.nextInt(5);
        System.out.println("high damage: " + damage + " low speed: " + speed);
        return damage;
    }



}
