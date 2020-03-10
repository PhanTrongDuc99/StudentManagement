/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import entities.Profile;
import entities.Student;
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
public class ReadFromExcelFile {

    public static List<Student> readStudentFromExcelFile(String excelFilePath) {
        List<Student> students = new ArrayList<>();
        File file = new File(excelFilePath);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            Workbook workbook = WorkBookValue.getWorkbook(fileInputStream, excelFilePath);
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> rows = firstSheet.iterator();
            while (rows.hasNext()) {
                Row row = rows.next();
                Iterator<Cell> cells = row.iterator();
                Student student = new Student();
                Profile profile = new Profile();
                student.setProfileStudent(profile);
                while (cells.hasNext()) {
                    Cell cell = cells.next();
                    int columnIndex = cell.getColumnIndex();
                    switch (columnIndex) {
                        case 0:
                            cell.setCellType(CellType.STRING);
                            String idStudent = String.valueOf(CellValue.getCellValue(cell));
                            student.setIdStudent(idStudent);
                            student.getProfileStudent().setId(idStudent);
                            System.out.println(idStudent);
                            break;
                        case 1:
                            String name = String.valueOf(CellValue.getCellValue(cell));
                            student.getProfileStudent().setFullName(name);
                            break;
                        case 2:
                            String phone = String.valueOf(CellValue.getCellValue(cell));
                            student.getProfileStudent().setPhoneNumber(phone);
                            break;
                        case 3:
                            String email = String.valueOf(CellValue.getCellValue(cell));
                            student.getProfileStudent().setEmail(email);
                            break;
                        case 4:
                            Double doubleDayOfBirth = Double.valueOf(String.valueOf(CellValue.getCellValue(cell)));
                            Date dayOfBirth = DateUtil.getJavaDate(doubleDayOfBirth);
                            student.getProfileStudent().setDayOfBirth(dayOfBirth);
                            break;
                        case 5:
                            String homeTown = String.valueOf(CellValue.getCellValue(cell));
                            student.getProfileStudent().setHomeTown(homeTown);
                            break;
                        case 6:
                            int numberGender = (int) CellValue.getCellNumber(cell);
                            student.getProfileStudent().setGender(numberGender == 1);
                            break;
                        case 7:
                            cell.setCellType(CellType.STRING);
                            String idNumber = String.valueOf(CellValue.getCellValue(cell));
                            student.getProfileStudent().setIdNumber(idNumber);
                            break;
                        case 8:
                            String currentAddress = String.valueOf(CellValue.getCellValue(cell));
                            student.getProfileStudent().setCurrentAddress(currentAddress);
                            break;
                        case 9:
                            Double discountStatus = Double.valueOf(String.valueOf(CellValue.getCellValue(cell)));
                            student.setDiscountStatus(discountStatus);
                            break;
                        case 10:
                            Double cost = Double.valueOf(String.valueOf(CellValue.getCellValue(cell)));
                            student.setCost(cost);
                            break;
                    }
                }
                System.out.println(student);
                students.add(student);
            }
            workbook.close();
            fileInputStream.close();
            return students;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

}
