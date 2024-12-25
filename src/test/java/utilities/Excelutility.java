package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutility {


	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook w;
	public XSSFSheet s;
	public XSSFRow r;
	public XSSFCell c;
	String path;
	
	public Excelutility(String path)
	{
		this.path=path;
	}
	
	
	public int getrowcount(String sheet) throws IOException
	{
		fi=new FileInputStream(path);
		w=new XSSFWorkbook(fi);
		s=w.getSheet(sheet);
		int rowcount=s.getLastRowNum();
		w.close();
		fi.close();
		return rowcount;		
	}
	
	public int getcellcount(String sheet,int row) throws IOException
	{
		fi=new FileInputStream(path);
		w=new XSSFWorkbook(fi);
		s=w.getSheet(sheet);
		r=s.getRow(row);
		int cellvalue=r.getLastCellNum();
		w.close();
		fi.close();
		return cellvalue;
	}
	
	public String getcelldata(String sheet,int row,int col) throws IOException
	{
		fi=new FileInputStream(path);
		w=new XSSFWorkbook(fi);
		s=w.getSheet(sheet);
		r=s.getRow(row);
		String data=r.getCell(col).toString();
		
//		DataFormatter formatter=new DataFormatter();
//		String data;
//		
//		try
//		{
//			data=formatter.formatCellValue(c);
//		}
//		catch(Exception e)
//		{
//			data="";
//		}
		w.close();
		fi.close();
		return data;
		
	}
	
}
