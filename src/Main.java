import creatures.*;
import exceptions.*;
import interfaces.Creative;
import items.*;

public class Main {
    public static void main(String[] args) {
        try {
            Fairy fairy = new Fairy("Авдотья");
            Fairy.MagicWand magicWand = fairy.new MagicWand("дерево");
            Fairy.Wings wings = fairy.new Wings("розовый");

            Gnome gnome = new Gnome("Кондрат", 10, 1, 15);
            Troll troll = new Troll("Дионис", 5, 20, 40, 10, 5);

            MagicalCreature[] magicalCreatures = {fairy, gnome, troll};
            for (MagicalCreature creature : magicalCreatures) {creature.printInfo();}

            Book book1 = new Book(700, "Дон Кихот");
            Book book2 = new Book(2000, "Анна Каренина");
            Book book3 = new Book(600, "Доктор Живаго");
            Book book4 = new Book(3000, "Улисс");
            Library library = new Library();
            library.addBook(book1);
            library.addBook(book2);
            library.addBook(book3);
            library.addBook(book4);

            // Создание локального класса
            Library.BookManager bookManager = library.new BookManager();
            bookManager.displayAllBooks();

            Brush brush = new Brush(1, "Гребешок");
            Herb herb = new Herb(10, "Ромашка");
            Ladder ladder = new Ladder(5, true);
            Wood wood = new Wood("Дуб", 20);

            Item[] items = {book1, brush, herb, ladder, wood};

            for (Item item : items) {
//                fairy.interactWithItem(item);
//                gnome.interactWithItem(item);
                troll.interactWithItem(item);
            }

            // Вложенные статические
            Building.Circus circus = new Building.Circus("Цирк имени Снуммерика", 1979, "пр. Фей, 41A", "Здание");
            Building.Theater theater = new Building.Theater("БДТТ", 1979, "ул. Большая Солнечная, 12", "Здание");
            Building.House house = new Building.House("Домик Папы-Тролля", 2005, "ул. Вязов", "Здание");

            // Анонимный класс
            Creative artist = new Creative() {
                @Override
                public void perform(Building.Circus circus) {
                    System.out.println("Артист выступает в цирке " + circus.getName() + " по адресу " + circus.getAddress());
                }
                @Override
                public void play(Building.Theater theater) {
                    System.out.println("Артист играет в театре " + theater.getName() + " по адресу " + theater.getAddress());
                }
            };
        }
        catch (CreatureCreationException | BuildingCreationException | ItemCreationException e){
            System.out.println(e.getMessage());
        }
    }
}