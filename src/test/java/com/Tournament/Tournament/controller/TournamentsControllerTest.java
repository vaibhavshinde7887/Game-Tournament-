package com.Tournament.Tournament.controller;

import com.Tournament.Tournament.model.TournamentModel;
import com.Tournament.Tournament.service.TournamentsService;
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
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TournamentsControllerTest {

  @Mock
  private TournamentsService tournamentsService;

  private TournamentsController controller;

  @BeforeEach
  void setUp() {
    controller = new TournamentsController(tournamentsService);
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
    when(tournamentsService.getAllTournaments()).thenReturn(List.of(a, b));

    List<TournamentModel> result = controller.getAllTournaments();

    assertThat(result).hasSize(2).containsExactly(a, b);
  }


  @Test
  void getTournamentById_notFound_returns404() {
    when(tournamentsService.getTournamentById(anyLong())).thenReturn(Optional.empty());

    var response = controller.getTournamentById(99L);
    assertThat(response.getBody()).isNull();
  }
}
