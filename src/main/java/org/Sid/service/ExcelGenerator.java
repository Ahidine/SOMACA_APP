package org.Sid.service;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.Sid.entities.MyTable;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 


public class ExcelGenerator {
	public static ByteArrayInputStream customersToExcel(List<MyTable> MyTable) throws IOException {
	    String[] COLUMNs = {"Id", "departement", "equipement", "sous_equipement","designation","reference","etat_PDR","code_mabic","mode_gestionnaire","Type_PDR"};
	    try(
	        Workbook workbook = new XSSFWorkbook();
	        ByteArrayOutputStream out = new ByteArrayOutputStream();
	    ){
	      CreationHelper createHelper = workbook.getCreationHelper();
	   
	      Sheet sheet = workbook.createSheet("MyTable");
	   
	      Font headerFont = workbook.createFont();
	      headerFont.setBold(true);
	      headerFont.setColor(IndexedColors.BLUE.getIndex());
	   
	      CellStyle headerCellStyle = workbook.createCellStyle();
	      headerCellStyle.setFont(headerFont);
	 
	   
	      // Row for Header
	      sheet.setDefaultColumnWidth(20);
	      Row headerRow = sheet.createRow(0);
	   
	      // Header
	      for (int col = 0; col < COLUMNs.length; col++) {
	        Cell cell = headerRow.createCell(col);
	        cell.setCellValue(COLUMNs[col]);
	        cell.setCellStyle(headerCellStyle);
	      }
	   
	      // CellStyle for Age
	      CellStyle ageCellStyle = workbook.createCellStyle();
	      ageCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("#"));
	   
	      int rowIdx = 1;
	      for (MyTable mytable : MyTable) {
	        Row row = sheet.createRow(rowIdx++);
	   
	        row.createCell(0).setCellValue(mytable.getId());
	        row.createCell(1).setCellValue(mytable.getDepartement());
	        row.createCell(2).setCellValue(mytable.getEquipement());
	        row.createCell(3).setCellValue(mytable.getSous_equipement());
	        row.createCell(4).setCellValue(mytable.getDesignation());
	        row.createCell(5).setCellValue(mytable.getReference());
	        row.createCell(6).setCellValue(mytable.getEtat_PDR());
	        row.createCell(7).setCellValue(mytable.getCode_mabic());
	        row.createCell(8).setCellValue(mytable.getMode_gestionnaire());
	        row.createCell(9).setCellValue(mytable.getType_PDR());

	      }
	   
	      workbook.write(out);
	      return new ByteArrayInputStream(out.toByteArray());
	    }
	  }
	public static List<MyTable> parseExcelFile(InputStream is) {
		try {
    		Workbook workbook = new XSSFWorkbook(is);
     
    		Sheet sheet = workbook.getSheet("MyTable");
    		Iterator<Row> rows = sheet.iterator();
    		
    		List<MyTable> lstCustomers = new ArrayList<MyTable>();
    		
    		int rowNumber = 0;
    		while (rows.hasNext()) {
    			Row currentRow = rows.next();
    			
    			// skip header
    			if(rowNumber == 0) {
    				rowNumber++;
    				continue;
    			}
    			
    			Iterator<Cell> cellsInRow = currentRow.iterator();

    			MyTable cust = new MyTable();
    			
    			int cellIndex = 0;
    			while (cellsInRow.hasNext()) {
    				Cell currentCell = cellsInRow.next();
    				
    				if(cellIndex==0) { // ID
    					System.out.println("here :"+currentCell.getNumericCellValue());
    					cust.setId((long) currentCell.getNumericCellValue());
    				} else if(cellIndex==1) { // 
    					cust.setDepartement((currentCell.getStringCellValue()));
    					System.out.println("here :"+currentCell.getStringCellValue());
    				} else if(cellIndex==2) { // 
    					System.out.println("here :"+currentCell.getStringCellValue());
    					cust.setEquipement(currentCell.getStringCellValue());
    				} else if(cellIndex==3) { // 
    					System.out.println("here :"+currentCell.getStringCellValue());
    					cust.setSous_equipement(currentCell.getStringCellValue());
    				}else if(cellIndex==4) { // 
    					System.out.println("here :"+currentCell.getStringCellValue());
    					cust.setDesignation(currentCell.getStringCellValue());
    				}else if(cellIndex==5) { // 
    					System.out.println("here :"+currentCell.getStringCellValue());
    					cust.setReference(currentCell.getStringCellValue());
    				}else if(cellIndex==7) { // 
    					System.out.println("here :"+currentCell.getStringCellValue());
    					cust.setCode_mabic(currentCell.getStringCellValue());
    				}
    				else if(cellIndex==8) { // 
    					System.out.println("here :"+currentCell.getStringCellValue());
    					cust.setMode_gestionnaire(currentCell.getStringCellValue());
    				}
    				else if(cellIndex==9) { // 
    					System.out.println("here :"+currentCell.getStringCellValue());
    					cust.setType_PDR(currentCell.getStringCellValue());
    				}
    				else if(cellIndex==6) { // 
    					System.out.println("here :"+currentCell.getStringCellValue());
    					cust.setEtat_PDR(currentCell.getStringCellValue());
    				}
    				cellIndex++;
    			}

    			lstCustomers.add(cust);
    		}
    		
    		// Close WorkBook
    		workbook.close();
    		
    		return lstCustomers;
        } catch (IOException e) {
        	throw new RuntimeException("FAIL! -> message = " + e.getMessage());
        }
	}

}
