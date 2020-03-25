/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readFromExcelFile;

import common.CellValue;
import common.WorkBookValue;
import entities.Profile;
import entities.Teacher;
import entities.TimeKeeping;
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
public class ReadTeacherFromExcelFile {

    public static List<Teacher> readTeacherFromFile(String excelFilePath) {
        List<Teacher> teachers = new ArrayList<>();
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
                Teacher teacher = new Teacher();
                Profile profile = new Profile();
                TimeKeeping timeKeeping = new TimeKeeping();
                teacher.setProfileTeacher(profile);
                teacher.setTimeKeeping(timeKeeping);
                while (cells.hasNext()) {
                    Cell cell = cells.next();
                    int columnIndex = cell.getColumnIndex();
                    switch (columnIndex) {
                        case 0:
                            cell.setCellType(CellType.STRING);
                            String idTeacher = String.valueOf(CellValue.getCellValue(cell));
                            teacher.setIdTeacher(idTeacher);
                            teacher.getProfileTeacher().setId(idTeacher);
                            teacher.getTimeKeeping().setId(idTeacher);
                            System.out.println(idTeacher);
                            break;
                        case 1:
                            String name = String.valueOf(CellValue.getCellValue(cell));
                            teacher.getProfileTeacher().setFullName(name);
                            break;
                        case 2:
                            String phone = String.valueOf(CellValue.getCellValue(cell));
                            teacher.getProfileTeacher().setPhoneNumber(phone);
                            break;
                        case 3:
                            String email = String.valueOf(CellValue.getCellValue(cell));
                            teacher.getProfileTeacher().setEmail(email);
                            break;
                        case 4:
                            Double doubleDayOfBirth = Double.valueOf(String.valueOf(CellValue.getCellValue(cell)));
                            Date dayOfBirth = DateUtil.getJavaDate(doubleDayOfBirth);
                            teacher.getProfileTeacher().setDayOfBirth(dayOfBirth);
                            break;
                        case 5:
                            String homeTown = String.valueOf(CellValue.getCellValue(cell));
                            teacher.getProfileTeacher().setHomeTown(homeTown);
                            break;
                        case 6:
                            int numberGender = (int) CellValue.getCellNumber(cell);
                            teacher.getProfileTeacher().setGender(numberGender == 1);
                            break;
                        case 7:
                            cell.setCellType(CellType.STRING);
                            String idNumber = String.valueOf(CellValue.getCellValue(cell));
                            teacher.getProfileTeacher().setIdNumber(idNumber);
                            break;
                        case 8:
                            String currentAddress = String.valueOf(CellValue.getCellValue(cell));
                            teacher.getProfileTeacher().setCurrentAddress(currentAddress);
                            break;
                        case 9:
                            String workPlace = String.valueOf(CellValue.getCellValue(cell));
                            teacher.setWorkPlace(workPlace);
                            break;
                        case 10:
                            Double salary = Double.valueOf(String.valueOf(CellValue.getCellValue(cell)));
                            teacher.setSalary(salary);
                            break;
                        case 11:
                            Double teachingHours = Double.valueOf(String.valueOf(CellValue.getCellValue(cell)));
                            teacher.getTimeKeeping().setTeachingHours(teachingHours);
                            break;
                        case 12:
                            String rewardLevel = String.valueOf(CellValue.getCellValue(cell));
                            teacher.getTimeKeeping().setRewardLevel(rewardLevel);
                            break;
                        case 13:
                            String disciplineLevel = String.valueOf(CellValue.getCellValue(cell));
                            teacher.getTimeKeeping().setDisciplineLevel(disciplineLevel);
                            break;

                    }
                }
                teachers.add(teacher);
            }
            workbook.close();
            fileInputStream.close();
            return teachers;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teachers;

    }
}
