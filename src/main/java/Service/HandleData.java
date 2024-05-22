package Service;

import EntitiesCsv.GoalScorers;
import EntitiesCsv.Result;

public class HandleData {
	public static void main(String[] args) {

//		String filePath = ClassLoader.getSystemClassLoader().getResource("results.csv").getFile();
//		Result result = ResultUtils.lire(filePath);
//		
////		System.out.println(result);
//		if (result == null) {
//			System.out.println("L'application doit s'arrétée en raison d'une erreur d'exécution.");
//			System.exit(-1);
//		}
		
		String filePath2 = ClassLoader.getSystemClassLoader().getResource("goalscorers.csv").getFile();
		GoalScorers result2 = GoalScorersUtils.lire(filePath2);
		
		System.out.println(result2);
//		if (result2 == null) {
//			System.out.println("L'application doit s'arrétée en raison d'une erreur d'exécution.");
//			System.exit(-1);
//		}

	}
}
