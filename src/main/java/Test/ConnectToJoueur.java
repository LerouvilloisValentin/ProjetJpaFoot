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
import jakarta.persistence.TypedQuery;

public class ConnectToJoueur {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetJpa");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        GoalScorers result = HandleData.getGoalScorers();

        Map<String, Joueur> joueurMap = new HashMap<>();
        Map<String, Team> teamMap = new HashMap<>();

        for (GoalScorersData data : result.getGoalScorersData()) {
            String scorerName = data.getScorer();
            String scorerCountry = data.getTeamScorer();

            Team team = teamMap.get(scorerCountry);
            if (team == null) {
                TypedQuery<Team> query = em.createQuery("SELECT t FROM Team t WHERE t.country = :country", Team.class);
                query.setParameter("country", scorerCountry);
                team = query.getResultStream().findFirst().orElse(null);

                if (team != null) {
                    teamMap.put(scorerCountry, team);
                } 
            }

            if (team != null) {
                Joueur joueur = joueurMap.get(scorerName);
                if (joueur == null) {
                    joueur = new Joueur();
                    joueur.setNom(scorerName);
                    joueur.setTeam(team); // Associer l'équipe au joueur
                    joueurMap.put(scorerName, joueur);
                    em.persist(joueur);
                } else {
                    joueur.setTeam(team); 
                }
            }
        }

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}

