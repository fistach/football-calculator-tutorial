package pl.fist;

import java.util.List;

public class UpdateLeagueTableService {
    private final TeamRepository teamRepository;
    private final MatchRepository matchRepository;

    public UpdateLeagueTableService(TeamRepository teamRepository,
                                    MatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }

    public List<Team> calculate() {
        matchRepository.findAll();
        return teamRepository.findAll();
    }
}
