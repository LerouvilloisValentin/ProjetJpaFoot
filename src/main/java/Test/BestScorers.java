package Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import Entities.Joueur;

public class BestScorers {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetJpa");
		EntityManager em = emf.createEntityManager();

		try {
			/*
			 * Créer une requête pour trouver le joueur avec le plus grand nombre de buts
			 */
			TypedQuery<Joueur> query = em.createQuery(
					"SELECT j FROM Joueur j JOIN j.buts b GROUP BY j.id ORDER BY COUNT(b) DESC", Joueur.class

			);

			Joueur bestScorer = query.getResultStream().findFirst().orElse(null);

			if (bestScorer != null) {
				System.out.println("Le meilleur buteur est " + bestScorer.getNom() + " avec "
						+ bestScorer.getButs().size() + " buts.");
			} else {
				System.out.println("Aucun joueur trouvé.");
			}
		} finally {
			em.close();
			emf.close();
		}
	}
}
