package pl.fist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class LeagueTableCalculatorTest {

    @Test
    void shouldNotChangeTeamPointsWhenThereWereNoGamesPlayed() {
        //given
        TeamRepository teamRepository = mock(TeamRepository.class);
        MatchRepository matchRepository = mock(MatchRepository.class);

        List<Team> teams = List.of(new Team("FC club", 0),
                new Team("Club 2", 3));

        when(teamRepository.findAll()).thenReturn(teams);

        when(matchRepository.findAll()).thenReturn(List.of());
        UpdateLeagueTableService service = new UpdateLeagueTableService(teamRepository,
                matchRepository);

        //when
        List<Team> result = service.calculate();

        //then
        assertEquals(2, result.size());
        assertEquals(new HashSet<>(teams), new HashSet<>(result));
    }
}
