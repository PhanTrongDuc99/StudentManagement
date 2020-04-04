/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.sub;

import entities.TimeKeeping;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import service.TimeKeepingService;
import service.TimeKeepingServiceImpl;

/**
 *
 * @author USER
 */
public class TimeKeepingTable extends JFrame {

    private JTable tbTimekeeping;
    private DefaultTableModel model;
    private JScrollPane js;
    private JTextField tfTimekeeping;

    public TimeKeepingTable(JTextField tfTimekeeping) {
        this.tfTimekeeping = tfTimekeeping;
        initComponent();
        events();
    }

    private void initComponent() {
        setTitle("Timekeepings");
        setSize(800, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        tbTimekeeping = new JTable();
        js = new JScrollPane(tbTimekeeping);
        js.setBounds(20, 20, 800, 300);
        add(js);
        loadDataGradeIntoJTable(mockData());
    }

    private void loadDataGradeIntoJTable(List<TimeKeeping> list) {
        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        Vector column = new Vector();
        column.add("Id");
        column.add("TeachingHours");
        column.add("RewardLevel");
        column.add("DisciplineLevel");
        column.add("Select");

        model.setColumnIdentifiers(column);
        for (int i = 0; i < list.size(); i++) {
            TimeKeeping timeKeeping = list.get(i);
            Vector row = new Vector();
            row.add(timeKeeping.getId());
            row.add(timeKeeping.getTeachingHours());
            row.add(timeKeeping.getRewardLevel());
            row.add(timeKeeping.getDisciplineLevel());
            row.add("<html><a href='select';' >Selected</a></html>");
            model.addRow(row);
        }
        tbTimekeeping.setModel(model);
        tbTimekeeping.setRowSelectionAllowed(false);
        tbTimekeeping.setCellSelectionEnabled(true);
        tbTimekeeping.setFocusable(false);
    }

    private void events() {
        tbTimekeeping.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                int row = tbTimekeeping.rowAtPoint(evt.getPoint());
                int col = tbTimekeeping.columnAtPoint(evt.getPoint());
                if ((row >= 0 && col == 4)) {
                    Object[] rowData = new Object[tbTimekeeping.getColumnCount()];
                    for (int i = 0; i < tbTimekeeping.getColumnCount(); i++) {
                        rowData[i] = tbTimekeeping.getValueAt(row, i);
                    }
                    tfTimekeeping.setText((String) rowData[0]);
                    setVisible(false);
                }
            }
        });
    }

    private List<TimeKeeping> mockData() {
        TimeKeepingService timeKeepingService = new TimeKeepingServiceImpl();
        return timeKeepingService.getAll();
    }
}
