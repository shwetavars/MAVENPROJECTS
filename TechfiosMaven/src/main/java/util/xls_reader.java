package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class xls_reader {
	public String path;
	public FileInputStream fis;
	public FileOutputStream fos;
	
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;
	
	public xls_reader(String path) 
	{
		this.path = path;
		
		try
		{
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet= workbook.getSheetAt(0);
			fis.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}
	public String getcellData(String sheetname,String colname,int rownum)
	{
		try
		{
			if(rownum<=0)
				return "";
			int index = workbook.getSheetIndex(sheetname);
			int col_num =-1;
			if(index == -1)
				return "";
			sheet = workbook.getSheetAt(index);
			row=sheet.getRow(0);
			
			for(int i =0;i<row.getLastCellNum();i++)
			{
				if(row.getCell(i).getStringCellValue().trim().equals(colname.trim()))
					col_num =i;
			}
		
			if(col_num == -1)
				return "";
			sheet = workbook.getSheetAt(index);
			row=sheet.getRow(rownum-1);
			if(row==null)
				return "";
			cell = row.getCell(col_num);
			
			if(cell==null)
				return "";
			return cell.getStringCellValue();
	

    }catch(Exception e)
		{
    	e.printStackTrace();
    	return "row" +rownum+" or Column "+colname+" does not exist in xls";
		}
	}
	
}
		
