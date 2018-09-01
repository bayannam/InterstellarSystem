/**********************************************************************************************************************
 **    Copyright 2015 DISCOVERY.  All rights reserved.
 **
 **    No Part of this file should be copied or distributed without the permission of DISCOVERY.
 **    Application        :    InterstellarSystem
 **    Module             :    DataAccess-JAR
 **    Version            :    1.0
 **    File               :    UploadPlanetXLSX.java
 **    Description        :    The UploadPlanetXLSX which  implements an
 **                            application that simply uploads planet data to database from XLSX file
 **    Author             :    Bayanna Madanapalli
 **    Created Date       :    17/12/2015
 **********************************************************************************************************************
 **    Change History Header:
 **********************************************************************************************************************
 **    Date          Author                 Version     Description:
 **    -------       --------               --------    ------------
 **    17/12/2015    Bayanna Madanapalli      1.0         Created
 *********************************************************************************************************************/

package za.co.discovery.assignment.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
import org.hibernate.Transaction;

import za.co.discovery.assignment.dao.AbstractDao;
import za.co.discovery.assignment.entity.Planet;

/**
 * <h1>UploadPlanetXLSX</h1> The UploadPlanetXLSX program implements an
 * application that simply uploads planet data to database from XLSX file
 * <p>
 * 
 * 
 *
 * @author Bayanna Madanapalli
 * @version 1.0
 * @since 2015-12-15
 */

public class UploadPlanetXLSX extends AbstractDao<Serializable, Planet> {

	public void uploadFile() {
		try {
			FileInputStream file = new FileInputStream(
					new File(
							"C://Users//Bayanna Madanapalli//Downloads//assignment.xlsx"));

			Planet planet = new Planet();
			// Route route = new Route();
			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();
				int rowIndex = 0;

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					int columnIndex = cell.getColumnIndex();

					rowIndex = cell.getRowIndex();

					switch (columnIndex) {
					case 0:
						// System.out.print(cell.getStringCellValue() + "  ");
						if (rowIndex != 0) {
							planet.setPlanetNode(cell.getStringCellValue());
							// route.setPlaneOrigin(cell.getStringCellValue());
						}
						break;
					case 1:
						// System.out.print(cell.getStringCellValue() + "  ");
						if (rowIndex != 0) {
							planet.setPlanetName(cell.getStringCellValue());
							// route.setPlanetDestination(cell
							// .getStringCellValue());
						}
						break;
					/*
					 * case 3: // System.out.print(cell.getNumericCellValue() +
					 * "  "); if (rowIndex != 0) { //
					 * planet.setPlanetName(cell.getStringCellValue());
					 * System.out.print(cell.getNumericCellValue() + "  ");
					 * route.setDistance(cell.getNumericCellValue()); } break;
					 */

					}
				}
				// System.out.println("");

				Session session = getSession();
				Transaction txn = session.beginTransaction();
				if (rowIndex != 0) {
					session.save(planet);
					txn.commit();
					;
					// session.save(route);
				}

			}
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
