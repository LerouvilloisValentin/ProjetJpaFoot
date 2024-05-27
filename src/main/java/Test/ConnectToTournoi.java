package Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import Entities.Joueur;
import Entities.Team;
import Entities.Tournoi;
import EntitiesCsv.GoalScorers;
import EntitiesCsv.Result;
import EntitiesData.ResultData;
import Service.HandleData;
import Service.ResultUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnectToTournoi {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetJpa");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		
        Result result = HandleData.getResult();
		Map<String, Tournoi> tournoiMap = new HashMap<>();

		for (ResultData data : result.getResultData()) {
			String country = data.getCountry();
			LocalDate dateMatch= data.getDate();
			String homeTeam= data.getHomeTeam();
			String awayTeam= data.getAwayTeam();
			String homeScore= data.getHomeScore();
			String awayScore= data.getAwayScore();
			String tournament = data.getTournament();
			String city = data.getCity();
			Boolean neutral = data.getNeutral();
						
			Tournoi currentTournament;
			Team currentCountry;
			Joueur namePlayer;
			
			/*
			 * ajoute Nom_Tournoi à TOURNOI
			 */
			if (tournoiMap.containsKey(tournament)) {
				currentTournament= tournoiMap.get(tournament);
			} else {
				currentTournament = new Tournoi();
				currentTournament.setNomTournoi(tournament);
				tournoiMap.put(tournament, currentTournament);
				em.persist(currentTournament);
			}

		}
		
		em.getTransaction().commit();

		em.close();
		emf.close();
	}

}
