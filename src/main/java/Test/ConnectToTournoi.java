package Test;

import java.util.HashMap;
import java.util.Map;
import Entities.Tournoi;
import EntitiesCsv.Result;
import EntitiesData.ResultData;
import Service.HandleData;
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
			String tournament = data.getTournament();
			Tournoi currentTournament;

			/*
			 * ajoute Nom_Tournoi à TOURNOI
			 */
			if (tournoiMap.containsKey(tournament)) {
				currentTournament = tournoiMap.get(tournament);
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
