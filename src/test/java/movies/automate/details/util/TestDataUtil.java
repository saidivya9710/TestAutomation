package movies.automate.details.util;

import java.util.ArrayList;

public class TestDataUtil {
	static ExcelUtility reader;
	public static ArrayList <Object[]> getDataFromExcel() {
	ArrayList <Object[]> myData = new ArrayList <Object[]>();
	try {
		reader = new ExcelUtility("C:/Users/s sai divya/Documents/testvagrant/movies/src/test/java/movies/automate/details/testdata/moviestestdata.xlsx");
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	for(int rowNum = 2; rowNum<=reader.getRowCount("testdata");rowNum++) {
		
		String movieName = reader.getCellData("testdata","moviename",rowNum);
		Object obj[]= {movieName};
				myData.add(obj)	;
		}
	
	
	return myData;
	
	}	
}
