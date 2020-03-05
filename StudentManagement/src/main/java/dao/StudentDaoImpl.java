/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import common.CellValue;
import common.WorkBookValue;
import entities.Student;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author PC
 */
public class StudentDaoImpl implements StudentDao {

    @Override
    public List<Student> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertStudent(List<Student> students) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Student> readStudentFromExcelFile(String excelFilePath) {
        List<Student> students = new ArrayList<>();
        File file = new File(excelFilePath);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            Workbook workbook = WorkBookValue.getWorkbook(fileInputStream, excelFilePath);
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> rows = firstSheet.iterator();
            while (rows.hasNext()) {
                Student student = new Student();
                Row row = rows.next();
                Iterator<Cell> cells = row.iterator();

                while (cells.hasNext()) {
                    Cell cell = cells.next();
                    int columnIndex = cell.getColumnIndex();

                    switch (columnIndex) {
                        case 0:
                            String idStudent = String.valueOf(CellValue.getCellNumber(cell));
                            student.setIdStudent(idStudent);
                            break;
                        case 9:

                            break;
                        case 2:

                            break;
                    }
                }
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
