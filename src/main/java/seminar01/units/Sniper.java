package seminar01.units;

public class Sniper extends BaseHero{ // класс Sniper расширяет BaseHero
    int arrows;
    int accuracy;

    public Sniper(String name) {
        super(100, name, 1, 6, 50, new int[]{6, 12}, "Снайпер"); // задаем параметры снайперу
        arrows = 10;
        accuracy = 70;
      }
}
