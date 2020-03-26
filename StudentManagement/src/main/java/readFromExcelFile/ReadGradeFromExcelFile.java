/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readFromExcelFile;

import common.CellValue;
import common.WorkBookValue;
import entities.Course;
import entities.Grade;
import entities.Teacher;
import java.io.File;
import java.io.FileInputStream;
import java.time.LocalTime;
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
import utils.DayOfWeekUtils;

/**
 *
 * @author USER
 */
public class ReadGradeFromExcelFile {

    public static List<Grade> readGradeFromExcelFile(String excelFilePath) {
        List<Grade> grades = new ArrayList<>();
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
                Grade grade = new Grade();
                Course course = new Course();
                Teacher teacher = new Teacher();
                grade.setCourse(course);
                grade.setTeacher(teacher);
                while (cells.hasNext()) {
                    Cell cell = cells.next();
                    int columnIndex = cell.getColumnIndex();
                    switch (columnIndex) {
                        case 0:
                            cell.setCellType(CellType.STRING);
                            String id = String.valueOf(CellValue.getCellValue(cell));
                            grade.setIdGrade(id);
                            break;
                        case 1:
                            String name = String.valueOf(CellValue.getCellValue(cell));
                            grade.setNameGrade(name);
                            break;
                        case 2:
                            cell.setCellType(CellType.STRING);
                            String idTeacher = String.valueOf(CellValue.getCellValue(cell));
                            grade.getTeacher().setIdTeacher(idTeacher);
                            break;
                        case 3:
                            Double startTimeDouble = Double.valueOf(String.valueOf(CellValue.getCellValue(cell)));
                            Date startTime = DateUtil.getJavaCalendar(startTimeDouble).getTime();
                            grade.setStartTime(LocalTime.of(startTime.getHours(), startTime.getMinutes()));
                            break;
                        case 4:
                            Double endTimeDouble = Double.valueOf(String.valueOf(CellValue.getCellValue(cell)));
                            Date endTime = DateUtil.getJavaCalendar(endTimeDouble).getTime();
                            grade.setEndTime(LocalTime.of(endTime.getHours(), endTime.getMinutes()));
                            break;
                        case 5:
                            String dayOfWeekString = String.valueOf(CellValue.getCellValue(cell));
                            grade.setDaysOfWeek(DayOfWeekUtils.convertStringNumberToDayOfWeek(dayOfWeekString));
                            break;
                        case 6:
                            cell.setCellType(CellType.STRING);
                            String idCourse = String.valueOf(CellValue.getCellValue(cell));
                            grade.getCourse().setIdCourse(idCourse);
                            break;
                        case 7:
                            int studentQuatity = (int) CellValue.getCellNumber(cell);
                            grade.setStudentQuantity(studentQuatity);
                            break;
                    }
                }
                grades.add(grade);
            }
            workbook.close();
            fileInputStream.close();
            return grades;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return grades;
    }
}
