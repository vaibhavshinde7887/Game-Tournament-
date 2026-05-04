package com.Tournament.Tournament.repo;


import com.Tournament.Tournament.model.TournamentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TournamentRepository extends JpaRepository<TournamentModel, Long> {

  // Explicit declaration to ensure findAll() is visible to the compiler
  List<TournamentModel> findAll();

  // Custom finder for status
  List<TournamentModel> findByStatus(String status);

  // Search by title (case-insensitive) — use 'title' because TournamentModel has field 'title'
  List<TournamentModel> findByTitleContainingIgnoreCase(String title);
}
