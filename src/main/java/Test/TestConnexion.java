package Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

//import Entities.Match;
//import Entities.Team;
import Entities.Tournoi;
import EntitiesCsv.GoalScorers;
import EntitiesCsv.Result;
import EntitiesData.ResultData;
import Service.EntityUtils;
import Service.HandleData;
import Service.ResultUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TestConnexion {
	public static void main(String[] args) {
		/*
		 * Connexion à jpa avec le persistenceXml configuré pour le ProjetJpa
		 */
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetJpa");
		EntityManager em = emf.createEntityManager();
		/*
		 * Lancement de la transaction/requête vers la base de donnée et récupération du
		 * fichier resultCsv dans un tableau avec les méthodes (ResultUtils) pour que
		 * les données puisse être insérer dans un objet
		 */
		em.getTransaction().begin();
		String filePath = ClassLoader.getSystemClassLoader().getResource("results.csv").getFile();
		Result result = ResultUtils.lire(filePath);
		
		Map<String, Tournoi> tournoi= new HashMap<>();
		Tournoi currentTournament;
		/*
		 * Map des données pour récupérer chaque colonne du fichiers
		 */

		for (ResultData data : result.getResultData()) {
			// Accéder aux attributs individuels
			LocalDate dateMatch = data.getDate();
			String city = data.getCity();
			Boolean neutral = data.getNeutral();
			String homeScore = data.getHomeScore();
			String awayScore = data.getAwayScore();
			String homeTeam = data.getHomeTeam();
			String awayTeam = data.getAwayTeam();
			String tournament = data.getTournament();
			String country = data.getCountry();
		
//            // Trouver ou créer les entités associées
//            Team homeTeam = EntityUtils.findOrCreateTeam(em, homeTeamName);
//            Team awayTeam = EntityUtils.findOrCreateTeam(em, awayTeamName);
//            Tournoi tournoi = EntityUtils.findOrCreateTournoi(em, tournamentName);
			
			
			   if (tournoi.containsKey(country)) {
			        currentTournament = tournoi.get(country);
			    } else {
			        currentTournament = new Tournoi(country);
			        tournoi.put(country, currentTournament);
			    }
			
			for (Map.Entry<String, Tournoi> entry : tournoi.entrySet()) {
				em.persist(entry.getValue());
			}
			// Construire l'entité à persister
//			Match matchData = new Match(dateMatch, city, neutral, homeScore, awayScore);
//			Tournoi tournoiData = new  Tournoi(currentCountry);
//			em.persist(matchData);
//            System.out.println(matchData.getCity());
		}
//		GoalScorers goalScorers = HandleData.getGoalScorers();
//		System.out.println("GoalScorers: " + goalScorers);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
