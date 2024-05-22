package Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import EntitiesCsv.GoalScorers;
import EntitiesData.GoalScorersData;


public class ParseurGoalScorers {

	public static void ajoutLigne(GoalScorers goalScorers, String ligne) {
		String[] morceaux = ligne.split(",");

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    LocalDate date = LocalDate.parse(morceaux[0], formatter);
		String homeTeam = morceaux[1];
		String awayTeam = morceaux[2];
		String teamScorer = morceaux[3];
		String minScorer = morceaux[4];
		int minScorerInt = Integer.parseInt(minScorer);
		Boolean isOwnGoal = Boolean.parseBoolean(morceaux[5]);
		Boolean isPenalty = Boolean.parseBoolean(morceaux[6]);
		
		System.out.println("test");
		System.out.println(minScorer);
		GoalScorersData data = new GoalScorersData(date, homeTeam, awayTeam,teamScorer,
				minScorerInt,isOwnGoal,isPenalty);
		
		goalScorers.getGoalScorersData().add(data);
	}
}
