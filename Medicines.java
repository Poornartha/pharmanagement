package project;



public class Medicines {
    String name;
    int cost;
    int quantity;

    public Medicines(String name, int cost, int quantity) {
        this.name = name;
        this.cost = cost;
        this.quantity = quantity;
    }

    public int getCost() {
        return cost;
    }

    void display(){
        System.out.println("Name: " + this.name);
        System.out.println("Cost: " + this.cost);
        System.out.println("Quantity: " + this.quantity);
    }
}

