package items;

import exceptions.ItemCreationException;
import items.Item;

public class Ladder extends Item {
    public Ladder(int length, boolean rope) throws ItemCreationException {
        super(null, 0, length, 0, rope);
    }
}
