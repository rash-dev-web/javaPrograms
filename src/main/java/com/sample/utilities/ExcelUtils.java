package com.sample.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class ExcelUtils {

	@Test
	public void writeExcel() {
		writeExcelFile();
	}

	private void writeExcelFile() {

		final Logger log = LoggerFactory.getLogger(ExcelUtils.class.getSimpleName());

		// Create a workbook
		XSSFWorkbook workbook = new XSSFWorkbook();

		// Create a sheet
		XSSFSheet sheet = workbook.createSheet("TestSheet");

		// Create data set
		Map<String, Object[]> data = new TreeMap<String, Object[]>();
		data.put("1", new Object[] { "S.N.", "Test Case Name", "Description" });
		data.put("2", new Object[] { "TC_001", "Valid Login Test", "Test with Valid Credentials" });
		data.put("3", new Object[] { "TC_002", "Invalid Login Test - username", "Test with Invalid username" });
		data.put("4", new Object[] { "TC_003", "Invalid Login Test - password", "Test with Invalid password" });

		// Iterate the data
		Set<String> dataSet = data.keySet();
		int rowNum = 0;
		for (String key : dataSet) {
			Row row = sheet.createRow(rowNum++);
			Object[] dataObj = data.get(key);
			int cellNum = 0;
			for (Object value : dataObj) {
				Cell cell = row.createCell(cellNum++);
				if (value instanceof String)
					cell.setCellValue((String) value);
				else if (value instanceof Integer)
					cell.setCellValue((Integer) value);

			}
		}

		// write file
		try {
			FileOutputStream file = new FileOutputStream("TestExcel.xlsx");
			workbook.write(file);
			workbook.close();
			log.info("Excel file is created.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void readExcelFile() {
		try {
			readExcel();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void readExcel() throws IOException {

		FileInputStream fis = new FileInputStream("TestExcel.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("TestSheet");
		Row row = null;
		Cell cell = null;
		DataFormatter dataFormatter = new DataFormatter();
		String str = null;

		Iterator<Row> iterator = sheet.iterator();
		while (iterator.hasNext()) {
			row = iterator.next();
			Iterator<Cell> cellIterator = row.iterator();
			while (cellIterator.hasNext()) {
				cell = cellIterator.next();
				str = dataFormatter.formatCellValue(cell);
				System.out.println(str);
			}
		}
		workbook.close();
		fis.close();
	}

}
