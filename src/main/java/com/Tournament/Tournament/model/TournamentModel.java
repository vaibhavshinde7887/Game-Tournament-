package com.Tournament.Tournament.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tournaments")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TournamentModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String title;

  @Column(name = "game_name", nullable = false)
  private String gameName;

  @Column(nullable = false)
  private LocalDate date;

  @Column(name = "prize_pool", nullable = false)
  private BigDecimal prizePool;

  @Column(nullable = false)
  private String status; // "Upcoming" or "Completed"

  @Column(columnDefinition = "TEXT")
  private String description;

  public void setId(Long id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setGameName(String gameName) {
    this.gameName = gameName;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public void setPrizePool(BigDecimal prizePool) {
    this.prizePool = prizePool;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
