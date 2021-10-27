package DEMO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class BaseOfDataUser {
    String userName, passWord;

    public BaseOfDataUser(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}

public class SignInSystem extends JFrame {
    static JTextField textFieldName;
    static JPasswordField textFieldPassWord;
    static JLabel labelUserName, labelPassWord, labelAvatar;
    static ImageIcon imageIcon;
    static JButton buttonSignIn, buttonSignUp;
    static JCheckBox checkBox;
    static ArrayList<BaseOfDataUser> arrayList = new ArrayList<>();
    static ArrayList<Boolean> arrayListCheckBox = new ArrayList<>();
    static ArrayList<BaseOfDataUser> arrayListDataOnlyPerson = new ArrayList<>();
    static File file = new File("DataUser.txt");
    static File fileCheckBox = new File("rememberMe.text");
    static File fileDataOnlyPerson = new File("DataOnlyPerson.txt");

    public void showThemeSignIn() {
        labelAvatar = new JLabel();
        labelAvatar.setIcon(imageIcon = new ImageIcon("C:\\Users\\User\\Downloads\\icons8-user-64.png"));
        labelAvatar.setBounds(115, 20, 65, 65);

        labelUserName = new JLabel();
        labelUserName.setIcon(imageIcon = new ImageIcon("C:\\Users\\User\\Downloads\\icons8-user-24.png"));
        labelUserName.setBounds(20, 105, 24, 24);

        textFieldName = new JTextField();
        textFieldName.setBounds(60, 100, 170, 30);
        textFieldName.setBackground(Color.BLACK);
        textFieldName.setForeground(Color.WHITE);
        textFieldName.setCaretColor(Color.WHITE);

        labelPassWord = new JLabel();
        labelPassWord.setIcon(imageIcon = new ImageIcon("C:\\Users\\User\\Downloads\\icons8-password-24.png"));
        labelPassWord.setBounds(20, 150, 24, 24);

        textFieldPassWord = new JPasswordField();
        textFieldPassWord.setBounds(60, 145, 170, 30);
        textFieldPassWord.setBackground(Color.BLACK);
        textFieldPassWord.setForeground(Color.WHITE);
        textFieldPassWord.setCaretColor(Color.WHITE);

        buttonSignIn = new JButton("Sign In");
        buttonSignIn.setBounds(60, 200, 170, 30);
        buttonSignIn.setForeground(Color.WHITE);
        buttonSignIn.setBackground(Color.black);

        checkBox = new JCheckBox("remember me");
        checkBox.setBounds(60, 250, 115, 25);
        checkBox.setBackground(Color.BLACK);
        checkBox.setForeground(Color.WHITE);

        buttonSignUp = new JButton("Sign Up");
        buttonSignUp.setBounds(60, 300, 170, 30);
        buttonSignUp.setForeground(Color.WHITE);
        buttonSignUp.setBackground(Color.black);

        add(labelAvatar);
        add(labelUserName);
        add(textFieldName);
        add(labelPassWord);
        add(textFieldPassWord);
        add(buttonSignIn);
        add(checkBox);
        add(buttonSignUp);
        setButtonSignIn();
        setButtonSignUp();
        setCheckBox();
        setTitle("Login");
        getContentPane().setBackground(Color.darkGray);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 350, 300, 400);
        setLayout(null);
        setVisible(true);
        work();
    }

    public void fileToArrayList() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            arrayList.add(new BaseOfDataUser(scanner.next(), scanner.next()));
        }
        scanner.close();
    }

    public void arrayListToFile() throws IOException {
        String space = ("\n");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        for (int i = 0; i < arrayList.size(); i++) {
            bufferedWriter.write(arrayList.get(i).getUserName() + " " + arrayList.get(i).getPassWord() + space);
        }
        bufferedWriter.close();
    }

    public void setButtonSignIn() {
        buttonSignIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textFieldName.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Không được để ô trống", "Title", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                if (textFieldPassWord.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Không được để ô trống", "Title", JOptionPane.INFORMATION_MESSAGE);
                    return;
                } else {
                    try {
                        arrayList.clear();
                        fileToArrayList();
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }

                    boolean a = false;
                    for (int i = 0; i < arrayList.size(); i++) {
                        if (arrayList.get(i).getUserName().equals(textFieldName.getText())) {
                            a = true;
                        }
                        if (a == true) {
                            if (arrayList.get(i).getPassWord().equals(textFieldPassWord.getText())) {
                                try {
                                    Thread.sleep(500);
                                    JOptionPane.showMessageDialog(null, "Đăng nhập thành công", "Title", JOptionPane.INFORMATION_MESSAGE);
                                    arrayList.clear();
                                    setVisible(false);
                                    MyFrameDemo myFrameDemo = new MyFrameDemo();
                                    myFrameDemo.showWindowDemo();
                                    return;
                                } catch (InterruptedException interruptedException) {
                                    interruptedException.printStackTrace();
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Tên đăng nhập hoặc mật khẩu không đúng !", "Title", JOptionPane.INFORMATION_MESSAGE);
                                return;
                            }
                        }
                    }
                    if (a == false) {
                        JOptionPane.showMessageDialog(null, "Tên đăng nhập hoặc mật khẩu không đúng !", "Title", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                }
            }
        });
    }

    public void setButtonSignUp() {
        buttonSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                SignUpSystem signUpSystem = new SignUpSystem();
                signUpSystem.showThemeSignUp();
            }
        });
    }

    //bien gioi demo

    public void work(){
        try {
            fileToArrayListCheckBox();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < arrayListCheckBox.size(); i++) {
            if (arrayListCheckBox.get(i) == true) {
                arrayListCheckBox.clear();
                try {
                    fileToArrayListDataOnlyPerson();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                for (int z = 0; z < arrayListDataOnlyPerson.size(); z++) {
                    textFieldName.setText(arrayListDataOnlyPerson.get(z).getUserName());
                    textFieldPassWord.setText(arrayListDataOnlyPerson.get(z).getPassWord());
                    arrayListDataOnlyPerson.clear();
                }
            }else if(arrayListCheckBox.get(i)==false){
            }
        }
    }

    public void fileToArrayListCheckBox() throws FileNotFoundException {
        Scanner scanner = new Scanner(fileCheckBox);
        while (scanner.hasNext()) {
            arrayListCheckBox.add(scanner.hasNext());
            break;
        }
        scanner.close();
    }

    public void arrayListCheckBoxToFile() throws IOException {
        String space = ("\n");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileCheckBox));
        bufferedWriter.write(String.valueOf(arrayListCheckBox));
        bufferedWriter.close();
    }

    public void fileToArrayListDataOnlyPerson() throws FileNotFoundException {
        Scanner scanner = new Scanner(fileDataOnlyPerson);
        while (scanner.hasNext()) {
            arrayListDataOnlyPerson.add(new BaseOfDataUser(scanner.next(), scanner.next()));
        }
        scanner.close();
    }

    public void arrayListDataOnlyPersonToFile() throws IOException {
        String space = ("\n");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileDataOnlyPerson));
        for (int i = 0; i < arrayListDataOnlyPerson.size(); i++) {
            bufferedWriter.write(arrayListDataOnlyPerson.get(i).getUserName() + " " + arrayListDataOnlyPerson.get(i).getPassWord() + space);
        }
        bufferedWriter.close();
    }

    public void setCheckBox() {
        checkBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == checkBox) {
                    arrayListCheckBox.clear();
                    arrayListCheckBox.add(checkBox.isSelected());
                    try {
                        arrayListCheckBoxToFile();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
                if (checkBox.isSelected() == true) {
                    try {
                        fileToArrayListDataOnlyPerson();
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                    arrayListDataOnlyPerson.clear();
                    arrayListDataOnlyPerson.add(new BaseOfDataUser(textFieldName.getText(), textFieldPassWord.getText()));
                    try {
                        arrayListDataOnlyPersonToFile();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                } else if (checkBox.isSelected() == false) {
                    try {
                        fileToArrayListDataOnlyPerson();
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                    arrayListDataOnlyPerson.clear();
                    try {
                        arrayListDataOnlyPersonToFile();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });
    }
}

class SignUpSystem extends JFrame {
    static JTextField textFieldUserName;
    static JPasswordField textFieldPassWord1, textFieldPassWord2;
    static JLabel labelAvatar, labelUserName, labelPassWord1, labelPassWord2;
    static JButton buttonSignUp, buttonPrevious;
    static ImageIcon imageIcon;
    static ArrayList<BaseOfDataUser> arrayList = new ArrayList<>();
    static File file = new File("DataUser.txt");

    public void showThemeSignUp() {
        labelAvatar = new JLabel();
        labelAvatar.setIcon(imageIcon = new ImageIcon("C:\\Users\\User\\Downloads\\icons8-sign-up-50.png"));
        labelAvatar.setBounds(115, 20, 50, 50);

        labelUserName = new JLabel();
        labelUserName.setIcon(imageIcon = new ImageIcon("C:\\Users\\User\\Downloads\\icons8-user-24.png"));
        labelUserName.setBounds(20, 105, 24, 24);

        textFieldUserName = new JTextField();
        textFieldUserName.setBounds(60, 100, 170, 30);
        textFieldUserName.setBackground(Color.BLACK);
        textFieldUserName.setForeground(Color.WHITE);
        textFieldUserName.setCaretColor(Color.WHITE);

        labelPassWord1 = new JLabel();
        labelPassWord1.setIcon(imageIcon = new ImageIcon("C:\\Users\\User\\Downloads\\icons8-password-24.png"));
        labelPassWord1.setBounds(20, 150, 24, 24);

        textFieldPassWord1 = new JPasswordField();
        textFieldPassWord1.setBounds(60, 145, 170, 30);
        textFieldPassWord1.setBackground(Color.BLACK);
        textFieldPassWord1.setForeground(Color.WHITE);
        textFieldPassWord1.setCaretColor(Color.WHITE);

        labelPassWord2 = new JLabel();
        labelPassWord2.setIcon(imageIcon = new ImageIcon("C:\\Users\\User\\Downloads\\icons8-password-24.png"));
        labelPassWord2.setBounds(20, 195, 24, 24);

        textFieldPassWord2 = new JPasswordField();
        textFieldPassWord2.setBounds(60, 190, 170, 30);
        textFieldPassWord2.setBackground(Color.BLACK);
        textFieldPassWord2.setForeground(Color.WHITE);
        textFieldPassWord2.setCaretColor(Color.WHITE);

        buttonSignUp = new JButton("Sign Up");
        buttonSignUp.setBounds(60, 250, 170, 30);
        buttonSignUp.setForeground(Color.WHITE);
        buttonSignUp.setBackground(Color.black);

        buttonPrevious = new JButton("Previous");
        buttonPrevious.setBounds(5, 330, 85, 25);
        buttonPrevious.setForeground(Color.WHITE);
        buttonPrevious.setBackground(Color.black);

        add(labelAvatar);
        add(labelUserName);
        add(textFieldUserName);
        add(labelPassWord1);
        add(textFieldPassWord1);
        add(labelPassWord2);
        add(textFieldPassWord2);
        add(buttonSignUp);
        add(buttonPrevious);
        setButtonPrevious();
        setButtonSignUpOfSignUpSystem();
        setTitle("Sign Up");
        getContentPane().setBackground(Color.darkGray);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 350, 300, 400);
        setLayout(null);
        setVisible(true);
    }

    public void setButtonPrevious() {
        buttonPrevious.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                SignInSystem signInSystem = new SignInSystem();
                signInSystem.showThemeSignIn();
            }
        });
    }

    public void fileToArrayList() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            arrayList.add(new BaseOfDataUser(scanner.next(), scanner.next()));
        }
        scanner.close();
    }

    public void arrayListToFile() throws IOException {
        String space = ("\n");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        for (int i = 0; i < arrayList.size(); i++) {
            bufferedWriter.write(arrayList.get(i).getUserName() + " " + arrayList.get(i).getPassWord() + space);
        }
        bufferedWriter.close();
    }

    public void setButtonSignUpOfSignUpSystem() {
        buttonSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textFieldUserName.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Không được để ô trống", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (textFieldPassWord1.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Không được để ô trống", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (textFieldPassWord2.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Không được để ô trống", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                } else {
                    try {
                        arrayList.clear();
                        fileToArrayList();
                        if (file.length() == 0) {
                            arrayList.add(new BaseOfDataUser(textFieldUserName.getText(), textFieldPassWord1.getText()));
                            arrayListToFile();
                            arrayList.clear();
                            JOptionPane.showMessageDialog(null, "Tạo tài khoản thành công !", "Title", JOptionPane.INFORMATION_MESSAGE);
                            setVisible(false);
                            SignInSystem signInSystem = new SignInSystem();
                            signInSystem.showThemeSignIn();
                            return;
                        }
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    boolean a = true;
                    for (int i = 0; i < arrayList.size(); i++) {
                        if (arrayList.get(i).getUserName().equalsIgnoreCase(textFieldUserName.getText())) {
                            a = false;
                        }
                    }
                    if (a == false) {
                        JOptionPane.showMessageDialog(null, "Tên đã có người sử dụng", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                    if (a == true) {
                        if (textFieldPassWord1.getText().equals(textFieldPassWord2.getText())) {
                            arrayList.add(new BaseOfDataUser(textFieldUserName.getText(), textFieldPassWord1.getText()));
                            try {
                                arrayListToFile();
                            } catch (IOException ioException) {
                                ioException.printStackTrace();
                            }
                            arrayList.clear();
                            JOptionPane.showMessageDialog(null, "Tạo tài khoản thành công !", "Title", JOptionPane.INFORMATION_MESSAGE);
                            setVisible(false);
                            SignInSystem signInSystem = new SignInSystem();
                            signInSystem.showThemeSignIn();
                        } else {
                            JOptionPane.showMessageDialog(null, "Mật khẩu không khớp !", "Warning", JOptionPane.WARNING_MESSAGE);
                            textFieldPassWord1.setText("");
                            textFieldPassWord2.setText("");
                        }
                    }
                }
            }
        });
    }
}

class Main {
    public static void main(String[] args) {
        SignInSystem signInSystem = new SignInSystem();
        signInSystem.showThemeSignIn();

    }
}




