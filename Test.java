package project;
import java.io.*;

public class Test {

    void customer()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Chandle c = new Chandle();
        int choice = 0;
        while(choice != 3){
            System.out.println("1. New Customer");
            System.out.println("2. Change Password");
            System.out.println("3. Edit Medicines");
            System.out.println("4. Display Medicines");
            System.out.println("5. Exit");
            choice = Integer.parseInt(br.readLine());
           switch(choice){

               case 1:
                   System.out.println("Enter your name:");
                   String n = br.readLine();
                   System.out.println("Enter Password: ");
                   String p = br.readLine();
                   c.new_customer(n, p);
                   break;
               case 2:
                   System.out.println("Enter your name:");
                   n = br.readLine();
                   c.change_pass(n);
                   break;
               case 3:
                   System.out.println("Enter your name:");
                   n = br.readLine();
                   System.out.println("Enter Password: ");
                   p = br.readLine();
                   c.edit_customer(n, p);
                   break;
               case 4:
                   System.out.println("Enter Your Name:");
                   n = br.readLine();
                   c.dis_customer(n);
                   break;
               case 5:
                   return;
               default:
                   System.out.println("Invalid Option");

           }
        }

    }


    void stock()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Mhandle m = new Mhandle();
        int choice = 0;
        Stock s = new Stock();
        String n;
        int co;
        int q;
        while(choice != 5){
            System.out.println(">>>>>>> MENU <<<<<<<<");
            System.out.println("1. Add new medicine to the stock.");
            System.out.println("2. Delete medicine from stock.");
            System.out.println("3. Update Cost/Quantity of medicine in stock.");
            System.out.println("4. Display Stock");
            System.out.println("5. Exit");
            choice = Integer.parseInt(br.readLine());
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
                    break;
                default:
                    System.out.println("Invalid");

            }
        }

    }


    void manager(Test t)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Mhandle m = new Mhandle();
        int choice = 0;
        String name;
        String password;
        String code;

        System.out.println("Enter the System Code:");
        code = br.readLine();

        if(code.equals("XYZ123")){
            while (choice != 3){
                System.out.println("1. New Manager");
                System.out.println("2. Login ");
                System.out.println("3. Exit");
                choice = Integer.parseInt(br.readLine());
                switch(choice){

                    case 1:
                        System.out.println("Enter name: ");
                        name = br.readLine();
                        System.out.println("Enter Password");
                        password = br.readLine();
                        m.new_manager(name, password);
                        break;
                    case 2:
                        System.out.println("Enter name");
                        name = br.readLine();
                        System.out.println("Enter Password");
                        password = br.readLine();
                        if(m.val_pass(name, password)){
                            t.stock();
                        }
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Invalid Option");
                }
            }
        }
        else
        {
            System.out.println("ENTERED CODE INVALID.");
            System.out.println("You don't have Administration rights.");
        }
    }


    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int choice = 0;
        while(choice != 3){
            System.out.println(">>>>MENU<<<<");
            System.out.println("Enter Choice:");
            System.out.println("1. Customer");
            System.out.println("2. Manager");
            System.out.println("3. Exit");
            Test t = new Test();
            choice = Integer.parseInt(br.readLine());
            switch (choice){

                case 1:
                    t.customer();
                    break;
                case 2:
                    t.manager(t);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid Option");
            }
        }


    }
}
