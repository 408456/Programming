package items;

import exceptions.ItemCreationException;

public class Brush extends Item {
    public Brush(int weight, String type) throws ItemCreationException {
        super(type, weight, 0, 0, false);
    }
}
