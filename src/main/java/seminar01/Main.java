package seminar01;

import seminar01.teams.Team;
import seminar01.units.*;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Team<BaseHero> firstTeam = new Team<BaseHero>("Хаос", true, 10);

        Team<BaseHero> secondTeam = new Team<BaseHero>("Свет", false, 10);

        printHeader("Расположение");

        printHeader("Команда " + firstTeam.getTeamName());
        firstTeam.forEach(n -> System.out.println(n.getHeroName() + " " + n.getPosition()));

        printHeader("Команда " + secondTeam.getTeamName());
        secondTeam.forEach(n -> System.out.println(n.getHeroName() + " " + n.getPosition()));

        printHeader("Ходы");

        printHeader("Команда " + firstTeam.getTeamName());
        firstTeam.forEach(n -> n.step(secondTeam));

        printHeader("Команда " + secondTeam.getTeamName());
        secondTeam.forEach(n -> n.step(firstTeam));

    }

    public static void printHeader(String text){
        System.out.print("_".repeat(40) + "\n" + text + "\n" + "_".repeat(40) + "\n");
    }

    public static String getName() {
        return Names.values()[new Random().nextInt(Names.values().length)].toString();
    }

    public static ArrayList<BaseHero> createTeam(boolean firstTeam) {
        ArrayList<BaseHero> heroes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int random = new Random().nextInt(6);
            switch (random) {
                case 0:
                    heroes.add(new Bowman(getName(), firstTeam));
                    break;
                case 1:
                    heroes.add(new Crossbowman(getName(), firstTeam));
                    break;
                case 2:
                    heroes.add(new Mage(getName(), firstTeam));
                    break;
                case 3:
                    heroes.add(new Monk(getName(), firstTeam));
                    break;
                case 4:
                    heroes.add(new Spearman(getName(), firstTeam));
                    break;
                case 5:
                    heroes.add(new Thief(getName(), firstTeam));
                    break;
                default:
                    heroes.add(new Peasant(getName(), firstTeam));
            }
        }
        return heroes;
    }

}
