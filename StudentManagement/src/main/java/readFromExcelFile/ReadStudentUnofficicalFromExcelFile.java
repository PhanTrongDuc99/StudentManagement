/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readFromExcelFile;

import common.CellValue;
import common.RegisterStatus;
import common.RegisterType;
import common.WorkBookValue;
import entities.Profile;
import entities.Register;
import entities.StudentUnofficial;
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
public class ReadStudentUnofficicalFromExcelFile {
    
    public static List<StudentUnofficial> readStudentFromExcelFile(String excelFilePath) {
        List<StudentUnofficial> studentUnofficials = new ArrayList<>();
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
                StudentUnofficial studentUnofficial = new StudentUnofficial();
                Profile profile = new Profile();
                Register register = new Register();
                studentUnofficial.setRegister(register);
                studentUnofficial.setProfile(profile);
                while (cells.hasNext()) {
                    Cell cell = cells.next();
                    int columnIndex = cell.getColumnIndex();
                    switch (columnIndex) {
                        case 0:
                            cell.setCellType(CellType.STRING);
                            String id = String.valueOf(CellValue.getCellValue(cell));
                            studentUnofficial.setId(id);
                            studentUnofficial.getProfile().setId(id);
                            studentUnofficial.getRegister().setId(id);
                            System.out.println(id);
                            break;
                        case 1:
                            String name = String.valueOf(CellValue.getCellValue(cell));
                            studentUnofficial.getProfile().setFullName(name);
                            break;
                        case 2:
                            String phone = String.valueOf(CellValue.getCellValue(cell));
                            studentUnofficial.getProfile().setPhoneNumber(phone);
                            break;
                        case 3:
                            String email = String.valueOf(CellValue.getCellValue(cell));
                            studentUnofficial.getProfile().setEmail(email);
                            break;
                        case 4:
                            Double doubleDayOfBirth = Double.valueOf(String.valueOf(CellValue.getCellValue(cell)));
                            Date dayOfBirth = DateUtil.getJavaDate(doubleDayOfBirth);
                            studentUnofficial.getProfile().setDayOfBirth(dayOfBirth);
                            break;
                        case 5:
                            String homeTown = String.valueOf(CellValue.getCellValue(cell));
                            studentUnofficial.getProfile().setHomeTown(homeTown);
                            break;
                        case 6:
                            int numberGender = (int) CellValue.getCellNumber(cell);
                            studentUnofficial.getProfile().setGender(numberGender == 1);
                            break;
                        case 7:
                            cell.setCellType(CellType.STRING);
                            String idNumber = String.valueOf(CellValue.getCellValue(cell));
                            studentUnofficial.getProfile().setIdNumber(idNumber);
                            break;
                        case 8:
                            String currentAddress = String.valueOf(CellValue.getCellValue(cell));
                            studentUnofficial.getProfile().setCurrentAddress(currentAddress);
                            break;
                        case 9:
                            Double discountStatus = Double.valueOf(String.valueOf(CellValue.getCellValue(cell)));
                            studentUnofficial.setDiscountStatus(discountStatus);
                            break;
                        case 10:
                            Double cost = Double.valueOf(String.valueOf(CellValue.getCellValue(cell)));
                            studentUnofficial.setCost(cost);
                            break;
                        case 11:
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            String registerStatus = String.valueOf(CellValue.getCellValue(cell));
                            if (registerStatus.equalsIgnoreCase(RegisterStatus.REGISTERED.getNote())) {
                                register.setStatus(RegisterStatus.REGISTERED);
                            } else if (registerStatus.equalsIgnoreCase(RegisterStatus.WAITTING.getNote())) {
                                register.setStatus(RegisterStatus.WAITTING);
                            } else {
                                register.setStatus(RegisterStatus.CANCEL);
                            }
                            break;
                        case 12:
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            String registerType = String.valueOf(CellValue.getCellValue(cell));
                            if (registerType.equalsIgnoreCase(RegisterType.MARKETING.getNote())) {
                                register.setType(RegisterType.MARKETING);
                            } else if (registerType.equalsIgnoreCase(RegisterType.DIRECT.getNote())) {
                                register.setType(RegisterType.DIRECT);
                            } else {
                                register.setType(RegisterType.DIRECT);
                            }
                            break;
                        case 13:
                            String idGrade = String.valueOf(CellValue.getCellValue(cell));
                            studentUnofficial.setIdRegisterGrade(idGrade);
                            break;
                        
                    }
                }
                System.out.println(studentUnofficial);
                studentUnofficials.add(studentUnofficial);
            }
            workbook.close();
            fileInputStream.close();
            return studentUnofficials;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentUnofficials;
    }
}
