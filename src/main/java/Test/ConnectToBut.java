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

        Map<String, Joueur> joueurMap = new HashMap<>();
        Map<String, But> butMap = new HashMap<>();

        for (GoalScorersData data : result.getGoalScorersData()) {
            String minuteBut = data.getMinScorer();
            Boolean isPenalty = data.getIsPenalty();
            Boolean isOwnGoal = data.getIsOwnGoal();
            String scorerName = data.getScorer();

            Joueur joueur = joueurMap.get(scorerName);
            if (joueur == null) {
                TypedQuery<Joueur> query = em.createQuery("SELECT j FROM Joueur j WHERE j.nom = :nom", Joueur.class);
                query.setParameter("nom", scorerName);
                joueur = query.getResultStream().findFirst().orElse(null);

                if (joueur != null) {
                    joueurMap.put(scorerName, joueur);
                }
            }

            if (joueur != null) {
                But but = butMap.get(scorerName);
                if (but == null) {
                    but = new But();
                    but.setJoueurs(joueur);
                    but.setIsOwnGoal(isOwnGoal);
                    but.setIsPenalty(isPenalty);
                    but.setMinuteButMarque(minuteBut);
                    butMap.put(scorerName, but);
                    em.persist(but);
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
