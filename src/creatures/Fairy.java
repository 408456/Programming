package creatures;

import exceptions.CreatureCreationException;
import exceptions.InteractionException;
import interfaces.ItemInteractable;
import items.Brush;
import items.Item;
import items.Wood;

public class Fairy extends MagicalCreature implements ItemInteractable {

    public Fairy(String name) throws CreatureCreationException {
        super(name, 0, 0, 0, 0, 0);
        if (name.length() <= 2) {
            throw new CreatureCreationException("Некорректные параметры для создания феи: имя должно содержать больше 2 букв");
        }
        this.name = name;
        System.out.println("В волшебном мире появилась фея " + name + "!");
    }
    public class Wings{
        String color;

        public Wings(String color) {
            this.color = color;
            System.out.println("У феи " + getName() + " есть " + getColor() + " крылья!");
        }
        public String getColor() {
            return color;
        }
    }
    public class MagicWand{
        String material;

        public MagicWand(String material) {
            this.material = material;
            System.out.println("У феи " + getName() + " есть волшебная палочка из материала " + getMaterial() + "!");
        }
        public String getMaterial(){
            return material;
        }
    }

    @Override
    protected int calculateLevel() {
        return 0;
    }

    @Override
    public void printInfo() {
        System.out.println("Фея " + name);
    }

    @Override
    public void interactWithItem(Item item) {
        if (item instanceof Wood) {
            System.out.println(name + " отдыхает на древесине " + item.getType());
        } else if (item instanceof Brush) {
            System.out.println(name + " расчесывает свои длинные волосы");
        } else {
            throw new InteractionException(name + " не может взаимодействовать с предметом " + item.getClass().getSimpleName());
        }
    }
}
