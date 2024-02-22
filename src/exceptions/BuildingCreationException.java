package exceptions;

import items.Building;

public class BuildingCreationException extends Exception{
    public BuildingCreationException(String message){
        super(message);
    }
}
