package project;
// New Customer
// Remove Customer
// Check Password
// Change Password
// Edit Medicines of a Customer
// View Customer

import java.io.*;
import java.util.ArrayList;

public class Chandle extends Stock{
    static ArrayList<Customer> customer = new ArrayList<>();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    void new_customer(String name, String password){
        customer.add(new Customer(name, password));
    }

    Customer search_customer(String name){
        for(Customer customer: customer){
            if(customer.name.equalsIgnoreCase(name)){
                return customer;
            }
        }
        return null;
    }

    boolean val_pass(String name, String password){
        try {
            if (search_customer(name).password.equalsIgnoreCase(password)) {
                return true;
            }
        }
        catch(NullPointerException e){
            System.out.println("No user found");
        }
        return false;
    }

    void change_pass(String name)throws IOException{
        try{
        System.out.println("Enter Previous Password:");
        if(val_pass(name, br.readLine())) {
            System.out.println("Validated.");
            System.out.println("Enter New Password:");
            Customer m = search_customer(name);
            m.password = br.readLine();
            System.out.println("New Password: " + m.password);
        }
        else{
                System.out.println("Wrong Password");
            }
        }
        catch(NullPointerException e){
            System.out.println("User Absent");
        }
    }

    void edit_customer(String name, String password)throws IOException{
        try {
            if (val_pass(name, password)) {
                int n = 0;
                while (n < 3) {
                    Customer m = search_customer(name);
                    System.out.println("Enter Your Option:");
                    System.out.println("1. Add Medicine");
                    System.out.println("2. Remove Medicine");
                    System.out.println("3. Exit");
                    n = Integer.parseInt(br.readLine());
                    String i;
                    switch (n) {
                        case 1:
                            System.out.println("Enter name of the medicine: ");
                            i = br.readLine();
                            System.out.println("Enter Quantity");
                            int j = Integer.parseInt(br.readLine());
                            if (j > get_quantity(i)) {
                                System.out.println("Insufficient Quantity");
                            }
                            m.add_medicine(i, get_cost(i) * j, j);
                            break;
                        case 2:
                            System.out.println("Enter the name of the medicine:");
                            i = br.readLine();
                            m.rem_medicine(i);
                            break;
                        case 3:
                            System.out.println("Exiting.");
                            break;
                        default:
                            System.out.println("Invalid Choice");
                    }

                }
            } else {
                System.out.println("Invalid Username or Password.");
            }
        }
        catch(NullPointerException e){
            System.out.println("User Absent");
        }
    }

    void dis_customer(String name)throws IOException{
        Customer obj = search_customer(name);
        if(obj == null){
            System.out.println("User Not Present");
        }
        else{
            System.out.println("Enter Password: ");
            String pass =  br.readLine();
            if(obj.password.equalsIgnoreCase(pass)){
                obj.dis(obj);
            }
            else{
                System.out.println("Invalid Password.");
            }

        }
        }


}
