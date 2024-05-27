package Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import Entities.Tournoi;
import EntitiesCsv.Result;
import EntitiesData.ResultData;
import Service.ResultUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TestConnexion {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetJpa");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		String filePath = ClassLoader.getSystemClassLoader().getResource("results.csv").getFile();
		Result result = ResultUtils.lire(filePath);

		Map<String, Tournoi> tournoi = new HashMap<>();
//		Tournoi currentTournament;

		for (ResultData data : result.getResultData()) {
			String country = data.getCountry();
//			if (tournoi.containsKey(country)) {
//				currentTournament = tournoi.get(country);
//			} else {
				Tournoi currentTournament = new Tournoi();
				currentTournament.setNomTournoi(country);
//				tournoi.set(country, currentTournament);
				em.persist(currentTournament);
//			}

//			for (Map.Entry<String, Tournoi> entry : tournoi.entrySet()) {
//			}
		}
		em.getTransaction().commit();

		em.close();
		emf.close();
	}
}
