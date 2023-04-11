package seminar01;

import seminar01.units.*;

import javax.swing.text.View;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        startGame();
    }

    private static boolean gameEnded() {
        return BaseHero.filterLiveTeam(BaseHero.getHolyTeam()).isEmpty() || BaseHero.filterLiveTeam(BaseHero.getDarkTeam()).isEmpty();
    }

    private static void startGame() {
        printHeader("Игра начинается");
        Scanner scanner = new Scanner(System.in);
        String input = "";
        int turnsCounter = 0;
        createTeams();
        while (!gameEnded() && !Objects.equals(input, "q")) {
            System.out.println("Нажмите enter для продолжения, или введите q для выхода");
            input = scanner.nextLine();
            if (Objects.equals(input, "q")) break;
            View.view();
            turnsCounter++;
            teamsMakeTurns();
        }
        View.view();
        if (gameEnded()) {
            printHeader("Игра закончена");
            printWin();
        }
    }

    private static void printWin() {
        if (BaseHero.filterLiveTeam(BaseHero.getHolyTeam()).isEmpty())
            printHeader("Все персонажи в первой команде мертвы\nПобедила вторая команда");
        else
            printHeader("Все персонажи во второй команде мертвы\nПобедила первая команда");
    }

    private static void teamsMakeTurns() {
        int[] orderIndexes = getSortedIndexList();
        ArrayList<BaseHero> allHeroesList = BaseHero.getAllTeam();
        for (int id : orderIndexes) {
            allHeroesList.get(id).step();
        }
    }

    private static void showTeams() {
        printHeader("Команды");
        printHeader("Первая команда");
        for (BaseHero hero : BaseHero.getHolyTeam()) {
            System.out.println(hero);
        }
        printHeader("Вторая команда");
        for (BaseHero hero : BaseHero.getDarkTeam()) {
            System.out.println(hero);
        }
    }

    private static void printInitiativeList(int[] orderIndexes) {
        ArrayList<BaseHero> allHeroesList = BaseHero.getAllTeam();
        for (int id : orderIndexes) {
            BaseHero hero = allHeroesList.get(id);
            System.out.println(hero.getInfo() + " Инициатива: " + hero.getInitiative());
        }
    }

    private static int[] getSortedIndexList() {
        ArrayList<BaseHero> allHeroesList = BaseHero.getAllTeam();
        int[] indexes = getIndexesArray(BaseHero.getAllTeam());
        for (int count = 0; count < indexes.length; count++) {
            boolean sorted = true;
            for (int i = 0; i < indexes.length - 1; i++) {
                if (indexes[i] + 1 < indexes.length)
                    if (allHeroesList.get(indexes[i + 1]).getInitiative() > allHeroesList.get(indexes[i]).getInitiative()) {
                        int t = indexes[i + 1];
                        indexes[i + 1] = indexes[i];
                        indexes[i] = t;
                        sorted = false;
                    }
            }
            if (sorted) break;
        }
        return indexes;
    }

    private static int[] getIndexesArray(ArrayList<BaseHero> AllHeroes) {
        int[] orderIndexes = new int[AllHeroes.size()];
        int i = 0;
        for (BaseHero hero : AllHeroes) {
            orderIndexes[i++] = hero.getId();
        }
        return orderIndexes;
    }

    private static void printInitiativeList() {
        PriorityQueue<BaseHero> initiativeList = BaseHero.getInitiativeList();
        printHeader("Очерёдность ходов");
        while (!initiativeList.isEmpty()) {
            System.out.println(initiativeList.poll());
        }
    }

    public static void printHeader(String text) {
        System.out.print("_".repeat(150) + "\n" + text + "\n" + "_".repeat(150));
    }

    public static String getName() {
        return Names.values()[new Random().nextInt(Names.values().length)].toString();
    }

    private static void createTeam(boolean firstTeam) {
        new Farmer(getName(), firstTeam);
        for (int i = 0; i < 9; i++) {
            int random = new Random().nextInt(7);
            switch (random) {
                case 0:
                    new Bowman(getName(), firstTeam);
                    break;
                case 1:
                    new Crossbowman(getName(), firstTeam);
                    break;
                case 2:
                    new Wizard(getName(), firstTeam);
                    break;
                case 3:
                    new Monk(getName(), firstTeam);
                    break;
                case 4:
                    new Spearman(getName(), firstTeam);
                    break;
                case 5:
                    new Rogue(getName(), firstTeam);
                    break;
                default:
                    new Farmer(getName(), firstTeam);
            }
        }
    }
    public static void createTeams() {
        createTeam(true);
        createTeam(false);
    }
}
