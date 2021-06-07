package project;

import java.io.*;
import java.util.ArrayList;

// Add Medicine
// Remove Medicine
// Display Medicines

public class Customer extends Stock {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public Customer(String name, String password) {
        this.name = name;
        this.password = password;
    }

    String name;
    String password;
    ArrayList<Medicines> cmed = new ArrayList<Medicines>();

    void add_medicine(String name, int cost, int quantity){
        cmed.add(new Medicines(name, cost , quantity));
    }

    Medicines search_medicine(String name){
        for(Medicines medicines: cmed){
            if(medicines.name.equalsIgnoreCase(name)){
                return medicines;
            }
        }
        return null;
    }

    void rem_medicine(String name){
        cmed.remove(search_medicine(name));
    }

    void check_out(int total, Customer customer){
        for(int i=0; i<customer.cmed.size(); i++){
            for(int j=0; j<stock.size(); j++){
                if(customer.cmed.get(i).name.equalsIgnoreCase(stock.get(j).name)){
                    stock.get(j).quantity = stock.get(j).quantity - cmed.get(i).quantity;
                }
            }
        }
        System.out.println("Stock Updated.");
    }


    void dis(Customer customer)throws IOException{
        System.out.println("Medicines: ");
        cmed.forEach(Medicines::display);
        int total = 0;
        for(int i =0; i<cmed.size(); i++){
            total = total + cmed.get(i).cost;
        }
        System.out.println("Total Cost Of Medicines: " + total);
        System.out.println("Do you want to check out?\n1.Yes\n2.No");
        int c = Integer.parseInt(br.readLine());
        if(c == 1){
            check_out(total, customer);
        }
        else{
            return;
        }

    }

}
