package pl.fist;

import java.util.Objects;

public class Team {
    public final String name;
    public int points;

    public Team(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public void winMatch() {
        this.points += 3;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Team)) return false;
        Team team = (Team) o;
        return Objects.equals(name, team.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
