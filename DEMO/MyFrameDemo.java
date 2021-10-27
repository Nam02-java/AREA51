package DEMO;

import static java.lang.System.out;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MyFrameDemo extends JFrame {
    static JTable table;
    static DefaultTableModel model;
    static ArrayList<BaseOfDemo> arrayList = new ArrayList<>();
    static String[] column = new String[]{"Name", "Point", "Edit", "Delete"};
    static Object[][] array2d;
    static Object[] row;
    static Object data1, data2, data3, data4, convert1, convert2, convert3, convert4, work1, work2, work3, work4, display1, display2, display3, display4, dataSearch1, dataSearch2, dataSearch3, dataSearch4;

    static JTextField textFieldName, textFieldPoint, textFieldSearch;
    static JButton buttonAdd, buttonMenu, buttonPrevious, buttonNext, buttonSearch;

    static JButton[] buttons = new JButton[37];
    static JButton[] buttonsSearch = new JButton[37];
    static JButton buttonAll;
    static JPanel panelNumber, panelInputData, panelSearch;
    static JLabel label;
    static ArrayList<BaseOfDemo> arrayListSearch = new ArrayList<>();

    static int save = 0;

    static ImageIcon imageIcon1, imageIcon2;
    static JButton buttonDemo1, buttonDemo2;
    static JLabel label1, label2, label3;

    public void showWindowDemo() { // bridge
        model = new DefaultTableModel(array2d, column);
        table = new JTable(model);
        table.setBackground(Color.BLACK);
        table.setForeground(Color.GREEN);


        panelInputData = new JPanel();
        panelInputData.setLayout(new GridLayout(2, 1));
        panelInputData.add(label1 = new JLabel("Name"));
        label1.setFont(new Font("Mv BoLi",Font.PLAIN,20));
        panelInputData.add(textFieldName = new JTextField());
       textFieldName.setBackground(Color.BLACK);
       textFieldName.setForeground(Color.GREEN);
       textFieldName.setCaretColor(Color.GREEN);
        panelInputData.add(buttonAdd = new JButton(new ImageIcon("C:\\Users\\User\\Downloads\\icons8-add-35 (1).png")));
        buttonAdd.setBackground(Color.lightGray);

        panelInputData.add(label2 = new JLabel("Point"));
        label2.setFont(new Font("Mv BoLi",Font.PLAIN,20));
        panelInputData.add(textFieldPoint = new JTextField());
        textFieldPoint.setBackground(Color.BLACK);
        textFieldPoint.setForeground(Color.GREEN);
        textFieldPoint.setCaretColor(Color.GREEN);
        panelInputData.add(buttonMenu = new JButton(new ImageIcon("C:\\Users\\User\\Downloads\\icons8-menu-35 (1).png")));
        buttonMenu.setBackground(Color.lightGray);
        panelInputData.setBackground(Color.lightGray);

        panelSearch = new JPanel();
        panelSearch.setLayout(new GridLayout(1, 1));
        panelSearch.setSize(300, 300);
        panelSearch.add(label3 = new JLabel("Search student by name"));
        label3.setFont(new Font("Mv BoLi",Font.PLAIN,20));
        panelSearch.add(textFieldSearch = new JTextField());
        textFieldSearch.setBackground(Color.BLACK);
        textFieldSearch.setForeground(Color.GREEN);
        textFieldSearch.setCaretColor(Color.GREEN);
        panelSearch.add(buttonSearch = new JButton(new ImageIcon("C:\\Users\\User\\Downloads\\icons8-search-35.png")));
        buttonSearch.setBackground(Color.lightGray);
        panelSearch.setBackground(Color.lightGray);

        panelNumber = new JPanel();
        panelNumber.setLayout(new FlowLayout(3));

        panelNumber.add(buttonPrevious = new JButton("Previous"));
        buttonPrevious.setBackground(Color.black);
        buttonPrevious.setForeground(Color.cyan);
        buttonPrevious.setVisible(false);

        for (int i = 1; i <= 34; i++) {
            panelNumber.add(buttons[i] = new JButton(String.valueOf(i)));
            buttons[i].setBackground(Color.black);
            buttons[i].setForeground(Color.cyan);
        }

        panelNumber.add(label = new JLabel("......"));
        panelNumber.add(buttons[35] = new JButton(String.valueOf(35)));
        buttons[35].setBackground(Color.black);
        buttons[35].setForeground(Color.cyan);

        for (int i = 11; i <= 34; i++) {
            buttons[i].setVisible(false);
        }

        panelNumber.add(buttonNext = new JButton("Next"));
        buttonNext.setBackground(Color.black);
        buttonNext.setForeground(Color.cyan);
        panelNumber.setBackground(Color.lightGray);

        panelNumber.add(buttonAll = new JButton("All"));
        buttonAll.setVisible(false);
        buttonAll.setBackground(Color.black);
        buttonAll.setForeground(Color.cyan);
        for (int i = 1; i <= 35; i++) {
            panelNumber.add(buttonsSearch[i] = new JButton(String.valueOf(i)));
            buttonsSearch[i].setBackground(Color.black);
            buttonsSearch[i].setForeground(Color.cyan);
            buttonsSearch[i].setVisible(false);
        }
        add(new JScrollPane(table));
        add(panelInputData);
        add(panelSearch);
        add(panelNumber);
        setButtons();
        setButtonsSearch();
        setTitle("Example");
        setBounds(350, 300, 900, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));
        setVisible(true);
    }

    public void setButtonsSearch() {
        buttonAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 1; i <= 35; i++) {
                    buttonsSearch[i].setForeground(Color.cyan);
                }
                buttonAll.setForeground(Color.white);
                for (int i = 0; i < model.getRowCount(); ) {
                    model.removeRow(0);
                }
                for (int i = 0; i < arrayListSearch.size(); i++) {
                    dataSearch1 = array2d[i][0] = arrayListSearch.get(i).getName();
                    dataSearch2 = array2d[i][1] = arrayListSearch.get(i).getPoint();
                    dataSearch3 = array2d[i][2] = arrayListSearch.get(i).getButtonEdit();
                    dataSearch4 = array2d[i][3] = arrayListSearch.get(i).getButtonDelete();
                    model.addRow(row = new Object[]{dataSearch1, dataSearch2, dataSearch3, dataSearch4});
                }
            }
        });

        buttonsSearch[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 1; i <= 35; i++) {
                    buttonsSearch[i].setForeground(Color.cyan);
                }
                buttonAll.setForeground(Color.cyan);
                buttonsSearch[1].setForeground(Color.white);
                for (int i = 0; i < model.getRowCount(); ) {
                    model.removeRow(0);
                }
                for (int i = 0; i <= 4; i++) {
                    dataSearch1 = array2d[i][0] = arrayListSearch.get(i).getName();
                    dataSearch2 = array2d[i][1] = arrayListSearch.get(i).getPoint();
                    dataSearch3 = array2d[i][2] = arrayListSearch.get(i).getButtonEdit();
                    dataSearch4 = array2d[i][3] = arrayListSearch.get(i).getButtonDelete();
                    model.addRow(row = new Object[]{dataSearch1, dataSearch2, dataSearch3, dataSearch4});
                }
            }
        });

        buttonsSearch[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 1; i <= 35; i++) {
                    buttonsSearch[i].setForeground(Color.cyan);
                }
                buttonAll.setForeground(Color.cyan);
                buttonsSearch[2].setForeground(Color.white);
                for (int i = 0; i < model.getRowCount(); ) {
                    model.removeRow(0);
                }
                for (int i = 5; i <= 9; i++) {
                    dataSearch1 = array2d[i][0] = arrayListSearch.get(i).getName();
                    dataSearch2 = array2d[i][1] = arrayListSearch.get(i).getPoint();
                    dataSearch3 = array2d[i][2] = arrayListSearch.get(i).getButtonEdit();
                    dataSearch4 = array2d[i][3] = arrayListSearch.get(i).getButtonDelete();
                    model.addRow(row = new Object[]{dataSearch1, dataSearch2, dataSearch3, dataSearch4});
                }
            }
        });

        buttonsSearch[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 1; i <= 35; i++) {
                    buttonsSearch[i].setForeground(Color.cyan);
                }
                buttonAll.setForeground(Color.cyan);
                buttonsSearch[3].setForeground(Color.white);
                for (int i = 0; i < model.getRowCount(); ) {
                    model.removeRow(0);
                }
                for (int i = 10; i <= 14; i++) {
                    dataSearch1 = array2d[i][0] = arrayListSearch.get(i).getName();
                    dataSearch2 = array2d[i][1] = arrayListSearch.get(i).getPoint();
                    dataSearch3 = array2d[i][2] = arrayListSearch.get(i).getButtonEdit();
                    dataSearch4 = array2d[i][3] = arrayListSearch.get(i).getButtonDelete();
                    model.addRow(row = new Object[]{dataSearch1, dataSearch2, dataSearch3, dataSearch4});
                }
            }
        });

        buttonsSearch[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 1; i <= 35; i++) {
                    buttonsSearch[i].setForeground(Color.cyan);
                }
                buttonAll.setForeground(Color.cyan);
                buttonsSearch[4].setForeground(Color.white);
                for (int i = 0; i < model.getRowCount(); ) {
                    model.removeRow(0);
                }
                for (int i = 15; i <= 19; i++) {
                    dataSearch1 = array2d[i][0] = arrayListSearch.get(i).getName();
                    dataSearch2 = array2d[i][1] = arrayListSearch.get(i).getPoint();
                    dataSearch3 = array2d[i][2] = arrayListSearch.get(i).getButtonEdit();
                    dataSearch4 = array2d[i][3] = arrayListSearch.get(i).getButtonDelete();
                    model.addRow(row = new Object[]{dataSearch1, dataSearch2, dataSearch3, dataSearch4});
                }
            }
        });

        buttonsSearch[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 1; i <= 35; i++) {
                    buttonsSearch[i].setForeground(Color.cyan);
                }
                buttonAll.setForeground(Color.cyan);
                buttonsSearch[5].setForeground(Color.white);
                for (int i = 0; i < model.getRowCount(); ) {
                    model.removeRow(0);
                }
                for (int i = 20; i <= 24; i++) {
                    dataSearch1 = array2d[i][0] = arrayListSearch.get(i).getName();
                    dataSearch2 = array2d[i][1] = arrayListSearch.get(i).getPoint();
                    dataSearch3 = array2d[i][2] = arrayListSearch.get(i).getButtonEdit();
                    dataSearch4 = array2d[i][3] = arrayListSearch.get(i).getButtonDelete();
                    model.addRow(row = new Object[]{dataSearch1, dataSearch2, dataSearch3, dataSearch4});
                }
            }
        });

        buttonsSearch[6].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 1; i <= 35; i++) {
                    buttonsSearch[i].setForeground(Color.cyan);
                }
                buttonAll.setForeground(Color.cyan);
                buttonsSearch[6].setForeground(Color.white);
                for (int i = 0; i < model.getRowCount(); ) {
                    model.removeRow(0);
                }
                for (int i = 25; i <= 29; i++) {
                    dataSearch1 = array2d[i][0] = arrayListSearch.get(i).getName();
                    dataSearch2 = array2d[i][1] = arrayListSearch.get(i).getPoint();
                    dataSearch3 = array2d[i][2] = arrayListSearch.get(i).getButtonEdit();
                    dataSearch4 = array2d[i][3] = arrayListSearch.get(i).getButtonDelete();
                    model.addRow(row = new Object[]{dataSearch1, dataSearch2, dataSearch3, dataSearch4});
                }
            }
        });

        buttonsSearch[7].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 1; i <= 35; i++) {
                    buttonsSearch[i].setForeground(Color.cyan);
                }
                buttonAll.setForeground(Color.cyan);
                buttonsSearch[7].setForeground(Color.white);
                for (int i = 0; i < model.getRowCount(); ) {
                    model.removeRow(0);
                }
                for (int i = 30; i <= 34; i++) {
                    dataSearch1 = array2d[i][0] = arrayListSearch.get(i).getName();
                    dataSearch2 = array2d[i][1] = arrayListSearch.get(i).getPoint();
                    dataSearch3 = array2d[i][2] = arrayListSearch.get(i).getButtonEdit();
                    dataSearch4 = array2d[i][3] = arrayListSearch.get(i).getButtonDelete();
                    model.addRow(row = new Object[]{dataSearch1, dataSearch2, dataSearch3, dataSearch4});
                }
            }
        });

        buttonsSearch[8].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 1; i <= 35; i++) {
                    buttonsSearch[i].setForeground(Color.cyan);
                }
                buttonAll.setForeground(Color.cyan);
                buttonsSearch[8].setForeground(Color.white);
                for (int i = 0; i < model.getRowCount(); ) {
                    model.removeRow(0);
                }
                for (int i = 35; i <= 39; i++) {
                    dataSearch1 = array2d[i][0] = arrayListSearch.get(i).getName();
                    dataSearch2 = array2d[i][1] = arrayListSearch.get(i).getPoint();
                    dataSearch3 = array2d[i][2] = arrayListSearch.get(i).getButtonEdit();
                    dataSearch4 = array2d[i][3] = arrayListSearch.get(i).getButtonDelete();
                    model.addRow(row = new Object[]{dataSearch1, dataSearch2, dataSearch3, dataSearch4});
                }
            }
        });

        buttonsSearch[9].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 1; i <= 35; i++) {
                    buttonsSearch[i].setForeground(Color.cyan);
                }
                buttonAll.setForeground(Color.cyan);
                buttonsSearch[9].setForeground(Color.white);
                for (int i = 0; i < model.getRowCount(); ) {
                    model.removeRow(0);
                }
                for (int i = 40; i <= 44; i++) {
                    dataSearch1 = array2d[i][0] = arrayListSearch.get(i).getName();
                    dataSearch2 = array2d[i][1] = arrayListSearch.get(i).getPoint();
                    dataSearch3 = array2d[i][2] = arrayListSearch.get(i).getButtonEdit();
                    dataSearch4 = array2d[i][3] = arrayListSearch.get(i).getButtonDelete();
                    model.addRow(row = new Object[]{dataSearch1, dataSearch2, dataSearch3, dataSearch4});
                }
            }
        });

        buttonsSearch[10].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 1; i <= 35; i++) {
                    buttonsSearch[i].setForeground(Color.cyan);
                }
                buttonAll.setForeground(Color.cyan);
                buttonsSearch[10].setForeground(Color.white);
                for (int i = 0; i < model.getRowCount(); ) {
                    model.removeRow(0);
                }
                for (int i = 45; i <= 49; i++) {
                    dataSearch1 = array2d[i][0] = arrayListSearch.get(i).getName();
                    dataSearch2 = array2d[i][1] = arrayListSearch.get(i).getPoint();
                    dataSearch3 = array2d[i][2] = arrayListSearch.get(i).getButtonEdit();
                    dataSearch4 = array2d[i][3] = arrayListSearch.get(i).getButtonDelete();
                    model.addRow(row = new Object[]{dataSearch1, dataSearch2, dataSearch3, dataSearch4});
                }
            }
        });
    }

    public void setButtons() {
        for (int i = 1; i <= 35; i++) {
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == buttons[1]) {
                        save = 1;
                    }
                    if (e.getSource() == buttons[2]) {
                        save = 2;
                    }
                    if (e.getSource() == buttons[3]) {
                        save = 3;
                    }
                    if (e.getSource() == buttons[4]) {
                        save = 4;
                    }
                    if (e.getSource() == buttons[5]) {
                        save = 5;
                    }
                    if (e.getSource() == buttons[6]) {
                        save = 6;
                    }
                    if (e.getSource() == buttons[7]) {
                        save = 7;
                    }
                    if (e.getSource() == buttons[8]) {
                        save = 8;
                    }
                    if (e.getSource() == buttons[9]) {
                        save = 9;
                    }
                    if (e.getSource() == buttons[10]) {
                        save = 10;
                    }
                    if (e.getSource() == buttons[11]) {
                        save = 11;
                    }
                    if (e.getSource() == buttons[12]) {
                        save = 12;
                    }
                    if (e.getSource() == buttons[13]) {
                        save = 13;
                    }
                    if (e.getSource() == buttons[14]) {
                        save = 14;
                    }
                    if (e.getSource() == buttons[15]) {
                        save = 15;
                    }
                    if (e.getSource() == buttons[16]) {
                        save = 16;
                    }
                    if (e.getSource() == buttons[17]) {
                        save = 17;
                    }
                    if (e.getSource() == buttons[18]) {
                        save = 18;
                    }
                    if (e.getSource() == buttons[19]) {
                        save = 19;
                    }
                    if (e.getSource() == buttons[20]) {
                        save = 20;
                    }
                    if (e.getSource() == buttons[21]) {
                        save = 21;
                    }
                    if (e.getSource() == buttons[22]) {
                        save = 22;
                    }
                    if (e.getSource() == buttons[23]) {
                        save = 23;
                    }
                    if (e.getSource() == buttons[24]) {
                        save = 24;
                    }
                    if (e.getSource() == buttons[25]) {
                        save = 25;
                    }
                    if (e.getSource() == buttons[26]) {
                        save = 26;
                    }
                    if (e.getSource() == buttons[27]) {
                        save = 27;
                    }
                    if (e.getSource() == buttons[28]) {
                        save = 28;
                    }
                    if (e.getSource() == buttons[29]) {
                        save = 29;
                    }
                    if (e.getSource() == buttons[30]) {
                        save = 30;
                    }
                    if (e.getSource() == buttons[30]) {
                        save = 30;
                    }
                    if (e.getSource() == buttons[31]) {
                        save = 31;
                    }
                    if (e.getSource() == buttons[32]) {
                        save = 32;
                    }
                    if (e.getSource() == buttons[33]) {
                        save = 33;
                    }
                    if (e.getSource() == buttons[34]) {
                        save = 34;
                    }
                    if (e.getSource() == buttons[35]) {
                        save = 35;
                    }
                }
            });
        }
        buttonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (save <= 10) {
                    if (arrayList.size() >= 50) {
                        for (int i = 1; i <= 35; i++) {
                            buttons[i].setVisible(false);
                        }
                        for (int i = 10; i <= 20; i++) {
                            buttons[i].setVisible(true);
                            buttons[i].setBackground(Color.black);
                            buttons[i].setForeground(Color.cyan);
                        }
                        buttons[10].setForeground(Color.white);
                        buttons[35].setVisible(true);
                        buttonPrevious.setVisible(true);
                        save = 11;

                        for (int i = 0; i < model.getRowCount(); ) {
                            model.removeRow(0);
                        }
                        buttonAdd.setEnabled(false);
                        for (int i = 45; i <= 49; i++) {
                            convert1 = array2d[i][0] = arrayList.get(i).getName();
                            convert2 = array2d[i][1] = arrayList.get(i).getPoint();
                            convert3 = array2d[i][2] = arrayList.get(i).getButtonEdit();
                            convert4 = array2d[i][3] = arrayList.get(i).getButtonDelete();
                            model.addRow(row = new Object[]{convert1, convert2, convert3, convert4});
                        }
                        if (save == 11) {
                            return;
                        } else {
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Dữ liệu chưa đủ để hiển thị ra bảng", "Title", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                if (save <= 20) {
                    if (arrayList.size() >= 100) {
                        for (int i = 1; i <= 35; i++) {
                            buttons[i].setVisible(false);
                        }
                        for (int i = 20; i <= 30; i++) {
                            buttons[i].setVisible(true);
                            buttons[i].setBackground(Color.black);
                            buttons[i].setForeground(Color.cyan);
                        }
                        buttons[20].setForeground(Color.white);
                        buttons[35].setVisible(true);
                        buttonPrevious.setVisible(true);
                        save = 21;

                        for (int i = 0; i < model.getRowCount(); ) {
                            model.removeRow(0);
                        }
                        buttonAdd.setEnabled(false);
                        for (int i = 95; i <= 99; i++) {
                            convert1 = array2d[i][0] = arrayList.get(i).getName();
                            convert2 = array2d[i][1] = arrayList.get(i).getPoint();
                            convert3 = array2d[i][2] = arrayList.get(i).getButtonEdit();
                            convert4 = array2d[i][3] = arrayList.get(i).getButtonDelete();
                            model.addRow(row = new Object[]{convert1, convert2, convert3, convert4});
                        }
                        if (save == 21) {
                            return;
                        } else {
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Dữ liệu chưa đủ để hiển thị ra bảng", "Title", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                if (save <= 30) {
                    if (arrayList.size() >= 150) {
                        for (int i = 1; i <= 35; i++) {
                            buttons[i].setVisible(false);
                        }
                        for (int i = 30; i <= 35; i++) {
                            buttons[i].setVisible(true);
                            buttons[i].setBackground(Color.black);
                            buttons[i].setForeground(Color.cyan);
                        }
                        buttons[30].setForeground(Color.white);
                        label.setVisible(false);
                        buttonNext.setVisible(false);
                        buttonPrevious.setVisible(true);
                        save = 31;

                        for (int i = 0; i < model.getRowCount(); ) {
                            model.removeRow(0);
                        }
                        buttonAdd.setEnabled(false);
                        for (int i = 145; i <= 149; i++) {
                            convert1 = array2d[i][0] = arrayList.get(i).getName();
                            convert2 = array2d[i][1] = arrayList.get(i).getPoint();
                            convert3 = array2d[i][2] = arrayList.get(i).getButtonEdit();
                            convert4 = array2d[i][3] = arrayList.get(i).getButtonDelete();
                            model.addRow(row = new Object[]{convert1, convert2, convert3, convert4});
                        }
                        if (save == 31) {
                            return;
                        } else {
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Dữ liệu chưa đủ để hiển thị ra bảng", "Title", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }
        });
        buttonPrevious.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (save >= 30) {
                    if (arrayList.size() >= 150) {
                        for (int i = 1; i <= 35; i++) {
                            buttons[i].setVisible(false);
                        }
                        for (int i = 20; i <= 30; i++) {
                            buttons[i].setVisible(true);
                            buttons[i].setBackground(Color.black);
                            buttons[i].setForeground(Color.cyan);
                        }
                        buttons[30].setForeground(Color.white);
                        label.setVisible(true);
                        buttonNext.setVisible(true);
                        buttonPrevious.setVisible(true);
                        buttons[35].setVisible(true);
                        save = 29;

                        for (int i = 0; i < model.getRowCount(); ) {
                            model.removeRow(0);
                        }
                        buttonAdd.setEnabled(false);
                        for (int i = 145; i <= 149; i++) {
                            convert1 = array2d[i][0] = arrayList.get(i).getName();
                            convert2 = array2d[i][1] = arrayList.get(i).getPoint();
                            convert3 = array2d[i][2] = arrayList.get(i).getButtonEdit();
                            convert4 = array2d[i][3] = arrayList.get(i).getButtonDelete();
                            model.addRow(row = new Object[]{convert1, convert2, convert3, convert4});
                        }
                        if (save == 29) {
                            return;
                        } else {
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Dữ liệu chưa đủ để hiển thị ra bảng", "Title", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                if (save >= 20) {
                    if (arrayList.size() >= 100) {
                        for (int i = 1; i <= 35; i++) {
                            buttons[i].setVisible(false);
                        }
                        for (int i = 10; i <= 20; i++) {
                            buttons[i].setVisible(true);
                            buttons[i].setBackground(Color.black);
                            buttons[i].setForeground(Color.cyan);
                        }
                        buttons[20].setForeground(Color.white);
                        buttons[35].setVisible(true);
                        buttonPrevious.setVisible(true);
                        save = 19;

                        for (int i = 0; i < model.getRowCount(); ) {
                            model.removeRow(0);
                        }
                        buttonAdd.setEnabled(false);
                        for (int i = 95; i <= 99; i++) {
                            convert1 = array2d[i][0] = arrayList.get(i).getName();
                            convert2 = array2d[i][1] = arrayList.get(i).getPoint();
                            convert3 = array2d[i][2] = arrayList.get(i).getButtonEdit();
                            convert4 = array2d[i][3] = arrayList.get(i).getButtonDelete();
                            model.addRow(row = new Object[]{convert1, convert2, convert3, convert4});
                        }
                        if (save == 19) {
                            return;
                        } else {
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Dữ liệu chưa đủ để hiển thị ra bảng", "Title", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                if (save >= 10) {
                    if (arrayList.size() >= 50) {
                        for (int i = 1; i <= 35; i++) {
                            buttons[i].setVisible(false);
                        }
                        for (int i = 1; i <= 10; i++) {
                            buttons[i].setVisible(true);
                            buttons[i].setBackground(Color.black);
                            buttons[i].setForeground(Color.cyan);
                        }
                        buttons[10].setForeground(Color.white);
                        buttons[35].setVisible(true);
                        buttonPrevious.setVisible(false);
                        save = 9;

                        for (int i = 0; i < model.getRowCount(); ) {
                            model.removeRow(0);
                        }
                        buttonAdd.setEnabled(false);
                        for (int i = 45; i <= 49; i++) {
                            convert1 = array2d[i][0] = arrayList.get(i).getName();
                            convert2 = array2d[i][1] = arrayList.get(i).getPoint();
                            convert3 = array2d[i][2] = arrayList.get(i).getButtonEdit();
                            convert4 = array2d[i][3] = arrayList.get(i).getButtonDelete();
                            model.addRow(row = new Object[]{convert1, convert2, convert3, convert4});
                        }
                        if (save == 9) {
                            return;
                        } else {
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Dữ liệu chưa đủ để hiển thị ra bảng", "Title", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }
        });
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arrayList.size() <= 175) {
                    buttonDemo1 = new JButton(new ImageIcon("C:\\Users\\User\\Downloads\\icons8-edit-15.png"));
                    buttonDemo2 = new JButton(new ImageIcon("C:\\Users\\User\\Downloads\\icons8-delete-bin-15.png"));
                    arrayList.add(new BaseOfDemo(textFieldName.getText(), textFieldPoint.getText(), buttonDemo1, buttonDemo2));
                    array2d = new Object[arrayList.size()][4];
                    for (int i = 0; i < arrayList.size(); i++) {
                        data1 = array2d[i][0] = arrayList.get(i).getName();
                        data2 = array2d[i][1] = arrayList.get(i).getPoint();
                        data3 = array2d[i][2] = arrayList.get(i).getButtonEdit();
                        data4 = array2d[i][3] = arrayList.get(i).getButtonDelete();
                        table.getColumn("Edit").setCellRenderer(new ButtonCell3());
                        table.getColumn("Edit").setCellEditor(new ButtonCell3());
                        table.getColumn("Delete").setCellRenderer(new ButtonCell4());
                        table.getColumn("Delete").setCellEditor(new ButtonCell4());
                        imageIcon1 = new ImageIcon("C:\\Users\\User\\Downloads\\icons8-edit-15 (2).png");
                        imageIcon2 = new ImageIcon("C:\\Users\\User\\Downloads\\icons8-delete-bin-15 (1).png");
                    }
                    model.addRow(row = new Object[]{data1, data2, imageIcon1, imageIcon2});
                } else {
                    JOptionPane.showMessageDialog(null, "Bạn không thể nhập  thêm dữ liệu vì database đã hết dung lượng", "Title", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttonMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 1; i <= 35; i++) {
                    buttonsSearch[i].setVisible(false);
                }
                buttonAll.setVisible(false);

                for (int i = 1; i <= 35; i++) {
                    buttons[i].setBackground(Color.black);
                    buttons[i].setForeground(Color.cyan);
                }
                for (int i = 1; i <= 10; i++) {
                    buttons[i].setVisible(true);
                }
                label.setVisible(true);
                buttonNext.setVisible(true);
                save = 0;
                for (int i = 0; i < model.getRowCount(); ) {
                    model.removeRow(0);
                }
                for (int i = 0; i < arrayList.size(); i++) {
                    work1 = array2d[i][0] = arrayList.get(i).getName();
                    work2 = array2d[i][1] = arrayList.get(i).getPoint();
                    work3 = array2d[i][2] = arrayList.get(i).getButtonEdit();
                    work4 = array2d[i][3] = arrayList.get(i).getButtonDelete();
                    model.addRow(row = new Object[]{work1, work2, work3, work4});
                }
                buttonAdd.setEnabled(true);
            }
        });
        buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textFieldSearch.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Yêu cầu nhập phím", "Title", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    arrayListSearch.clear();
                    for (int i = 0; i < model.getRowCount(); ) {
                        model.removeRow(0);
                    }
                    buttonPrevious.setVisible(false);
                    buttonNext.setVisible(false);
                    label.setVisible(false);
                    buttonAdd.setEnabled(false);
                    buttonAll.setForeground(Color.WHITE);
                    for (int i = 1; i <= 35; i++) {
                        buttons[i].setVisible(false);
                    }
                    for (int i = 1; i <= 35; i++) {
                        buttonsSearch[i].setForeground(Color.cyan);
                        buttonsSearch[i].setVisible(false);
                    }
                    buttonAll.setVisible(true);
                    boolean a = false;
                    for (int i = 0; i < arrayList.size(); i++) {
                        if (arrayList.get(i).getName().equalsIgnoreCase(textFieldSearch.getText())) {
                            arrayListSearch.add(new BaseOfDemo(arrayList.get(i).getName(), arrayList.get(i).getPoint(), buttonDemo1, buttonDemo2)); // demo
                            a = true;
                            display1 = array2d[i][0] = arrayList.get(i).getName();
                            display2 = array2d[i][1] = arrayList.get(i).getPoint();
                            display3 = array2d[i][2] = arrayList.get(i).getButtonEdit();
                            display4 = array2d[i][3] = arrayList.get(i).getButtonDelete();
                            model.addRow(row = new Object[]{display1, display2, display3, display4});
                        }
                        int result = model.getRowCount() / 5;
                        for (int z = 1; z <= result; z++) {
                            buttonsSearch[z].setVisible(true);
                        }
                    }
                    if (a == false) {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy dữ liệu", "Title", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
        buttons[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arrayList.size() >= 5) {
                    for (int i = 1; i <= 35; i++) {
                        buttons[i].setVisible(false);
                    }
                    for (int i = 1; i <= 10; i++) {
                        buttons[i].setVisible(true);
                        buttons[i].setBackground(Color.black);
                        buttons[i].setForeground(Color.cyan);
                    }
                    buttons[1].setForeground(Color.white);
                    buttons[35].setVisible(true);
                    buttonPrevious.setVisible(false);

                    for (int i = 0; i < model.getRowCount(); ) {
                        model.removeRow(0);
                    }
                    buttonAdd.setEnabled(false);
                    for (int i = 0; i <= 4; i++) {
                        convert1 = array2d[i][0] = arrayList.get(i).getName();
                        convert2 = array2d[i][1] = arrayList.get(i).getPoint();
                        convert3 = array2d[i][2] = arrayList.get(i).getButtonEdit();
                        convert4 = array2d[i][3] = arrayList.get(i).getButtonDelete();
                        model.addRow(row = new Object[]{convert1, convert2, convert3, convert4});
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Dữ liệu chưa đủ để hiển thị ra bảng", "Title", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttons[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arrayList.size() >= 10) {
                    for (int i = 1; i <= 35; i++) {
                        buttons[i].setVisible(false);
                    }
                    for (int i = 1; i <= 10; i++) {
                        buttons[i].setVisible(true);
                        buttons[i].setBackground(Color.black);
                        buttons[i].setForeground(Color.cyan);
                    }
                    buttons[2].setForeground(Color.white);
                    buttons[35].setVisible(true);
                    buttonPrevious.setVisible(false);

                    for (int i = 0; i < model.getRowCount(); ) {
                        model.removeRow(0);
                    }
                    buttonAdd.setEnabled(false);
                    for (int i = 5; i <= 9; i++) {
                        convert1 = array2d[i][0] = arrayList.get(i).getName();
                        convert2 = array2d[i][1] = arrayList.get(i).getPoint();
                        convert3 = array2d[i][2] = arrayList.get(i).getButtonEdit();
                        convert4 = array2d[i][3] = arrayList.get(i).getButtonDelete();
                        model.addRow(row = new Object[]{convert1, convert2, convert3, convert4});
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Dữ liệu chưa đủ để hiển thị ra bảng", "Title", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttons[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arrayList.size() >= 15) {
                    for (int i = 1; i <= 35; i++) {
                        buttons[i].setVisible(false);
                    }
                    for (int i = 2; i <= 12; i++) {
                        buttons[i].setVisible(true);
                        buttons[i].setBackground(Color.black);
                        buttons[i].setForeground(Color.cyan);
                    }
                    buttons[3].setForeground(Color.white);
                    buttons[35].setVisible(true);
                    buttonPrevious.setVisible(false);

                    for (int i = 0; i < model.getRowCount(); ) {
                        model.removeRow(0);
                    }
                    buttonAdd.setEnabled(false);
                    for (int i = 10; i <= 14; i++) {
                        convert1 = array2d[i][0] = arrayList.get(i).getName();
                        convert2 = array2d[i][1] = arrayList.get(i).getPoint();
                        model.addRow(row = new Object[]{convert1, convert2});
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Dữ liệu chưa đủ để hiển thị ra bảng", "Title", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttons[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arrayList.size() >= 20) {
                    for (int i = 1; i <= 35; i++) {
                        buttons[i].setVisible(false);
                    }
                    for (int i = 3; i <= 13; i++) {
                        buttons[i].setVisible(true);
                        buttons[i].setBackground(Color.black);
                        buttons[i].setForeground(Color.cyan);
                    }
                    buttons[4].setForeground(Color.white);
                    buttons[35].setVisible(true);
                    buttonPrevious.setVisible(false);

                    for (int i = 0; i < model.getRowCount(); ) {
                        model.removeRow(0);
                    }
                    buttonAdd.setEnabled(false);
                    for (int i = 15; i <= 19; i++) {
                        convert1 = array2d[i][0] = arrayList.get(i).getName();
                        convert2 = array2d[i][1] = arrayList.get(i).getPoint();
                        convert3 = array2d[i][2] = arrayList.get(i).getButtonEdit();
                        convert4 = array2d[i][3] = arrayList.get(i).getButtonDelete();
                        model.addRow(row = new Object[]{convert1, convert2, convert3, convert4});
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Dữ liệu chưa đủ để hiển thị ra bảng", "Title", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttons[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arrayList.size() >= 25) {
                    for (int i = 1; i <= 35; i++) {
                        buttons[i].setVisible(false);
                    }
                    for (int i = 4; i <= 14; i++) {
                        buttons[i].setVisible(true);
                        buttons[i].setBackground(Color.black);
                        buttons[i].setForeground(Color.cyan);
                    }
                    buttons[5].setForeground(Color.white);
                    buttons[35].setVisible(true);
                    buttonPrevious.setVisible(false);

                    for (int i = 0; i < model.getRowCount(); ) {
                        model.removeRow(0);
                    }
                    buttonAdd.setEnabled(false);
                    for (int i = 20; i <= 24; i++) {
                        convert1 = array2d[i][0] = arrayList.get(i).getName();
                        convert2 = array2d[i][1] = arrayList.get(i).getPoint();
                        convert3 = array2d[i][2] = arrayList.get(i).getButtonEdit();
                        convert4 = array2d[i][3] = arrayList.get(i).getButtonDelete();
                        model.addRow(row = new Object[]{convert1, convert2, convert3, convert4});
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Dữ liệu chưa đủ để hiển thị ra bảng", "Title", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttons[6].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arrayList.size() >= 30) {
                    for (int i = 1; i <= 35; i++) {
                        buttons[i].setVisible(false);
                    }
                    for (int i = 5; i <= 15; i++) {
                        buttons[i].setVisible(true);
                        buttons[i].setBackground(Color.black);
                        buttons[i].setForeground(Color.cyan);
                    }
                    buttons[6].setForeground(Color.white);
                    buttons[35].setVisible(true);
                    buttonPrevious.setVisible(false);

                    for (int i = 0; i < model.getRowCount(); ) {
                        model.removeRow(0);
                    }
                    buttonAdd.setEnabled(false);
                    for (int i = 25; i <= 29; i++) {
                        convert1 = array2d[i][0] = arrayList.get(i).getName();
                        convert2 = array2d[i][1] = arrayList.get(i).getPoint();
                        convert3 = array2d[i][2] = arrayList.get(i).getButtonEdit();
                        convert4 = array2d[i][3] = arrayList.get(i).getButtonDelete();
                        model.addRow(row = new Object[]{convert1, convert2, convert3, convert4});
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Dữ liệu chưa đủ để hiển thị ra bảng", "Title", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttons[7].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arrayList.size() >= 35) {
                    for (int i = 1; i <= 35; i++) {
                        buttons[i].setVisible(false);
                    }
                    for (int i = 6; i <= 16; i++) {
                        buttons[i].setVisible(true);
                        buttons[i].setBackground(Color.black);
                        buttons[i].setForeground(Color.cyan);
                    }
                    buttons[7].setForeground(Color.white);
                    buttons[35].setVisible(true);
                    buttonPrevious.setVisible(false);

                    for (int i = 0; i < model.getRowCount(); ) {
                        model.removeRow(0);
                    }
                    buttonAdd.setEnabled(false);
                    for (int i = 30; i <= 34; i++) {
                        convert1 = array2d[i][0] = arrayList.get(i).getName();
                        convert2 = array2d[i][1] = arrayList.get(i).getPoint();
                        convert3 = array2d[i][2] = arrayList.get(i).getButtonEdit();
                        convert4 = array2d[i][3] = arrayList.get(i).getButtonDelete();
                        model.addRow(row = new Object[]{convert1, convert2, convert3, convert4});
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Dữ liệu chưa đủ để hiển thị ra bảng", "Title", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttons[8].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arrayList.size() >= 40) {
                    for (int i = 1; i <= 35; i++) {
                        buttons[i].setVisible(false);
                    }
                    for (int i = 7; i <= 17; i++) {
                        buttons[i].setVisible(true);
                        buttons[i].setBackground(Color.black);
                        buttons[i].setForeground(Color.cyan);
                    }
                    buttons[8].setForeground(Color.white);
                    buttons[35].setVisible(true);
                    buttonPrevious.setVisible(false);

                    for (int i = 0; i < model.getRowCount(); ) {
                        model.removeRow(0);
                    }
                    buttonAdd.setEnabled(false);
                    for (int i = 35; i <= 39; i++) {
                        convert1 = array2d[i][0] = arrayList.get(i).getName();
                        convert2 = array2d[i][1] = arrayList.get(i).getPoint();
                        convert3 = array2d[i][2] = arrayList.get(i).getButtonEdit();
                        convert4 = array2d[i][3] = arrayList.get(i).getButtonDelete();
                        model.addRow(row = new Object[]{convert1, convert2, convert3, convert4});
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Dữ liệu chưa đủ để hiển thị ra bảng", "Title", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttons[9].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arrayList.size() >= 45) {  // old value  = 40 // the new vaule is +1 then i <= 44 ;
                    for (int i = 1; i <= 35; i++) {
                        buttons[i].setVisible(false);
                    }
                    for (int i = 8; i <= 18; i++) {
                        buttons[i].setVisible(true);
                        buttons[i].setBackground(Color.black);
                        buttons[i].setForeground(Color.cyan);
                    }
                    buttons[9].setForeground(Color.white);
                    buttons[35].setVisible(true);
                    buttonPrevious.setVisible(false);

                    for (int i = 0; i < model.getRowCount(); ) {
                        model.removeRow(0);
                    }
                    buttonAdd.setEnabled(false);
                    for (int i = 40; i <= 44; i++) {
                        convert1 = array2d[i][0] = arrayList.get(i).getName();
                        convert2 = array2d[i][1] = arrayList.get(i).getPoint();
                        convert3 = array2d[i][2] = arrayList.get(i).getButtonEdit();
                        convert4 = array2d[i][3] = arrayList.get(i).getButtonDelete();
                        model.addRow(row = new Object[]{convert1, convert2, convert3, convert4});
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Dữ liệu chưa đủ để hiển thị ra bảng", "Title", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttons[10].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arrayList.size() >= 50) {
                    for (int i = 1; i <= 35; i++) {
                        buttons[i].setVisible(false);
                    }
                    for (int i = 9; i <= 19; i++) {
                        buttons[i].setVisible(true);
                        buttons[i].setBackground(Color.black);
                        buttons[i].setForeground(Color.cyan);
                    }
                    buttons[10].setForeground(Color.white);
                    buttons[35].setVisible(true);
                    buttonPrevious.setVisible(true);

                    for (int i = 0; i < model.getRowCount(); ) {
                        model.removeRow(0);
                    }
                    buttonAdd.setEnabled(false);
                    for (int i = 45; i <= 49; i++) {
                        convert1 = array2d[i][0] = arrayList.get(i).getName();
                        convert2 = array2d[i][1] = arrayList.get(i).getPoint();
                        convert3 = array2d[i][2] = arrayList.get(i).getButtonEdit();
                        convert4 = array2d[i][3] = arrayList.get(i).getButtonDelete();
                        model.addRow(row = new Object[]{convert1, convert2, convert3, convert4});
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Dữ liệu chưa đủ để hiển thị ra bảng", "Title", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttons[11].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arrayList.size() >= 55) {
                    for (int i = 1; i <= 35; i++) {
                        buttons[i].setVisible(false);
                    }
                    for (int i = 10; i <= 20; i++) {
                        buttons[i].setVisible(true);
                        buttons[i].setBackground(Color.black);
                        buttons[i].setForeground(Color.cyan);
                    }
                    buttons[11].setForeground(Color.white);
                    buttons[35].setVisible(true);
                    buttonPrevious.setVisible(true);

                    for (int i = 0; i < model.getRowCount(); ) {
                        model.removeRow(0);
                    }
                    buttonAdd.setEnabled(false);
                    for (int i = 50; i <= 54; i++) {
                        convert1 = array2d[i][0] = arrayList.get(i).getName();
                        convert2 = array2d[i][1] = arrayList.get(i).getPoint();
                        convert3 = array2d[i][2] = arrayList.get(i).getButtonEdit();
                        convert4 = array2d[i][3] = arrayList.get(i).getButtonDelete();
                        model.addRow(row = new Object[]{convert1, convert2, convert3, convert4});
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Dữ liệu chưa đủ để hiển thị ra bảng", "Title", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttons[12].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arrayList.size() >= 60) {
                    for (int i = 1; i <= 35; i++) {
                        buttons[i].setVisible(false);
                    }
                    for (int i = 11; i <= 21; i++) {
                        buttons[i].setVisible(true);
                        buttons[i].setBackground(Color.black);
                        buttons[i].setForeground(Color.cyan);
                    }
                    buttons[12].setForeground(Color.white);
                    buttons[35].setVisible(true);
                    buttonPrevious.setVisible(true);

                    for (int i = 0; i < model.getRowCount(); ) {
                        model.removeRow(0);
                    }
                    buttonAdd.setEnabled(false);
                    for (int i = 55; i <= 59; i++) {
                        convert1 = array2d[i][0] = arrayList.get(i).getName();
                        convert2 = array2d[i][1] = arrayList.get(i).getPoint();
                        convert3 = array2d[i][2] = arrayList.get(i).getButtonEdit();
                        convert4 = array2d[i][3] = arrayList.get(i).getButtonDelete();
                        model.addRow(row = new Object[]{convert1, convert2, convert3, convert4});
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Dữ liệu chưa đủ để hiển thị ra bảng", "Title", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttons[13].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arrayList.size() >= 65) {
                    for (int i = 1; i <= 35; i++) {
                        buttons[i].setVisible(false);
                    }
                    for (int i = 12; i <= 22; i++) {
                        buttons[i].setVisible(true);
                        buttons[i].setBackground(Color.black);
                        buttons[i].setForeground(Color.cyan);
                    }
                    buttons[13].setForeground(Color.white);
                    buttons[35].setVisible(true);
                    buttonPrevious.setVisible(true);

                    for (int i = 0; i < model.getRowCount(); ) {
                        model.removeRow(0);
                    }
                    buttonAdd.setEnabled(false);
                    for (int i = 60; i <= 64; i++) {
                        convert1 = array2d[i][0] = arrayList.get(i).getName();
                        convert2 = array2d[i][1] = arrayList.get(i).getPoint();
                        convert3 = array2d[i][2] = arrayList.get(i).getButtonEdit();
                        convert4 = array2d[i][3] = arrayList.get(i).getButtonDelete();
                        model.addRow(row = new Object[]{convert1, convert2, convert3, convert4});
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Dữ liệu chưa đủ để hiển thị ra bảng", "Title", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttons[14].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arrayList.size() >= 70) {
                    for (int i = 1; i <= 35; i++) {
                        buttons[i].setVisible(false);
                    }
                    for (int i = 13; i <= 23; i++) {
                        buttons[i].setVisible(true);
                        buttons[i].setBackground(Color.black);
                        buttons[i].setForeground(Color.cyan);
                    }
                    buttons[14].setForeground(Color.white);
                    buttons[35].setVisible(true);
                    buttonPrevious.setVisible(true);

                    for (int i = 0; i < model.getRowCount(); ) {
                        model.removeRow(0);
                    }
                    buttonAdd.setEnabled(false);
                    for (int i = 65; i <= 69; i++) {
                        convert1 = array2d[i][0] = arrayList.get(i).getName();
                        convert2 = array2d[i][1] = arrayList.get(i).getPoint();
                        convert3 = array2d[i][2] = arrayList.get(i).getButtonEdit();
                        convert4 = array2d[i][3] = arrayList.get(i).getButtonDelete();
                        model.addRow(row = new Object[]{convert1, convert2, convert3, convert4});
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Dữ liệu chưa đủ để hiển thị ra bảng", "Title", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttons[15].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arrayList.size() >= 75) {
                    for (int i = 1; i <= 35; i++) {
                        buttons[i].setVisible(false);
                    }
                    for (int i = 14; i <= 24; i++) {
                        buttons[i].setVisible(true);
                        buttons[i].setBackground(Color.black);
                        buttons[i].setForeground(Color.cyan);
                    }
                    buttons[15].setForeground(Color.white);
                    buttons[35].setVisible(true);
                    buttonPrevious.setVisible(true);

                    for (int i = 0; i < model.getRowCount(); ) {
                        model.removeRow(0);
                    }
                    buttonAdd.setEnabled(false);
                    for (int i = 70; i <= 74; i++) {
                        convert1 = array2d[i][0] = arrayList.get(i).getName();
                        convert2 = array2d[i][1] = arrayList.get(i).getPoint();
                        convert3 = array2d[i][2] = arrayList.get(i).getButtonEdit();
                        convert4 = array2d[i][3] = arrayList.get(i).getButtonDelete();
                        model.addRow(row = new Object[]{convert1, convert2, convert3, convert4});
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Dữ liệu chưa đủ để hiển thị ra bảng", "Title", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttons[16].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arrayList.size() >= 80) {
                    for (int i = 1; i <= 35; i++) {
                        buttons[i].setVisible(false);
                    }
                    for (int i = 15; i <= 25; i++) {
                        buttons[i].setVisible(true);
                        buttons[i].setBackground(Color.black);
                        buttons[i].setForeground(Color.cyan);
                    }
                    buttons[16].setForeground(Color.white);
                    buttons[35].setVisible(true);
                    buttonPrevious.setVisible(true);

                    for (int i = 0; i < model.getRowCount(); ) {
                        model.removeRow(0);
                    }
                    buttonAdd.setEnabled(false);
                    for (int i = 75; i <= 79; i++) {
                        convert1 = array2d[i][0] = arrayList.get(i).getName();
                        convert2 = array2d[i][1] = arrayList.get(i).getPoint();
                        convert3 = array2d[i][2] = arrayList.get(i).getButtonEdit();
                        convert4 = array2d[i][3] = arrayList.get(i).getButtonDelete();
                        model.addRow(row = new Object[]{convert1, convert2, convert3, convert4});
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Dữ liệu chưa đủ để hiển thị ra bảng", "Title", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttons[17].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arrayList.size() >= 85) {
                    for (int i = 1; i <= 35; i++) {
                        buttons[i].setVisible(false);
                    }
                    for (int i = 16; i <= 26; i++) {
                        buttons[i].setVisible(true);
                        buttons[i].setBackground(Color.black);
                        buttons[i].setForeground(Color.cyan);
                    }
                    buttons[17].setForeground(Color.white);
                    buttons[35].setVisible(true);
                    buttonPrevious.setVisible(true);

                    for (int i = 0; i < model.getRowCount(); ) {
                        model.removeRow(0);
                    }
                    buttonAdd.setEnabled(false);
                    for (int i = 80; i <= 84; i++) {
                        convert1 = array2d[i][0] = arrayList.get(i).getName();
                        convert2 = array2d[i][1] = arrayList.get(i).getPoint();
                        convert3 = array2d[i][2] = arrayList.get(i).getButtonEdit();
                        convert4 = array2d[i][3] = arrayList.get(i).getButtonDelete();
                        model.addRow(row = new Object[]{convert1, convert2, convert3, convert4});
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Dữ liệu chưa đủ để hiển thị ra bảng", "Title", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttons[18].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arrayList.size() >= 90) {
                    for (int i = 1; i <= 35; i++) {
                        buttons[i].setVisible(false);
                    }
                    for (int i = 17; i <= 27; i++) {
                        buttons[i].setVisible(true);
                        buttons[i].setBackground(Color.black);
                        buttons[i].setForeground(Color.cyan);
                    }
                    buttons[18].setForeground(Color.white);
                    buttons[35].setVisible(true);
                    buttonPrevious.setVisible(true);

                    for (int i = 0; i < model.getRowCount(); ) {
                        model.removeRow(0);
                    }
                    buttonAdd.setEnabled(false);
                    for (int i = 85; i <= 89; i++) {
                        convert1 = array2d[i][0] = arrayList.get(i).getName();
                        convert2 = array2d[i][1] = arrayList.get(i).getPoint();
                        convert3 = array2d[i][2] = arrayList.get(i).getButtonEdit();
                        convert4 = array2d[i][3] = arrayList.get(i).getButtonDelete();
                        model.addRow(row = new Object[]{convert1, convert2, convert3, convert4});
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Dữ liệu chưa đủ để hiển thị ra bảng", "Title", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttons[19].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arrayList.size() >= 95) {
                    for (int i = 1; i <= 35; i++) {
                        buttons[i].setVisible(false);
                    }
                    for (int i = 18; i <= 28; i++) {
                        buttons[i].setVisible(true);
                        buttons[i].setBackground(Color.black);
                        buttons[i].setForeground(Color.cyan);
                    }
                    buttons[19].setForeground(Color.white);
                    buttons[35].setVisible(true);
                    buttonPrevious.setVisible(true);

                    for (int i = 0; i < model.getRowCount(); ) {
                        model.removeRow(0);
                    }
                    buttonAdd.setEnabled(false);
                    for (int i = 90; i <= 94; i++) {
                        convert1 = array2d[i][0] = arrayList.get(i).getName();
                        convert2 = array2d[i][1] = arrayList.get(i).getPoint();
                        convert3 = array2d[i][2] = arrayList.get(i).getButtonEdit();
                        convert4 = array2d[i][3] = arrayList.get(i).getButtonDelete();
                        model.addRow(row = new Object[]{convert1, convert2, convert3, convert4});
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Dữ liệu chưa đủ để hiển thị ra bảng", "Title", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttons[20].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arrayList.size() >= 100) {
                    for (int i = 1; i <= 35; i++) {
                        buttons[i].setVisible(false);
                    }
                    for (int i = 19; i <= 29; i++) {
                        buttons[i].setVisible(true);
                        buttons[i].setBackground(Color.black);
                        buttons[i].setForeground(Color.cyan);
                    }
                    buttons[20].setForeground(Color.white);
                    buttons[35].setVisible(true);
                    buttonPrevious.setVisible(true);

                    for (int i = 0; i < model.getRowCount(); ) {
                        model.removeRow(0);
                    }
                    buttonAdd.setEnabled(false);
                    for (int i = 95; i <= 99; i++) {
                        convert1 = array2d[i][0] = arrayList.get(i).getName();
                        convert2 = array2d[i][1] = arrayList.get(i).getPoint();
                        convert3 = array2d[i][2] = arrayList.get(i).getButtonEdit();
                        convert4 = array2d[i][3] = arrayList.get(i).getButtonDelete();
                        model.addRow(row = new Object[]{convert1, convert2, convert3, convert4});
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Dữ liệu chưa đủ để hiển thị ra bảng", "Title", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttons[21].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arrayList.size() >= 105) {
                    for (int i = 1; i <= 35; i++) {
                        buttons[i].setVisible(false);
                    }
                    for (int i = 20; i <= 30; i++) {
                        buttons[i].setVisible(true);
                        buttons[i].setBackground(Color.black);
                        buttons[i].setForeground(Color.cyan);
                    }
                    buttons[21].setForeground(Color.white);
                    buttons[35].setVisible(true);
                    buttonPrevious.setVisible(true);

                    for (int i = 0; i < model.getRowCount(); ) {
                        model.removeRow(0);
                    }
                    buttonAdd.setEnabled(false);
                    for (int i = 100; i <= 104; i++) {
                        convert1 = array2d[i][0] = arrayList.get(i).getName();
                        convert2 = array2d[i][1] = arrayList.get(i).getPoint();
                        convert3 = array2d[i][2] = arrayList.get(i).getButtonEdit();
                        convert4 = array2d[i][3] = arrayList.get(i).getButtonDelete();
                        model.addRow(row = new Object[]{convert1, convert2, convert3, convert4});
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Dữ liệu chưa đủ để hiển thị ra bảng", "Title", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttons[22].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arrayList.size() >= 110) {
                    for (int i = 1; i <= 35; i++) {
                        buttons[i].setVisible(false);
                    }
                    for (int i = 21; i <= 31; i++) {
                        buttons[i].setVisible(true);
                        buttons[i].setBackground(Color.black);
                        buttons[i].setForeground(Color.cyan);
                    }
                    buttons[22].setForeground(Color.white);
                    buttons[35].setVisible(true);
                    buttonPrevious.setVisible(true);

                    for (int i = 0; i < model.getRowCount(); ) {
                        model.removeRow(0);
                    }
                    buttonAdd.setEnabled(false);
                    for (int i = 105; i <= 109; i++) {
                        convert1 = array2d[i][0] = arrayList.get(i).getName();
                        convert2 = array2d[i][1] = arrayList.get(i).getPoint();
                        convert3 = array2d[i][2] = arrayList.get(i).getButtonEdit();
                        convert4 = array2d[i][3] = arrayList.get(i).getButtonDelete();
                        model.addRow(row = new Object[]{convert1, convert2, convert3, convert4});
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Dữ liệu chưa đủ để hiển thị ra bảng", "Title", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttons[23].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arrayList.size() >= 115) {
                    for (int i = 1; i <= 35; i++) {
                        buttons[i].setVisible(false);
                    }
                    for (int i = 22; i <= 32; i++) {
                        buttons[i].setVisible(true);
                        buttons[i].setBackground(Color.black);
                        buttons[i].setForeground(Color.cyan);
                    }
                    buttons[23].setForeground(Color.white);
                    buttons[35].setVisible(true);
                    buttonPrevious.setVisible(true);

                    for (int i = 0; i < model.getRowCount(); ) {
                        model.removeRow(0);
                    }
                    buttonAdd.setEnabled(false);
                    for (int i = 110; i <= 114; i++) {
                        convert1 = array2d[i][0] = arrayList.get(i).getName();
                        convert2 = array2d[i][1] = arrayList.get(i).getPoint();
                        convert3 = array2d[i][2] = arrayList.get(i).getButtonEdit();
                        convert4 = array2d[i][3] = arrayList.get(i).getButtonDelete();
                        model.addRow(row = new Object[]{convert1, convert2, convert3, convert4});
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Dữ liệu chưa đủ để hiển thị ra bảng", "Title", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttons[24].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arrayList.size() >= 120) {
                    for (int i = 1; i <= 35; i++) {
                        buttons[i].setVisible(false);
                    }
                    for (int i = 23; i <= 33; i++) {
                        buttons[i].setVisible(true);
                        buttons[i].setBackground(Color.black);
                        buttons[i].setForeground(Color.cyan);
                    }
                    buttons[24].setForeground(Color.white);
                    buttons[35].setVisible(true);
                    buttonPrevious.setVisible(true);

                    for (int i = 0; i < model.getRowCount(); ) {
                        model.removeRow(0);
                    }
                    buttonAdd.setEnabled(false);
                    for (int i = 115; i <= 119; i++) {
                        convert1 = array2d[i][0] = arrayList.get(i).getName();
                        convert2 = array2d[i][1] = arrayList.get(i).getPoint();
                        convert3 = array2d[i][2] = arrayList.get(i).getButtonEdit();
                        convert4 = array2d[i][3] = arrayList.get(i).getButtonDelete();
                        model.addRow(row = new Object[]{convert1, convert2, convert3, convert4});
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Dữ liệu chưa đủ để hiển thị ra bảng", "Title", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttons[25].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arrayList.size() >= 125) {
                    for (int i = 1; i <= 35; i++) {
                        buttons[i].setVisible(false);
                    }
                    for (int i = 24; i <= 34; i++) {
                        buttons[i].setVisible(true);
                        buttons[i].setBackground(Color.black);
                        buttons[i].setForeground(Color.cyan);
                    }
                    buttons[25].setForeground(Color.white);
                    buttons[35].setVisible(true);
                    buttonPrevious.setVisible(true);

                    for (int i = 0; i < model.getRowCount(); ) {
                        model.removeRow(0);
                    }
                    buttonAdd.setEnabled(false);
                    for (int i = 120; i <= 124; i++) {
                        convert1 = array2d[i][0] = arrayList.get(i).getName();
                        convert2 = array2d[i][1] = arrayList.get(i).getPoint();
                        convert3 = array2d[i][2] = arrayList.get(i).getButtonEdit();
                        convert4 = array2d[i][3] = arrayList.get(i).getButtonDelete();
                        model.addRow(row = new Object[]{convert1, convert2, convert3, convert4});
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Dữ liệu chưa đủ để hiển thị ra bảng", "Title", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttons[26].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arrayList.size() >= 130) {
                    for (int i = 1; i <= 35; i++) {
                        buttons[i].setVisible(false);
                    }
                    for (int i = 25; i <= 35; i++) {
                        buttons[i].setVisible(true);
                        buttons[i].setBackground(Color.black);
                        buttons[i].setForeground(Color.cyan);
                    }
                    buttons[26].setForeground(Color.white);
                    label.setVisible(false);
                    buttonNext.setVisible(false);
                    buttonPrevious.setVisible(true);

                    for (int i = 0; i < model.getRowCount(); ) {
                        model.removeRow(0);
                    }
                    buttonAdd.setEnabled(false);
                    for (int i = 125; i <= 129; i++) {
                        convert1 = array2d[i][0] = arrayList.get(i).getName();
                        convert2 = array2d[i][1] = arrayList.get(i).getPoint();
                        convert3 = array2d[i][2] = arrayList.get(i).getButtonEdit();
                        convert4 = array2d[i][3] = arrayList.get(i).getButtonDelete();
                        model.addRow(row = new Object[]{convert1, convert2, convert3, convert4});
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Dữ liệu chưa đủ để hiển thị ra bảng", "Title", JOptionPane.ERROR_MESSAGE);
                }
            }
        }); // this 26 of 25
        buttons[27].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arrayList.size() >= 135) {
                    for (int i = 1; i <= 35; i++) {
                        buttons[i].setVisible(false);
                    }
                    for (int i = 25; i <= 35; i++) {
                        buttons[i].setVisible(true);
                        buttons[i].setBackground(Color.black);
                        buttons[i].setForeground(Color.cyan);
                    }
                    buttons[27].setForeground(Color.white);
                    label.setVisible(false);
                    buttonNext.setVisible(false);
                    buttonPrevious.setVisible(true);

                    for (int i = 0; i < model.getRowCount(); ) {
                        model.removeRow(0);
                    }
                    buttonAdd.setEnabled(false);
                    for (int i = 130; i <= 134; i++) {
                        convert1 = array2d[i][0] = arrayList.get(i).getName();
                        convert2 = array2d[i][1] = arrayList.get(i).getPoint();
                        convert3 = array2d[i][2] = arrayList.get(i).getButtonEdit();
                        convert4 = array2d[i][3] = arrayList.get(i).getButtonDelete();
                        model.addRow(row = new Object[]{convert1, convert2, convert3, convert4});
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Dữ liệu chưa đủ để hiển thị ra bảng", "Title", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttons[28].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arrayList.size() >= 140) {
                    for (int i = 1; i <= 35; i++) {
                        buttons[i].setVisible(false);
                    }
                    for (int i = 25; i <= 35; i++) {
                        buttons[i].setVisible(true);
                        buttons[i].setBackground(Color.black);
                        buttons[i].setForeground(Color.cyan);
                    }
                    buttons[28].setForeground(Color.white);
                    label.setVisible(false);
                    buttonNext.setVisible(false);
                    buttonPrevious.setVisible(true);

                    for (int i = 0; i < model.getRowCount(); ) {
                        model.removeRow(0);
                    }
                    buttonAdd.setEnabled(false);
                    for (int i = 135; i <= 139; i++) {
                        convert1 = array2d[i][0] = arrayList.get(i).getName();
                        convert2 = array2d[i][1] = arrayList.get(i).getPoint();
                        convert3 = array2d[i][2] = arrayList.get(i).getButtonEdit();
                        convert4 = array2d[i][3] = arrayList.get(i).getButtonDelete();
                        model.addRow(row = new Object[]{convert1, convert2, convert3, convert4});
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Dữ liệu chưa đủ để hiển thị ra bảng", "Title", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttons[29].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arrayList.size() >= 145) {
                    for (int i = 1; i <= 35; i++) {
                        buttons[i].setVisible(false);
                    }
                    for (int i = 25; i <= 35; i++) {
                        buttons[i].setVisible(true);
                        buttons[i].setBackground(Color.black);
                        buttons[i].setForeground(Color.cyan);
                    }
                    buttons[29].setForeground(Color.white);
                    label.setVisible(false);
                    buttonNext.setVisible(false);
                    buttonPrevious.setVisible(true);

                    for (int i = 0; i < model.getRowCount(); ) {
                        model.removeRow(0);
                    }
                    buttonAdd.setEnabled(false);
                    for (int i = 140; i <= 144; i++) {
                        convert1 = array2d[i][0] = arrayList.get(i).getName();
                        convert2 = array2d[i][1] = arrayList.get(i).getPoint();
                        convert3 = array2d[i][2] = arrayList.get(i).getButtonEdit();
                        convert4 = array2d[i][3] = arrayList.get(i).getButtonDelete();
                        model.addRow(row = new Object[]{convert1, convert2, convert3, convert4});
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Dữ liệu chưa đủ để hiển thị ra bảng", "Title", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttons[30].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arrayList.size() >= 150) {
                    for (int i = 1; i <= 35; i++) {
                        buttons[i].setVisible(false);
                    }
                    for (int i = 25; i <= 35; i++) {
                        buttons[i].setVisible(true);
                        buttons[i].setBackground(Color.black);
                        buttons[i].setForeground(Color.cyan);
                    }
                    buttons[30].setForeground(Color.white);
                    label.setVisible(false);
                    buttonNext.setVisible(false);
                    buttonPrevious.setVisible(true);

                    for (int i = 0; i < model.getRowCount(); ) {
                        model.removeRow(0);
                    }
                    buttonAdd.setEnabled(false);
                    for (int i = 145; i <= 149; i++) {
                        convert1 = array2d[i][0] = arrayList.get(i).getName();
                        convert2 = array2d[i][1] = arrayList.get(i).getPoint();
                        convert3 = array2d[i][2] = arrayList.get(i).getButtonEdit();
                        convert4 = array2d[i][3] = arrayList.get(i).getButtonDelete();
                        model.addRow(row = new Object[]{convert1, convert2, convert3, convert4});
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Dữ liệu chưa đủ để hiển thị ra bảng", "Title", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttons[31].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arrayList.size() >= 155) {
                    for (int i = 1; i <= 35; i++) {
                        buttons[i].setVisible(false);
                    }
                    for (int i = 25; i <= 35; i++) {
                        buttons[i].setVisible(true);
                        buttons[i].setBackground(Color.black);
                        buttons[i].setForeground(Color.cyan);
                    }
                    buttons[31].setForeground(Color.white);
                    label.setVisible(false);
                    buttonNext.setVisible(false);
                    buttonPrevious.setVisible(true);

                    for (int i = 0; i < model.getRowCount(); ) {
                        model.removeRow(0);
                    }
                    buttonAdd.setEnabled(false);
                    for (int i = 150; i <= 154; i++) {
                        convert1 = array2d[i][0] = arrayList.get(i).getName();
                        convert2 = array2d[i][1] = arrayList.get(i).getPoint();
                        convert3 = array2d[i][2] = arrayList.get(i).getButtonEdit();
                        convert4 = array2d[i][3] = arrayList.get(i).getButtonDelete();
                        model.addRow(row = new Object[]{convert1, convert2, convert3, convert4});
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Dữ liệu chưa đủ để hiển thị ra bảng", "Title", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttons[32].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arrayList.size() >= 160) {
                    for (int i = 1; i <= 35; i++) {
                        buttons[i].setVisible(false);
                    }
                    for (int i = 25; i <= 35; i++) {
                        buttons[i].setVisible(true);
                        buttons[i].setBackground(Color.black);
                        buttons[i].setForeground(Color.cyan);
                    }
                    buttons[32].setForeground(Color.white);
                    label.setVisible(false);
                    buttonNext.setVisible(false);
                    buttonPrevious.setVisible(true);

                    for (int i = 0; i < model.getRowCount(); ) {
                        model.removeRow(0);
                    }
                    buttonAdd.setEnabled(false);
                    for (int i = 155; i <= 159; i++) {
                        convert1 = array2d[i][0] = arrayList.get(i).getName();
                        convert2 = array2d[i][1] = arrayList.get(i).getPoint();
                        convert3 = array2d[i][2] = arrayList.get(i).getButtonEdit();
                        convert4 = array2d[i][3] = arrayList.get(i).getButtonDelete();
                        model.addRow(row = new Object[]{convert1, convert2, convert3, convert4});
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Dữ liệu chưa đủ để hiển thị ra bảng", "Title", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttons[33].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arrayList.size() >= 165) {
                    for (int i = 1; i <= 35; i++) {
                        buttons[i].setVisible(false);
                    }
                    for (int i = 25; i <= 35; i++) {
                        buttons[i].setVisible(true);
                        buttons[i].setBackground(Color.black);
                        buttons[i].setForeground(Color.cyan);
                    }
                    buttons[33].setForeground(Color.white);
                    label.setVisible(false);
                    buttonNext.setVisible(false);
                    buttonPrevious.setVisible(true);

                    for (int i = 0; i < model.getRowCount(); ) {
                        model.removeRow(0);
                    }
                    buttonAdd.setEnabled(false);
                    for (int i = 160; i <= 164; i++) {
                        convert1 = array2d[i][0] = arrayList.get(i).getName();
                        convert2 = array2d[i][1] = arrayList.get(i).getPoint();
                        convert3 = array2d[i][2] = arrayList.get(i).getButtonEdit();
                        convert4 = array2d[i][3] = arrayList.get(i).getButtonDelete();
                        model.addRow(row = new Object[]{convert1, convert2, convert3, convert4});
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Dữ liệu chưa đủ để hiển thị ra bảng", "Title", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttons[34].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arrayList.size() >= 170) {
                    for (int i = 1; i <= 35; i++) {
                        buttons[i].setVisible(false);
                    }
                    for (int i = 25; i <= 35; i++) {
                        buttons[i].setVisible(true);
                        buttons[i].setBackground(Color.black);
                        buttons[i].setForeground(Color.cyan);
                    }
                    buttons[34].setForeground(Color.white);
                    label.setVisible(false);
                    buttonNext.setVisible(false);
                    buttonPrevious.setVisible(true);

                    for (int i = 0; i < model.getRowCount(); ) {
                        model.removeRow(0);
                    }
                    buttonAdd.setEnabled(false);
                    for (int i = 165; i <= 169; i++) {
                        convert1 = array2d[i][0] = arrayList.get(i).getName();
                        convert2 = array2d[i][1] = arrayList.get(i).getPoint();
                        convert3 = array2d[i][2] = arrayList.get(i).getButtonEdit();
                        convert4 = array2d[i][3] = arrayList.get(i).getButtonDelete();
                        model.addRow(row = new Object[]{convert1, convert2, convert3, convert4});
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Dữ liệu chưa đủ để hiển thị ra bảng", "Title", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttons[35].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arrayList.size() >= 175) {
                    for (int i = 1; i <= 35; i++) {
                        buttons[i].setVisible(false);
                    }
                    for (int i = 25; i <= 35; i++) {
                        buttons[i].setVisible(true);
                        buttons[i].setBackground(Color.black);
                        buttons[i].setForeground(Color.cyan);
                    }
                    buttons[35].setForeground(Color.white);
                    label.setVisible(false);
                    buttonNext.setVisible(false);
                    buttonPrevious.setVisible(true);

                    for (int i = 0; i < model.getRowCount(); ) {
                        model.removeRow(0);
                    }
                    buttonAdd.setEnabled(false);
                    for (int i = 170; i <= 174; i++) {
                        convert1 = array2d[i][0] = arrayList.get(i).getName();
                        convert2 = array2d[i][1] = arrayList.get(i).getPoint();
                        convert3 = array2d[i][2] = arrayList.get(i).getButtonEdit();
                        convert4 = array2d[i][3] = arrayList.get(i).getButtonDelete();
                        model.addRow(row = new Object[]{convert1, convert2, convert3, convert4});
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Dữ liệu chưa đủ để hiển thị ra bảng", "Title", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttons[25].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 1; i <= 35; i++) {
                    buttons[i].setVisible(false);
                }
                for (int i = 24; i <= 34; i++) {
                    buttons[i].setVisible(true);
                    buttons[i].setBackground(Color.black);
                    buttons[i].setForeground(Color.cyan);
                }
                buttons[25].setForeground(Color.white);
                buttons[35].setVisible(true);
                label.setVisible(true);
                buttonNext.setVisible(true);
                buttonPrevious.setVisible(true);
            }
        });
    }
}


class ButtonCell3 extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {

    private JButton btn;

    ButtonCell3() {
        btn = new JButton();
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("clicked");
            }
        });
    }

    @Override
    public Object getCellEditorValue() {
        return getCellEditorValue();
    }


    @Override
    public Component getTableCellRendererComponent(JTable table,
                                                   Object value, boolean isSelected, boolean hasFocus, int row,
                                                   int column) {
        if (value instanceof Icon) {
            btn.setIcon((Icon) value);
            btn.setBackground(Color.black);
        } else {
            btn.setIcon(null);
        }
        return btn;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table,
                                                 Object value, boolean isSelected, int row, int column) {
        if (value instanceof Icon) {
            btn.setIcon((Icon) value);
            btn.setBackground(Color.black);

        } else {
            btn.setIcon(null);
        }
        return btn;
    }
}

class ButtonCell4 extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {

    private JButton btn;

    ButtonCell4() {
        btn = new JButton();
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("clicked");
            }
        });
    }

    @Override
    public Object getCellEditorValue() {
        return getCellEditorValue();
    }


    @Override
    public Component getTableCellRendererComponent(JTable table,
                                                   Object value, boolean isSelected, boolean hasFocus, int row,
                                                   int column) {
        if (value instanceof Icon) {
            btn.setIcon((Icon) value);
            btn.setBackground(Color.black);

        } else {
            btn.setIcon(null);
        }
        return btn;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table,
                                                 Object value, boolean isSelected, int row, int column) {
        if (value instanceof Icon) {
            btn.setIcon((Icon) value);
            btn.setBackground(Color.black);

        } else {
            btn.setIcon(null);
        }
        return btn;
    }
}

