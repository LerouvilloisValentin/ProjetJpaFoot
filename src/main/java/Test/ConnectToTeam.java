package Test;

import java.util.HashMap;
import java.util.Map;
import Entities.Team;
import EntitiesCsv.Result;
import EntitiesData.ResultData;
import Service.HandleData;
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
			if (!teamMap.containsKey(country)) {
				currentCountry = new Team();
				currentCountry.setCountry(country);
				/*
				 * insert dans le cache le pays
				 */
				teamMap.put(country, currentCountry);
				em.persist(currentCountry);
			} else {
				/*
				 * vérifie si le pays existe dans le cash et le récuppère
				 */
				currentCountry = teamMap.get(country);
			}
		}

		em.getTransaction().commit();

		em.close();
		emf.close();
	}
}
