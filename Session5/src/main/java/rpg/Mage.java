package rpg;

public class Mage extends Character{
    private static final int BASE_DAMAGE = 25;
    private static final int HEALTH = 80;
    private static final int SPEED = 10;

    public Mage(String name) {
        super(name, HEALTH,SPEED);
    }

    @Override
    public int attack() {
        int damage = BASE_DAMAGE + random.nextInt(11)-5;
        System.out.println(name + " casts a powerful spell for " + damage + " damage!");
        return damage;
    }

}
