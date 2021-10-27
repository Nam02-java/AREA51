package DEMO;

import javax.swing.*;

public class BaseOfDemo {
    String name, point;
    JButton buttonEdit , buttonDelete;

    public BaseOfDemo(String name, String point, JButton buttonEdit, JButton buttonDelete) {
        this.name = name;
        this.point = point;
        this.buttonEdit = buttonEdit;
        this.buttonDelete = buttonDelete;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public JButton getButtonEdit() {
        return buttonEdit;
    }

    public void setButtonEdit(JButton buttonEdit) {
        this.buttonEdit = buttonEdit;
    }

    public JButton getButtonDelete() {
        return buttonDelete;
    }

    public void setButtonDelete(JButton buttonDelete) {
        this.buttonDelete = buttonDelete;
    }
}