package com.util;

import com.entity.StageInfo;
import com.jfinal.template.expr.ast.Array;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOError;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ReadExcel {
    private int totalRows; //sheet中总行数
    private int totalCells; //每一行总单元格数
    public int getTotalRows() {
        return totalRows;
    }
    public int getTotalCells() {
        return totalCells;
    }
    public ArrayList<StageInfo> toReadExcel(FileInputStream fis, File file1) throws IOException{
        fis=new FileInputStream(file1);
        ArrayList<String> ticket = new ArrayList<>();
        Workbook hssfWorkbook = null;
        //对格式进行验证
        try {
            hssfWorkbook = new HSSFWorkbook(fis);
        } catch (Exception ex) {
            // 解决read error异常
            fis = new FileInputStream(file1);
            try {
                hssfWorkbook = new XSSFWorkbook(fis);
            } catch (Exception e) {
                throw new RuntimeException("请确认传入的文件是否正确。");
            }
        }
        //获取工作表
        Sheet sheet = hssfWorkbook.getSheetAt(0);
        totalRows = gainTotalRows(sheet);
        System.out.println("48");
        System.out.println(totalRows);
        System.out.println("48");
        ArrayList<StageInfo> stageList = new ArrayList<>();
        for (int rowNum = 1; rowNum <= totalRows; rowNum++) {
            Row hssfRow = sheet.getRow(rowNum);
            if (hssfRow != null) {
                totalCells = hssfRow.getLastCellNum();
                System.out.println("56");
                System.out.println(totalCells);
                System.out.println("56");
                StageInfo si = new StageInfo();
                List<String> bigballTempList = new ArrayList<>();
                for (short c = 0; c <= totalCells - 1; c++) {
                    Cell cell = hssfRow.getCell(c);
                    if (cell != null) {
                        if(c<totalCells-1) {
                            bigballTempList.add(getHValue(cell));
                            continue;
                        }else{
                            si.setSmallBall(getHValue(cell));
                        }
                    }
                }
                si.setBigBallList(bigballTempList);
                stageList.add(si);
            }
        }
        return stageList;
    }

    private  int gainTotalRows(Sheet sheet){
        int rowindex = sheet.getLastRowNum();
        //读取Row,从第二行开始
        for (int rowNum = 1; rowNum <= rowindex; rowNum++) {
            Row hssfRow1 = sheet.getRow(rowNum);
            if (hssfRow1 == null) {
                rowindex--;
            }
        }
        return rowindex;
    }
    private  String getHValue(Cell hssfCell) {
        int cellType = hssfCell.getCellType();
        if (cellType == hssfCell.CELL_TYPE_NUMERIC){
            int cellValue = 0;
            DecimalFormat df = new DecimalFormat("#.######");
            String cellDoublevalue = df.format(hssfCell.getNumericCellValue());//去科学计数
//            cellValue = Integer.parseInt(cellDoublevalue);
            return cellDoublevalue;
        }else if(cellType == hssfCell.CELL_TYPE_STRING){
            String cellValue = hssfCell.getStringCellValue().trim();
            return cellValue;
        }
        return "0";
    }
    private  int ridpoint(String index) {
        try {
            if (index.contains(".")) {
                index = index.substring(0, index.indexOf("."));
                return Integer.parseInt(index);
            } else {
                return Integer.parseInt(index);
            }
        }catch (Exception e){
            throw new RuntimeException(index+",该数值不在999999999~0之间");
        }
    }
}
