package Service;

import EntitiesCsv.Result;

public class HandleData {
	public static void main(String[] args) {

		String filePath = ClassLoader.getSystemClassLoader().getResource("results.csv").getFile();
		Result result = ResultUtils.lire(filePath);
		
		System.out.println(result);
		if (result == null) {
			System.out.println("L'application doit s'arrétée en raison d'une erreur d'exécution.");
			System.exit(-1);
		}

	}
}
