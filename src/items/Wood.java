package items;

import creatures.*;
import exceptions.ItemCreationException;
import interfaces.SeasonSensitive;
import items.Item;

public class Wood extends Item implements SeasonSensitive {

    public Wood(String type, int weight) throws ItemCreationException {
        super(type, weight, 0, 0, false);
    }

    @Override
    public void reactToSeason(Season season) {
        if (season == Season.WINTER) {
            System.out.println("древесина " + getType() + " намокла");
        } else {
            System.out.println("древесину " + getType() + " сухая и готова к использованию");
        }
    }
}
