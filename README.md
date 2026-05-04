🎮 Gaming Tournament Platform Backend

This repository contains the backend service for a Gaming Tournament Platform. It is built using Spring Boot and integrates with a PostgreSQL database to manage and store tournament-related data.

🚀 Features
Tournament Management

Create, store, and retrieve tournament information efficiently.
Filtering
Fetch tournaments based on their status (e.g., Upcoming, Ended).
Search Functionality
Search tournaments by title or game name for quick access.f
Database Initialization
Automatically populates the database with sample tournament data if it is empty.


🛠 Tech Stack
Backend: Spring Boot (Java)
Database: PostgreSQL


🔗 API Endpoints
GET /tournaments
GET /tournaments/{id}
GET /tournaments/status/{status}
GET /tournaments/search?query={query}
POST /tournaments

smample json 
{
  "title": "BGMI Championship",
  "gameName": "BGMI",
  "date": "2026-06-10",
  "prizePool": 50000,
  "status": "Upcoming",
  "description": "Top players battle for glory"
}
