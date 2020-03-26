/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readFromExcelFile;

import common.CellValue;
import common.WorkBookValue;
import entities.Course;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author USER
 */
public class ReadCourseFromExcelFile {

    public static List<Course> readCourseFromExcelFile(String excelFilePath) {
        List<Course> courses = new ArrayList<>();
        File file = new File(excelFilePath);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            Workbook workbook = WorkBookValue.getWorkbook(fileInputStream, excelFilePath);
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> rows = firstSheet.iterator();
            while (rows.hasNext()) {
                Row row = rows.next();
                if (row.getRowNum() == 0) {
                    continue;
                }
                Iterator<Cell> cells = row.iterator();
                Course course = new Course();

                while (cells.hasNext()) {
                    Cell cell = cells.next();
                    int columnIndex = cell.getColumnIndex();
                    switch (columnIndex) {
                        case 0:
                            cell.setCellType(CellType.STRING);
                            String id = String.valueOf(CellValue.getCellValue(cell));
                            course.setIdCourse(id);
                            System.out.println(id);
                            break;
                        case 1:
                            String name = String.valueOf(CellValue.getCellValue(cell));
                            course.setNameCourse(name);
                            break;
                        case 2:
                            Double startDayDouble = Double.valueOf(String.valueOf(CellValue.getCellValue(cell)));
                            Date startDay = DateUtil.getJavaDate(startDayDouble);
                            course.setStartTime(startDay);
                            break;
                        case 3:
                            Double endDayDouble = Double.valueOf(String.valueOf(CellValue.getCellValue(cell)));
                            Date endDay = DateUtil.getJavaDate(endDayDouble);
                            course.setEndTime(endDay);
                            break;
                        case 4:
                            int gradeQuantity = (int) CellValue.getCellNumber(cell);
                            course.setGradeQuantity(gradeQuantity);
                            break;
                        case 5:
                            Double cost = Double.valueOf(String.valueOf(CellValue.getCellValue(cell)));
                            course.setCost(cost);
                            break;
                    }
                }
                System.out.println(course);
                courses.add(course);
            }
            workbook.close();
            fileInputStream.close();
            return courses;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courses;
    }
}
