import java.util.Scanner;
class item {
    protected int item;
    protected String name;
    protected double price;
}
class customer extends item{
    int cust_id;
    String payment;
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter customer Id: ");
        cust_id = sc.nextInt();
        System.out.println("Enter item name: ");
        name = sc.next();
        System.out.println("Enter item price: ");
        price = sc.nextDouble();
        System.out.println("Enter payment: ");   
        payment = sc.next();
    }
    public void display(){
        System.out.println("Customer ID: " + cust_id);
        System.out.println("Item number:" + item);
        System.out.println("Item name: " + name);
        System.out.println("Item price: " + price);
        System.out.println("Payment: " + payment);
    }
    public static void main(String[] args){
        customer c = new customer();
        c.input();
        c.display();
    }
}
