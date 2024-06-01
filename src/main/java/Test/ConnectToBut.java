package Test;

import java.util.HashMap;
import java.util.Map;
import Entities.But;
import Entities.Joueur;
import EntitiesCsv.GoalScorers;
import EntitiesData.GoalScorersData;
import Service.HandleData;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class ConnectToBut {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetJpa");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		GoalScorers result = HandleData.getGoalScorers();
		/*
		 * Tableau de Map pour pouvoir enregistrer dans le cash les joueurs et but déjà
		 * enregisté --> améliore la performance
		 */
		Map<String, Joueur> joueurMap = new HashMap<>();
		Map<String, But> butMap = new HashMap<>();

		for (GoalScorersData data : result.getGoalScorersData()) {
			String minuteBut = data.getMinScorer();
			Boolean isPenalty = data.getIsPenalty();
			Boolean isOwnGoal = data.getIsOwnGoal();
			String scorerName = data.getScorer();
			/*
			 * vérifie si un le joueur existe dans le cache
			 */
			Joueur joueur = joueurMap.get(scorerName);
			if (joueur == null) {
				/*
				 * requête qui vérifie si le joueur de la table but corresponds au joueur de la
				 * table joueur
				 */
				TypedQuery<Joueur> query = em.createQuery("SELECT j FROM Joueur j WHERE j.nom = :nom", Joueur.class);
				query.setParameter("nom", scorerName);
				joueur = query.getResultStream().findFirst().orElse(null);
				/*
				 * si un joueur existe, on ajoute l'ajoute en clé et on ajoute le joueur trouvé
				 * en base dans le cache
				 */
				if (joueur != null) {
					joueurMap.put(scorerName, joueur);
				}
			}

			if (joueur != null) {
				/*
				 * vérifie si on a un buteur, s'il n'existe pas on persist les attributs
				 * ci-dessous
				 */
				But but = butMap.get(scorerName);
				if (but == null) {
					but = new But();
					but.setJoueurs(joueur);
					but.setIsOwnGoal(isOwnGoal);
					but.setIsPenalty(isPenalty);
					but.setMinuteButMarque(minuteBut);
					butMap.put(scorerName, but);
					em.persist(but);
					/*
					 * si un but existe déja on lui ajoute son buteur et son pays
					 */
				} else {
					but.setJoueurs(joueur);
				}
			}
		}

		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
