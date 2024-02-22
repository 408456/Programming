package items;

import exceptions.ItemCreationException;

public class Herb extends Item {
    public Herb(int weight, String type) throws ItemCreationException {
        super(type, weight, 0, 0, false);
    }
}
