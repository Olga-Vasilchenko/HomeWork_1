package seminar01.units;

public class Crossbowman extends BaseHero { // класс Sniper расширяет BaseHero
    int arrows;
    int accuracy;

    public Crossbowman(String name) {
        super(100, name, 1, 6, 75, new int[]{8, 14}, "Арбалетчик"); // задаем параметры снайперу
        arrows = 10;
        accuracy = 50;
    }

}
