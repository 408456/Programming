package creatures;

import exceptions.CreatureCreationException;
import exceptions.InteractionException;
import interfaces.*;
import items.*;

import java.util.Objects;

public class Troll extends MagicalCreature implements SeasonSensitive, ItemInteractable {

    public Troll(String name, int strength, int health, int intellect, int creative, int attention) throws CreatureCreationException {
        super(name, strength, health, intellect, creative, attention);
        if (name.length() <= 2 || strength < 0 || intellect < 0 || creative < 0 || attention < 0) {
            throw new CreatureCreationException("Некорректные параметры для создания тролля: имя должно содержать минимум 3 символа, " +
                    "а сила, интеллект, креативность и внимание не могут быть отрицательными.");
        }
        System.out.println("В волшебном мире появился муми-тролль " + name + "!");
    }

    @Override
    public int calculateLevel() {
        return (strength + health + intellect + creative + attention) / 10;
    }

    @Override
    public void printInfo() {
        System.out.println(name + " - муми-тролль " + level + " уровня. Очки умений: сила(" + strength + "), здоровье(" + health + "), интеллект(" + intellect + "), креативность(" + creative + "), внимание(" + attention + ")");
    }

    @Override
    public String toString() {
        return "Тролль: " +
                "имя='" + name + '\'' +
                ", сила=" + strength +
                ", здоровье=" + health +
                ", интеллект=" + intellect +
                ", креативность=" + creative +
                ", внимание=" + attention +
                ", очки умений=" + sumPoints +
                ", уровень=" + level;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, strength, health, intellect, creative, attention);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Troll troll = (Troll) o;
        return strength == troll.strength &&
                health == troll.health &&
                intellect == troll.intellect &&
                creative == troll.creative &&
                attention == troll.attention &&
                sumPoints == troll.sumPoints &&
                level == troll.level &&
                Objects.equals(name, troll.name);
    }

    @Override
    public void interactWithItem(Item item) {
        if (item instanceof Book) {
            System.out.println(getName() + " читает книгу " + item.getType());
            increaseIntelligence();
            increaseCreative();
        } else if (item instanceof Wood) {
            System.out.println("Тролль строит из дерева " + item.getType() + " дом");
            increaseStrength();
            increaseCreative();
        } else if (item instanceof Ladder) {
            if (item.getRope()) {
                System.out.println(getName() + " спускается по веревочной лестнице");
            } else {
                System.out.println(getName() + " спускается по обычной лестнице c " + item.getLength() + " ступеньками");
                decreaseStrength();
            }
        } else if (item instanceof Brush) {
            System.out.println(getName() + " чистит щеткой " + item.getType() + " усы");
        } else {
            throw new InteractionException(getName() + " не может взаимодействовать с предметом " + item.getClass().getSimpleName());
        }
    }


    @Override
    public void reactToSeason(Season season) {
        switch (season) {
            case WINTER:
                System.out.println("Зимой муми-тролли на ночевке и не могут ничего делать!");
                break;
            case SPRING:
                increaseHealth();
                decreaseStrength();
                decreaseStrength();
                int sum = getHealth() + getStrength();
                System.out.println((sum < 30) ? "Тролль очень хочет с кем-то поссориться!" : "Тролль выспался и готов помогать другим.");
                break;
            case SUMMER:
                increaseStrength();
                decreaseAttention();
                System.out.println("Летом внимание муми-троллей ухудшается, а настроение и здоровье на высоте!");
                break;
            case AUTUMN:
                decreaseHealth();
                decreaseStrength();
                increaseAttention();
                System.out.println("Осенью муми-тролли готовятся к спячке!");
                break;
            default:
                System.out.println("Неизвестное время года!");
                break;
        }
    }
}

