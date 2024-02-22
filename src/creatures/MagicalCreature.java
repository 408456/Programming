package creatures;
import exceptions.*;
import interfaces.*;
import items.*;

public abstract class MagicalCreature {
    protected String name;
    protected int strength;
    protected int health;
    protected int intellect;
    protected int creative;
    protected int attention;
    protected int sumPoints;
    protected int level;

    public MagicalCreature(String name, int strength, int health, int intellect, int creative, int attention) {
        this.name = name;
        this.strength = strength;
        this.health = health;
        this.intellect = intellect;
        this.creative = creative;
        this.attention = attention;
        this.sumPoints = calculateSumPoints();
        this.level = calculateLevel();
    }
    protected int calculateSumPoints() {
        return strength + health + intellect + creative + attention;
    }
    protected abstract int calculateLevel();
    public abstract void printInfo();

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getHealth() {
        return health;
    }

    public int getIntellect() {
        return intellect;
    }

    public int getCreativity() {
        return creative;
    }

    public int getAttention() {
        return attention;
    }

    public int getSumPoints() {
        return sumPoints;
    }

    public int getLevel() {
        return level;
    }
    public void increaseStrength() {
        strength++;
    }

    public void increaseHealth() {
        health++;
    }

    public void increaseIntelligence() {
        intellect++;
    }

    public void increaseCreative() {
        creative++;
    }

    public void increaseAttention() {
        attention++;
    }

    public void decreaseStrength() {
        strength--;
    }

    public void decreaseHealth() {
        health--;
    }

    public void decreaseIntellect() {
        intellect--;
    }

    public void decreaseCreative() {
        creative--;
    }
    public void decreaseAttention(){attention--;}
}