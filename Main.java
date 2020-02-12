package javaproject;

import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stock s = new Stock();
        Chandle c = new Chandle();

        int choice = 0;
        while(choice <= 8){
            System.out.println(">>>>>>> MENU <<<<<<<<");
            System.out.println("1. Add new medicine to the stock.");
            System.out.println("2. Delete medicine from stock.");
            System.out.println("3. Update Cost/Quantity of medicine in stock.");
            System.out.println("4. Display Stock");
            System.out.println("5. New Customer");
            System.out.println("6. Change Password");
            System.out.println("7. Edit Medicines (Customer)");
            System.out.println("8. Display Medicines (Customer)");
            System.out.println("9. Exit");
            choice = Integer.parseInt(br.readLine());
            String n;
            String p;
            int co;
            int q;
            switch(choice){
                case 1:
                    System.out.println("Enter Name of Medicine: ");
                    n = br.readLine();
                    System.out.println("Enter Cost of the Medicine:");
                    co = Integer.parseInt(br.readLine());
                    System.out.println("Enter Quantity");
                    q = Integer.parseInt(br.readLine());
                    s.new_medicine(n, co, q);
                    break;
                case 2:
                    System.out.println("Enter the name of the medicine:");
                    n = br.readLine();
                    s.del_medicine(n);
                    break;
                case 3:
                    System.out.println("Enter the name of the medicine:");
                    n = br.readLine();
                    s.update(n);
                    break;
                case 4:
                    s.display();
                    break;
                case 5:
                    System.out.println("Enter your name:");
                    n = br.readLine();
                    System.out.println("Enter Password: ");
                    p = br.readLine();
                    c.new_customer(n, p);
                    break;
                case 6:
                    System.out.println("Enter your name:");
                    n = br.readLine();
                    c.change_pass(n);
                    break;
                case 7:
                    System.out.println("Enter your name:");
                    n = br.readLine();
                    System.out.println("Enter Password: ");
                    p = br.readLine();
                    c.edit_customer(n, p);
                    break;
                case 8:
                    System.out.println("Enter Your Name:");
                    n = br.readLine();
                    c.dis_customer(n);
                    break;
                default:
                    System.out.println("Invalid");
            }
        }


    }
}
