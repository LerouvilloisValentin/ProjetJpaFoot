package Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import Entities.Joueur;
import Entities.Team;
import Entities.Tournoi;
import EntitiesCsv.Result;
import EntitiesData.ResultData;
import Service.HandleData;
import Service.ResultUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnectToTeam {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetJpa");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Result result = HandleData.getResult();
		Map<String, Team> teamMap = new HashMap<>();

		for (ResultData data : result.getResultData()) {
			String country = data.getCountry();

			Team currentCountry;

			/*
			 * ajoute COUNTRY à TEAM
			 */
			if (teamMap.containsKey(country)) {
				currentCountry = teamMap.get(country);
			} else {
				currentCountry = new Team();
				currentCountry.setCountry(country);
				teamMap.put(country, currentCountry);
				em.persist(currentCountry);
			}

			// Vous pouvez ajouter d'autres opérations sur currentTournament ici si
			// nécessaire
		}

		em.getTransaction().commit();

		em.close();
		emf.close();
	}
}
