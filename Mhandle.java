package project;

import java.util.ArrayList;

public class Mhandle {
    static ArrayList<Manager> managerss = new ArrayList<>();

    void new_manager(String name, String password) {
        managerss.add(new Manager(name, password));
    }

    Manager search_manager(String name) {
        for (Manager man : managerss) {
            if (man.name.equalsIgnoreCase(name)) {
                return man;
            }
        }
        return null;
    }

    boolean val_pass(String name, String password) {
        try {
            if (search_manager(name).password.equalsIgnoreCase(password)) {
                return true;
            }
        }
        catch (NullPointerException e) {
            System.out.println("Manager Absent");
        }
        return false;
    }
}