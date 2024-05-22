package EntitiesCsv;

import java.util.ArrayList;
import java.util.List;

import EntitiesData.ResultData;

public class Result {

	private List<ResultData> resultData = new ArrayList<>();

	public List<ResultData> getResultData() {
		return resultData;
	}

	public void setResultData(List<ResultData> resultData) {
		this.resultData = resultData;
	}

	@Override
	public String toString() {
		return "Result resultData=" + resultData ;
	}
	
}
