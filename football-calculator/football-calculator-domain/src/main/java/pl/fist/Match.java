package pl.fist;

public class Match {
    private final int teamAGoals;
    private final int teamBGoals;
    private final Team a;
    private final Team b;

    public Match(Team a, Team b, int teamAGoals, int teamBGoals) {
        this.a = a;
        this.b = b;
        this.teamAGoals = teamAGoals;
        this.teamBGoals = teamBGoals;
    }

    public boolean hasTeam(Team team) {
        return a.equals(team) || b.equals(team);
    }

    public boolean teamWon(Team team) {
        return (a.equals(team) && teamAGoals > teamBGoals) ||
                (b.equals(team) && teamBGoals > teamAGoals);
    }
}
