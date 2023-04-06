package seminar01.units;

import seminar01.teams.Team;
import java.util.ArrayList;
import java.util.Random;

public abstract class Shooter extends BaseHero {
    protected int arrows;
    protected int accuracy;

    public Shooter(int hp, String name, boolean team, int armor, int[] damage, int arrows, int accuracy) {
        super(hp, name, team, armor, damage);
        this.arrows = arrows;
        this.accuracy = accuracy;
    }
    protected void shoot(BaseHero enemy) {
        int dmg = new Random().nextInt(damage[0],damage[1]);
        enemy.getDamage(dmg);
        System.out.println(enemy.getInfo() + " получил(а) урон: " + dmg);
    }
    @Override
    public void step(ArrayList<BaseHero> enemyTeam) {
        System.out.println("Ходит " + getInfo());
        if (hp <= 0 || arrows <= 0) return;
        BaseHero closestEnemy = findClosestEnemy(enemyTeam);
        System.out.println("Найден ближайший противник: " + closestEnemy.getInfo());
        shoot(closestEnemy);
    }
    @Override
    public void step(Team<BaseHero> enemyTeam) {
        System.out.println("Ходит " + getInfo());
        if (hp <= 0 || arrows <= 0) return;
        BaseHero closestEnemy = findClosestEnemy(enemyTeam);
        System.out.println("Найден ближайший противник: " + closestEnemy.getInfo());
        shoot(closestEnemy);
    }
}
