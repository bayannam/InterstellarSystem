/**********************************************************************************************************************
 **    Copyright 2015 DISCOVERY.  All rights reserved.
 **
 **    No Part of this file should be copied or distributed without the permission of DISCOVERY.
 **    Application        :    InterstellarSystem
 **    Module             :    DataAccess-JAR
 **    Version            :    1.0
 **    File               :    UploadRouteXLSX.java
 **    Description        :    The UploadRouteXLSX which  implements an
 **                            application that simply uploads route data to database from XLSX file
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

import co.discovery.assignment.entity.helper.RoutePojo;
import za.co.discovery.assignment.dao.AbstractDao;
import za.co.discovery.assignment.entity.Route;

/**
 * <h1>UploadRouteXLSX</h1> The UploadRouteXLSX program implements an
 * application that simply uploads route data to database from XLSX file
 * <p>
 * 
 * 
 *
 * @author Bayanna Madanapalli
 * @version 1.0
 * @since 2015-12-15
 */
public class UploadRouteXLSX extends AbstractDao<Serializable, Route> {

	public void uploadFile() {
		// TODO Auto-generated method stub
		try {
			FileInputStream file = new FileInputStream(
					new File(
							"C://Users//Bayanna Madanapalli//Downloads//assignment.xlsx"));

			RoutePojo route = new RoutePojo();
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(1);

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
					// Check the cell type and format accordingly
					/*
					 * switch (cell.getCellType()) { case Cell.CELL_TYPE_STRING:
					 * // System.out.print(cell.getNumericCellValue() + "  ");
					 * System.out.print(cell.getStringCellValue() + "  ");
					 * planet.setPlanetNode(cell.getStringCellValue()); break;
					 * case Cell.CELL_TYPE_BOOLEAN:
					 * System.out.print(cell.getStringCellValue() + "  ");
					 * //planet.setPlanetNode(cell.getStringCellValue());
					 * planet.setPlanetName(cell.getStringCellValue()); break; }
					 */

					switch (columnIndex) {
					case 1:
						// System.out.print(cell.getStringCellValue() + "  ");
						if (rowIndex != 0) {
							// planet.setPlanetNode(cell.getStringCellValue());
							route.setPlanet_origin(cell.getStringCellValue());
						}
						break;
					case 2:
						// System.out.print(cell.getStringCellValue() + "  ");
						if (rowIndex != 0) {
							// planet.setPlanetName(cell.getStringCellValue());
							route.setPlanet_destination(cell
									.getStringCellValue());
						}
						break;
					case 3:
						// System.out.print(cell.getNumericCellValue() + " ");
						if (rowIndex != 0) {
							// planet.setPlanetName(cell.getStringCellValue());
							System.out.print(cell.getNumericCellValue() + "  ");
							route.setDistance(cell.getNumericCellValue());
						}
						break;

					}
				}
				// System.out.println("");

				/*
				 * Session session =
				 * EntityUtil.getSessionFactory().openSession();
				 * 
				 * Transaction txn = session.beginTransaction();
				 */

				/*
				 * Configuration cfg = new Configuration().configure();
				 * 
				 * SessionFactory sf = cfg.buildSessionFactory();
				 * 
				 * Session session = sf.openSession();
				 */
				Session session = getSession();
				Transaction txn = session.beginTransaction();
				if (rowIndex != 0) {
					session.save(route);
				}
			}
			file.close();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}
