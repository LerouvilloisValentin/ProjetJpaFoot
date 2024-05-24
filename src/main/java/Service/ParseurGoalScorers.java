package Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import EntitiesCsv.GoalScorers;
import EntitiesData.GoalScorersData;

public class ParseurGoalScorers {

	public static void ajoutLigne(GoalScorers goalScorers, String ligne) {
		/*
		 * Permet de diviser les sous chaine (morceaux) en utilisant une virgule
		 */
		String[] morceaux = ligne.split(",");
		/*
		 * assure du bon format de date et parse le localDate en type String
		 */
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(morceaux[0], formatter);
		String homeTeam = morceaux[1];
		String awayTeam = morceaux[2];
		String teamScorer = morceaux[3];
		String scorer = morceaux[4];
		String minScorer = morceaux[5];
		Boolean isOwnGoal = Boolean.parseBoolean(morceaux[6]);
		Boolean isPenalty = Boolean.parseBoolean(morceaux[7]);
		/*
		 * stock les donnée dans un objet de type GoalScorersData
		 */
		GoalScorersData data = new GoalScorersData(date, homeTeam, awayTeam, teamScorer, scorer, minScorer, isOwnGoal,
				isPenalty);
		/*
		 * ajoute ces données dans une liste d'objet de type GoalScorers
		 */
		goalScorers.getGoalScorersData().add(data);
	}
}
