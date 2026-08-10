package rpg;

public class Rogue extends Character {
    private static final int BASE_DAMAGE = 10;
    private static final int HEALTH = 90;
    private static final int SPEED = 14;
    private static final double CRIT_CHANCE = 0.3;
    private static final int CRIT_MULTIPLIER = 3;

    public Rogue(String name) {
        super(name, HEALTH, SPEED);
    }

    @Override
    public int attack() {

        int baseDamage = BASE_DAMAGE + random.nextInt(5);
        boolean isCritical = random.nextDouble() < CRIT_CHANCE;

        if (isCritical) {
            int damage = baseDamage * CRIT_MULTIPLIER;
            System.out.println(name + " lands a CRITICAL HIT for " + damage + " damage!");
            return damage;
        } else {
            System.out.println(name + " strikes with daggers for " + baseDamage + " damage.");
            return baseDamage;
        }
    }


}
