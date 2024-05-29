package Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import Entities.Match;
import Entities.Tournoi;
import EntitiesCsv.Result;
import EntitiesData.ResultData;
import Service.HandleData;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class ConnectToMatch {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetJpa");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		Result result = HandleData.getResult();

		Map<String, Tournoi> tournoiMap = new HashMap<>();
		Map<String, Match> matchMap = new HashMap<>();

		for (ResultData data : result.getResultData()) {
			LocalDate dateMatch = data.getDate();
			String city = data.getCity();
			Boolean neutral = data.getNeutral();
			String homeScore = data.getHomeScore();
			String awayScore = data.getAwayScore();
//			Team homeTeam = data.getHomeTeam();
			String awayTeam = data.getAwayTeam();
			String tournament = data.getTournament();

			Tournoi tournoi = tournoiMap.get(tournament);
			if (tournoi == null) {
				TypedQuery<Tournoi> query = em.createQuery("SELECT t from Tournoi t WHERE t.nomTournoi=:nomTournoi",
						Tournoi.class);
				query.setParameter("nomTournoi", tournament);
				tournoi = query.getResultStream().findFirst().orElse(null);

				if (tournoi != null) {
					tournoiMap.put(tournament, tournoi);
				}
			}
			if (tournoi != null) {
				Match match = matchMap.get(tournament);
				if (match == null) {
					match = new Match();
					match.setDateMatch(dateMatch);
					match.setCity(city);
					match.setNeutral(neutral);
					match.setHomeScore(homeScore);
					match.setAwayScore(awayScore);
					match.setTournoi(tournoi);
					em.persist(match);
				} else {
					match.setTournoi(tournoi);
				}
			}

		}
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
