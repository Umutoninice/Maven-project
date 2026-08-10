package rpg;

import java.util.Random;

public abstract class Character {

    String name;
    int health;
int speed;
    protected Random random = new Random();

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Character(String name, int health, int speed) {
        this.name = name;
        this.health = health;
        this.speed=speed;

    }

    public Character() {

    }

    public abstract int attack();
public void takeDamage(int damage) {
    health = Math.max(0, health - damage);
}
    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", health=" + health +
                '}';
    }
}
