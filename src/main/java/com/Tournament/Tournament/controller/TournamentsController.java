package com.Tournament.Tournament.controller;

import com.Tournament.Tournament.model.TournamentModel;
import com.Tournament.Tournament.service.TournamentsService;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tournaments")
public class TournamentsController {

  private final TournamentsService tournamentsService;

  public TournamentsController(TournamentsService tournamentsService) {
    this.tournamentsService = tournamentsService;
  }

  @GetMapping
  public List<TournamentModel> getAllTournaments() {
    return tournamentsService.getAllTournaments();
  }

  @GetMapping("/{id}")
  public ResponseEntity<TournamentModel> getTournamentById(@PathVariable Long id) {
    Optional<TournamentModel> tournament = tournamentsService.getTournamentById(id);
    if (tournament.isPresent()) {
      return ResponseEntity.ok(tournament.get());
    }
    return ResponseEntity.notFound().build();
  }

  @GetMapping("/status/{status}")
  public List<TournamentModel> getTournamentsByStatus(@PathVariable String status) {
    return tournamentsService.getTournamentsByStatus(status);
  }


  @GetMapping("/search")
  public List<TournamentModel> searchTournaments(@RequestParam String query) {
    return tournamentsService.searchTournaments(query);
  }



  @PostMapping
  public TournamentModel createTournament(@RequestBody TournamentModel tournamentModel) {
    return tournamentsService.createTournament(tournamentModel);
  }
}
