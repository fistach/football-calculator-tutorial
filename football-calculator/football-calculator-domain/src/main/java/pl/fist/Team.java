package pl.fist;

import java.util.Objects;

public class Team {
    public final String name;
    public final int points;

    public Team(String name, int points) {
        this.name = name;
        this.points = points;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Team)) return false;
        Team team = (Team) o;
        return points == team.points && Objects.equals(name, team.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, points);
    }
}
