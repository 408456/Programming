package items;

import exceptions.BuildingCreationException;

public abstract class Building {
    String name;
    String address;
    String type;
    int dateOfConstruction;

    public Building(String name, int dateOfConstruction, String address, String type) {
        this.name = name;
        this.dateOfConstruction = dateOfConstruction;
        this.address = address;
        this.type = type;
    }

    public static class House extends Building {
        public House(String name, int dateOfConstruction, String address, String type) throws BuildingCreationException {
            super(name, dateOfConstruction, address, type);
            setType("Домик");
            if (name.length() <= 2 || dateOfConstruction > 2023 || address.length() <= 2) {
                throw new BuildingCreationException("Неверные параметры при создании здания");
            }
            System.out.println("Ура, в волшебном мире Муми-Троллей появилось " + getType() + ", по адресу " + getAddress());
        }
    }

    public static class Circus extends Building {
        public Circus(String name, int dateOfConstruction, String address, String type) throws BuildingCreationException{
            super(name, dateOfConstruction, address, type);
            setType("Цирк");
            if (name.length() <= 2 || dateOfConstruction > 2023 || address.length() <= 2){
                throw new BuildingCreationException("Неверные параметры при создании здания");
            }
            System.out.println("Ура, в волшебном мире Муми-Троллей появилось " + getType() + ", по адресу " + getAddress());
        }
    }

    public static class Theater extends Building {
        public Theater(String name, int dateOfConstruction, String address, String type) throws BuildingCreationException {
            super(name, dateOfConstruction, address, type);
            setType("Театр");
            if (name.length() <= 2 || dateOfConstruction > 2023 || address.length() <= 2) {
                throw new BuildingCreationException("Неверные параметры при создании здания");
            }
            System.out.println("Ура, в волшебном мире Муми-Троллей появилось " + getType() + ", по адресу " + getAddress());
        }
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getType() {
        return type;
    }

    public int getDateOfConstruction() {
        return dateOfConstruction;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDateOfConstruction(int dateOfConstruction) {
        this.dateOfConstruction = dateOfConstruction;
    }
}
