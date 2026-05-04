package com.Tournament.Tournament.service;

import com.Tournament.Tournament.model.TournamentModel;
import com.Tournament.Tournament.repo.TournamentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TournamentServiceTest {

  @Mock
  private TournamentRepository tournamentRepository;

  private TournamentsService tournamentService;

  @BeforeEach
  void setUp() {
    tournamentService = new TournamentsService(tournamentRepository);
  }

  private TournamentModel sample(long id, String title) {
    TournamentModel t = new TournamentModel();
    t.setId(id);
    t.setTitle(title);
    t.setGameName("TestGame");
    t.setDate(LocalDate.of(2026,1,1));
    t.setPrizePool(BigDecimal.valueOf(1000));
    t.setStatus("Upcoming");
    t.setDescription("desc");
    return t;
  }

  @Test
  void getAllTournaments_returnsList() {
    var a = sample(1, "A");
    var b = sample(2, "B");
    when(tournamentRepository.findAll()).thenReturn(List.of(a, b));

    List<TournamentModel> result = tournamentService.getAllTournaments();

    assertThat(result).hasSize(2).containsExactly(a, b);
    verify(tournamentRepository, times(1)).findAll();
  }

  @Test
  void getTournamentById_found() {
    var a = sample(1, "A");
    when(tournamentRepository.findById(1L)).thenReturn(Optional.of(a));

    Optional<TournamentModel> result = tournamentService.getTournamentById(1L);

    assertThat(result).isPresent().contains(a);
    verify(tournamentRepository).findById(1L);
  }

  @Test
  void getTournamentById_notFound() {
    when(tournamentRepository.findById(99L)).thenReturn(Optional.empty());

    Optional<TournamentModel> result = tournamentService.getTournamentById(99L);

    assertThat(result).isNotPresent();
    verify(tournamentRepository).findById(99L);
  }

  @Test
  void searchTournaments_delegatesToRepository() {
    var a = sample(1, "SearchMe");
    when(tournamentRepository.findByTitleContainingIgnoreCase("search"))
        .thenReturn(List.of(a));

    List<TournamentModel> result = tournamentService.searchTournaments("search");

    assertThat(result).hasSize(1).contains(a);
    verify(tournamentRepository).findByTitleContainingIgnoreCase("search");
  }

  @Test
  void createTournament_savesAndReturns() {
    var a = sample(0, "New");
    var saved = sample(5, "New");
    when(tournamentRepository.save(a)).thenReturn(saved);

    TournamentModel result = tournamentService.createTournament(a);

    assertThat(result.getId()).isEqualTo(5L);
    verify(tournamentRepository).save(a);
  }
}
