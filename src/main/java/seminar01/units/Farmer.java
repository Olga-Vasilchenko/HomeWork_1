package seminar01.units;

import java.util.Objects;

public class Farmer extends BaseHero {

    public Farmer(String name, boolean firstTeam) {
        super("Фермер", 50, name, firstTeam, 5, new int[]{2, 4}, 1);
    }
    @Override
    public String getInfo() {
        return className + " " + name;
    }

    @Override
    public void step() {
        super.step();
        if(Objects.equals(state, "Dead")) return;
        if(Objects.equals(this.state, "Busy")) {
            this.state = "Stand";
        }
    }
}
