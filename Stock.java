package project;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Search
// Add
// Update Cost
// Update Quantity
// Delete
//Display

public class Stock {
    static ArrayList<Medicines> stock = new ArrayList<>();
    int len = stock.size();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    ArrayList<Medicines> get_stock(){
        return stock;
    }

    int get_quantity(String name){
        int i, quantity = 0;
        boolean exist = false;
        int len = stock.size();
        for(i=0; i<len; i++){
            if(stock.get(i).name.equalsIgnoreCase(name)){
                quantity = stock.get(i).quantity;
                exist = true;
            }
        }
        if(exist == false){
            System.out.println("Not in Stock");
            return -1;
        }
        else
        {
            return quantity;
        }
    }


    int get_cost(String name){
        int i, cost = 0;
        boolean exist = false;
        int len = stock.size();
        for(i=0; i<len; i++){
            if(stock.get(i).name.equalsIgnoreCase(name)){
                cost = stock.get(i).cost;
                exist = true;
            }
        }
        if(exist == false){
            System.out.println("Not in Stock");
            return -1;
        }
        else
        {
            return cost;
        }
    }


    Medicines search_medicine(String name) {
        Medicines m = null;
            for (Medicines medicine : stock) {
                if (medicine.name.equalsIgnoreCase(name)) {
                    m =  medicine;
                }
            }
            if(m == null)
                System.out.println("Medicine not found");
            else
                return m;
            return null;
        }

    void up_quantity(Medicines up)throws IOException{
        System.out.println("Enter new quantity");
        up.quantity = up.quantity + Integer.parseInt(br.readLine());
        System.out.println("New Quantity = " + up.quantity);
    }

    void up_cost(Medicines up)throws IOException{
        System.out.println("Enter new cost");
        up.cost = Integer.parseInt(br.readLine());
        System.out.println("New Cost = " + up.cost);
    }



    void update(String name)throws IOException{
        try {
            Medicines up = search_medicine(name);
            up.display();
            System.out.println("What do you want to update:");
            System.out.println("1. Quantity");
            System.out.println("2. Cost");
            System.out.println("3. Both");
            switch (Integer.parseInt(br.readLine())) {
                case 1:
                    up_quantity(up);
                    break;
                case 2:
                    up_cost(up);
                    break;
                case 3:
                    up_quantity(up);
                    up_cost(up);
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        }
        catch (NullPointerException e){
            System.out.println("Medicine not in stock.");
        }
    }

    void new_medicine(String name, int cost, int quantity){
        stock.add(new Medicines(name, cost, quantity));
    }

    void del_medicine(String name){
        Medicines m = search_medicine(name);
        stock.remove(m);
    }

    void display()throws IOException{
        try {
            System.out.println("Select Option: ");
            System.out.println("1. Entire Stock");
            System.out.println("2. Specific Stock Item");
            switch (Integer.parseInt(br.readLine())) {
                case 1:
                    stock.forEach(Medicines::display);
                    break;
                case 2:
                    System.out.println("Enter name:");
                    search_medicine(br.readLine()).display();
                    break;
                default:
                    System.out.println("Invalid Command");
            }
        }
        catch(NullPointerException e){
            System.out.println("Invalid Medicine");
        }
    }

}
