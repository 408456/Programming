package creatures;
import exceptions.CreatureCreationException;
import exceptions.InteractionException;
import interfaces.*;
import items.*;

public class Gnome extends MagicalCreature implements SeasonSensitive, ItemInteractable {

    public Gnome(String name, int strength, int health, int creative) throws CreatureCreationException {
        super(name, strength, health, 0, creative, 0);
        if (name.length() <= 2 || strength < 0 || health < 0 || creative < 0) {
            throw new CreatureCreationException("Некорректные параметры при создании гнома: имя должно содержать минимум 3 символа," +
                    " а сила, здоровье и креативность не могут быть отрицательными.");
        }
        System.out.println("В волшебном мире появился гном по имени " + name + "!");
    }

    @Override
    protected int calculateLevel() {
        return (strength + health + creative) / 5;
    }

    @Override
    public void printInfo() {
        System.out.println(name + " - гном " + getLevel() + " уровня." + "Очки умений: сила(" + strength + "), здоровье(" + health + "), креативность(" + creative + ")");
    }

    @Override
    public void interactWithItem(Item item) {
        if (item instanceof Ladder) {
            System.out.println(name + " не умеет спускаться по лестнице");
        } else if (item instanceof Brush) {
            increaseStrength();
            System.out.println(name + " чистит щеткой " + item.getType() + " свою огромную бороду");
        } else {
            throw new InteractionException(name + " не может взаимодействовать с предметом "  + item.getClass().getSimpleName());
        }
    }

    @Override
    public void reactToSeason(Season season) {
        switch (season) {
            case WINTER:
                System.out.println("Зимой гномы прячутся под землей!");
                decreaseHealth();
                break;
            default:
                System.out.println("Гномы реагируют только на зиму...");
                break;
        }
    }
}

