package com.Tournament.Tournament.service;


import com.Tournament.Tournament.model.TournamentModel;
import com.Tournament.Tournament.repo.TournamentRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class TournamentsService {

  private final TournamentRepository tournamentRepository;

  public TournamentsService(TournamentRepository tournamentRepository) {
    this.tournamentRepository = tournamentRepository;
  }

  public List<TournamentModel> getAllTournaments() {
    return tournamentRepository.findAll();
  }

  public Optional<TournamentModel> getTournamentById(Long id) {
    return tournamentRepository.findById(id);
  }

  public List<TournamentModel> getTournamentsByStatus(String status) {
    return tournamentRepository.findByStatus(status);
  }

  public List<TournamentModel> searchTournaments(String query) {
    return tournamentRepository.findByTitleContainingIgnoreCase(query);
  }

  public TournamentModel createTournament(TournamentModel tournamentModel) {
    return tournamentRepository.save(tournamentModel);
  }

}
