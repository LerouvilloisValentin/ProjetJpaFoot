package Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import Entities.Joueur;
import Entities.Team;
import EntitiesCsv.GoalScorers;
import EntitiesData.GoalScorersData;
import Service.HandleData;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnectToJoueur {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetJpa");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		GoalScorers result = HandleData.getGoalScorers();

		Map<String, Joueur> joueurMap = new HashMap<>();
//		Map<String, Team> teamMap = new HashMap<>();

		Joueur currentScorerName;
		Joueur currentTeam;

		for (GoalScorersData data : result.getGoalScorersData()) {
			LocalDate dateMatch = data.getDate();
			String homeTeam = data.getHomeTeam();
			String awayTeam = data.getAwayTeam();
			String scorerName = data.getScorer();
			String scorerCountry = data.getTeamScorer();
			/*
			 * ajoute Nom_Tournoi à TOURNOI
			 */
//			if (joueurMap.containsKey(scorerName)) {
//				currentScorerName= joueurMap.get(scorerName);
//			} else {
//				currentScorerName = new Joueur();
//				currentScorerName.setNom(scorerName);
//				joueurMap.put(scorerName, currentScorerName);
//				em.persist(currentScorerName);
//			}

//			if (joueurMap.containsKey(scorerCountry)) {
//				currentTeam = joueurMap.get(scorerCountry);
//			} else {
//				currentTeam = new Joueur();
//				currentTeam.setTeam(scorerCountry);
//				joueurMap.put(scorerCountry, currentTeam);
//				em.persist(currentTeam);
//			}

		}

		em.getTransaction().commit();

		em.close();
		emf.close();

	}

}
