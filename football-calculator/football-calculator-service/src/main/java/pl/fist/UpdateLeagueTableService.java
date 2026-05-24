package pl.fist;

import java.util.List;
import java.util.stream.Collectors;

public class UpdateLeagueTableService {
    private final TeamRepository teamRepository;
    private final MatchRepository matchRepository;

    public UpdateLeagueTableService(TeamRepository teamRepository,
                                    MatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }

    public List<Team> calculate() {
        List<Match> matches = matchRepository.findAll();
        List<Team> collect = teamRepository.findAll().stream()
                .peek(team -> matches.forEach(match -> {
                    if (match.hasTeam(team)) {
                        if (match.teamWon(team)) {
                            team.winMatch();
                        }
                    }
                }))
                .collect(Collectors.toList());
        return collect;
    }
}
