package org.example;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.example.Dao.DaoClass;
import org.example.entity.Class1;

import java.io.*;
import java.util.ArrayList;


//getting information from excel file and saving it into database
public class Parsing {
    public static String parse() {
        FileInputStream fis = null;
        String str = "ОСВ для тренинга.xls";
        try {
            //put your own path here!!!
            fis = new FileInputStream(new File("C:\\Spring\\WebApp", str));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //creating workbook instance that refers to .xls file
        HSSFWorkbook wb = null;
        try {
            wb = new HSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //creating a Sheet object to retrieve the object
        HSSFSheet sheet = wb.getSheetAt(0);
        //evaluating cell type
        FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
        Row row;
        ArrayList list = new ArrayList();
        int classnum = 1;
        DaoClass dao = null;
        try {
            dao = new DaoClass();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Class1 classic = new Class1();
        for (int i = 9; i < sheet.getPhysicalNumberOfRows()-1; i++)     //iteration over row using for each loop
        {
            row = sheet.getRow(i);
            for (Cell cell : row)    //iteration over cell using for each loop
            {
                switch (formulaEvaluator.evaluateInCell(cell).getCellType()) {
                    case NUMERIC:   //field that represents numeric cell type
                        cell.setCellType(CellType.STRING);
                        list.add(cell.getStringCellValue());
//                        System.out.print(cell.getStringCellValue() + "\t\t");
                        break;
                    case STRING:    //field that represents string cell type
                        //getting the value of the cell as a string
                        list.add(cell.getStringCellValue());
//                        System.out.print(cell.getStringCellValue() + "\t\t");
                        break;
                }
            }
            //TODO Сохранить строки в БД
            if(isNumeric(list.get(0)+"") || list.get(0).equals("ПО КЛАССУ") || list.get(0).equals("БАЛАНС")) {
                classic.setFirstLine(list.get(0) + "");
                classic.setSaldoInActiv(list.get(1) + "");
                classic.setSaldoInPassiv(list.get(2) + "");
                classic.setDebit(list.get(3) + "");
                classic.setCredit(list.get(4) + "");
                classic.setSaldoOutActiv(list.get(5) + "");
                classic.setSaldoOutPassiv(list.get(6) + "");
                dao.save(classic, classnum);
            }
            if(list.get(0).equals("ПО КЛАССУ") && classnum != 9) {
                classnum++;
            }
            list.clear();
        }
        return str;
    }
    static boolean isNumeric(String str){
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
