package Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import EntitiesCsv.Result;
import EntitiesData.ResultData;


public class ParseurResult {

	public static void ajoutLigne(Result result, String ligne) {
		String[] morceaux = ligne.split(",");

		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    LocalDate dateMatch = LocalDate.parse(morceaux[0], formatter);
		String homeTeam = morceaux[1];
		String AwayTeam = morceaux[2];
		String homeScore = morceaux[3];
		int homeScoreInt = Integer.parseInt(homeScore);
		String AwayScore = morceaux[4];
		int awayScoreInt = Integer.parseInt(AwayScore);
		String tournament = morceaux[5];
		String city = morceaux[6];
		String country = morceaux[7];
		Boolean neutral = Boolean.parseBoolean(morceaux[8]);
		
		ResultData data = new ResultData(dateMatch, homeTeam, AwayTeam,homeScoreInt,
				awayScoreInt,tournament,city,country, neutral);
		
		result.getResultData().add(data);
//		System.out.println(city);
	}
}
