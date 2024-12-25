package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dataproviderclass {
	
	//dataprovider 1
	
	
	@DataProvider(name="excel")
	public String[][] Data() throws IOException
	{
		//String path=".\\testData\\Excel_Testdata_DDT.xlsx";
		Excelutility eu=new Excelutility(".\\testData\\Excel_Testdata_DDT.xlsx");
		int rows=eu.getrowcount("Sheet1");
		int coloumns=eu.getcellcount("Sheet1", 1);
		
		String data[][]=new String[rows][coloumns];
		
		for(int r=1;r<=rows;r++)
		{
			for(int c=0;c<coloumns;c++)
			{
				data[r-1][c]=eu.getcelldata("Sheet1", r, c);
			}
		}
		return data;
		
	}
	
	
	

}
