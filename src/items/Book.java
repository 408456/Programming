package items;

import exceptions.ItemCreationException;

public class Book extends Item {
    public Book(int weight, String type) throws ItemCreationException {
        super(type, weight, 0, 0, false);
    }
}
