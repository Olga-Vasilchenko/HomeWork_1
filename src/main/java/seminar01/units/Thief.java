package seminar01.units;

import seminar01.Spells;

import java.util.ArrayList;

public class Thief extends BaseHero {
    protected ArrayList<Spells> spells_book;
    public Thief(String name) {
        super(100, name, 1, 6, 50, new int[]{8, 15}, "Вор"); // задаем параметры снайперу
    }
    public String getInfo() {
        return "Вор";
    }
}
