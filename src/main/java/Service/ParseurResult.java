package Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import EntitiesCsv.Result;
import EntitiesData.ResultData;

public class ParseurResult {

	public static void ajoutLigne(Result result, String ligne) {
		/*
		 * Permet de diviser les sous chaine (morceaux) en utilisant une virgule
		 */
		String[] morceaux = ligne.split(",");
		/*
		 * assure du bon format de date et parse le localDate en type String
		 */
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dateMatch = LocalDate.parse(morceaux[0], formatter);
		String homeTeam = morceaux[1];
		String AwayTeam = morceaux[2];
		String homeScore = morceaux[3];
		String awayScore = morceaux[4];
		String tournament = morceaux[5];
		String city = morceaux[6];
		String country = morceaux[7];
		Boolean neutral = Boolean.parseBoolean(morceaux[8]);
		/*
		 * stock les donnée dans un objet de type GoalScorersData
		 */
		ResultData data = new ResultData(dateMatch, homeTeam, AwayTeam, homeScore, awayScore, tournament, city, country,
				neutral);
		/*
		 * ajoute ces données dans une liste d'objet de type GoalScorers
		 */
		result.getResultData().add(data);
//		System.out.println(city);
	}
}
