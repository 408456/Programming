package items;

import exceptions.ItemCreationException;

public abstract class Item{
    protected int weight;
    protected int length;
    protected int width;
    protected String type;
    protected boolean rope;

    public Item(String type, int weight, int length, int width, boolean rope) throws ItemCreationException {
        if (type == "" || weight < 0 || length < 0 || width < 0) {
            throw new ItemCreationException("Ошибка при создании объекта класса " + this.getClass().getSimpleName() +
                    ": все значения должны быть неотрицательными, а название предмета непустым");
        }
        this.type = type;
        this.weight = weight;
        this.length = length;
        this.width = width;
        this.rope = rope;
    }
    public String getType() {
        return type;
    }
    public int getLength(){return length;}
    public boolean getRope(){return rope;}
}
