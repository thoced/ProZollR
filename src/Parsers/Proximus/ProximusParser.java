package Parsers.Proximus;
import Models.Proximus.*;
import Parsers.IParser;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ProximusParser implements IParser<Proximus> {

    private Workbook workbook = null;
    private Proximus proximus;

    private void parseCalls()
    {
        for(int i = 0;i < workbook.getNumberOfSheets() ; i++){
            String sheetName = workbook.getSheetName(i);
            if(sheetName.startsWith("Calls for CCJ")) {
                Sheet sheet = workbook.getSheetAt(i);
                // Récupérer l'en-tête
                Row headerRow = sheet.getRow(0);
                List<String> columnNames = new ArrayList<String>();
                Iterator<Cell> cellIterator = headerRow.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    columnNames.add(cell.getStringCellValue());
                }
                for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                    Row currentRow = sheet.getRow(rowIndex);

                    ProximusCalls callData = new ProximusCalls(
                            getStringCellValue(columnNames, "Type", currentRow),
                            getStringCellValue(columnNames, "Called/Calling nr", currentRow),
                            getStringCellValue(columnNames, "Date", currentRow),
                            getStringCellValue(columnNames, "Time", currentRow),
                            getStringCellValue(columnNames, "Duration", currentRow),
                            getStringCellValue(columnNames, "Served Phone Number", currentRow),
                            getStringCellValue(columnNames, "Served Start Cell ID", currentRow),
                            getStringCellValue(columnNames, "Served Start Cell LAC", currentRow),
                            getStringCellValue(columnNames, "Served End Cell ID", currentRow),
                            getStringCellValue(columnNames, "Served End Cell LAC", currentRow),
                            getStringCellValue(columnNames, "Served IMEI", currentRow),
                            getStringCellValue(columnNames, "Served IMSI", currentRow),
                            getStringCellValue(columnNames, "Served MSRN", currentRow),
                            getStringCellValue(columnNames, "Operator Name", currentRow),
                            getStringCellValue(columnNames, "Third Party", currentRow),
                            getStringCellValue(columnNames, "In Operator", currentRow),
                            getStringCellValue(columnNames, "In Country", currentRow),
                            getStringCellValue(columnNames, "Out Operator", currentRow),
                            getStringCellValue(columnNames, "Out Country", currentRow)
                    );

                    proximus.getCallsCollection().add(callData);

                }
            }
        }


    }

    private void parseCells()
    {
        for(int i = 0; i < workbook.getNumberOfSheets() ; i++)
        {
            if(workbook.getSheetName(i).startsWith("Cell Locali"))
            {
                Sheet sheet = workbook.getSheetAt(i);
                // Récupérer l'en-tête
                Row headerRow = sheet.getRow(0);
                List<String> columnNames = new ArrayList<String>();
                Iterator<Cell> cellIterator = headerRow.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    columnNames.add(cell.getStringCellValue());
                }
                for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++)
                {
                    Row currentRow = sheet.getRow(rowIndex);

                    ProximusCells cellData = new ProximusCells(
                            getStringCellValue(columnNames, "Cell ID", currentRow),
                            getStringCellValue(columnNames, "Cell Address", currentRow),
                            getStringCellValue(columnNames, "Location Area Code", currentRow)
                    );

                    proximus.getCellsCollection().add(cellData);
                }
            }
        }
    }

    private void parseSubscrivers()
    {
        for(int i = 0; i < workbook.getNumberOfSheets() ; i++)
        {
            if(workbook.getSheetName(i).startsWith("Subscribers for CCJ"))
            {
                Sheet sheet = workbook.getSheetAt(i);
                // Récupérer l'en-tête
                Row headerRow = sheet.getRow(0);
                List<String> columnNames = new ArrayList<String>();
                Iterator<Cell> cellIterator = headerRow.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    columnNames.add(cell.getStringCellValue());
                }
                for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++)
                {
                    Row currentRow = sheet.getRow(rowIndex);

                    ProximusSubscrivers subscriverData = new ProximusSubscrivers(
                            getStringCellValue(columnNames, "Called/Calling nr", currentRow),
                            getStringCellValue(columnNames, "IMSI", currentRow),
                            getStringCellValue(columnNames, "Sim Card Number", currentRow),
                            getStringCellValue(columnNames, "Identifier Type", currentRow),
                            getStringCellValue(columnNames, "Name", currentRow),
                            getStringCellValue(columnNames, "Address", currentRow),
                            getStringCellValue(columnNames, "Post Code", currentRow),
                            getStringCellValue(columnNames, "City", currentRow),
                            getStringCellValue(columnNames, "Start Date", currentRow),
                            getStringCellValue(columnNames, "End Date", currentRow),
                            getStringCellValue(columnNames, "Operator", currentRow)
                    );

                    proximus.getSubscribersCollection().add(subscriverData);
                }
            }
        }
    }

    private void parseNPSubscrivers()
    {
        for(int i = 0; i < workbook.getNumberOfSheets() ; i++)
        {
            if(workbook.getSheetName(i).startsWith("Non-Proximus for CCJ"))
            {
                Sheet sheet = workbook.getSheetAt(i);
                // Récupérer l'en-tête
                Row headerRow = sheet.getRow(0);
                List<String> columnNames = new ArrayList<String>();
                Iterator<Cell> cellIterator = headerRow.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    columnNames.add(cell.getStringCellValue());
                }
                for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++)
                {
                    Row currentRow = sheet.getRow(rowIndex);

                    ProximusNPSubscrivers subscriverData = new ProximusNPSubscrivers(
                            getStringCellValue(columnNames, "Called/Calling nr", currentRow));

                    proximus.getNpSubscribersCollection().add(subscriverData);
                }
            }
        }
    }
    public Proximus parseFile(String filePath) throws IOException,FileNotFoundException
    {
        if(filePath == null || filePath.isEmpty() || filePath.isBlank())
        {
            throw new FileNotFoundException();
        }

        FileInputStream inputStream = new FileInputStream(new File(filePath));
        workbook = new XSSFWorkbook(inputStream);

        // création de l'objet proximus
        proximus = new Proximus();

        // parse les calls
        parseCalls();
        // parse les Cells
        parseCells();
        // parse les subscrivers Proximus
        parseSubscrivers();
        // parse les NP subscrivers
        parseNPSubscrivers();

        // retour de l'objet proximus
        return proximus;

    }

    private static String getStringCellValue(List<String> columnNames, String columnName, Row currentRow) {
        int columnIndex = columnNames.indexOf(columnName);
        if (columnIndex >= 0) {
            Cell cell = currentRow.getCell(columnIndex);
            if (cell != null) {

                if(cell.getCellType() == CellType.STRING)
                {
                    return cell.getStringCellValue();
                }
                if(cell.getCellType() == CellType.NUMERIC)
                {
                    return String.valueOf(cell.getNumericCellValue());
                }
            }
        }
        return "";
    }
}
