package seminar01.units;

import seminar01.teams.Team;

import java.util.ArrayList;

public interface GameInterface {

    void step(ArrayList<BaseHero> enemyTeam );

    String getInfo();

    void step(Team<BaseHero> enemyTeam);
}
