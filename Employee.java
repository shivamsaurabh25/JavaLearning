import java.util.Scanner;
class salary{
    protected double basic, net;
    protected String desig;
}
class Employee extends salary{
    int empno;
    String name;
    public void getdata(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter empno & name: ");
        empno = sc.nextInt();
        name = sc.next();
        System.out.println("Enter desig, basic and net: ");
        desig = sc.next();
        basic = sc.nextDouble();
        net = sc.nextDouble();
    }
    public void showdata(){
        System.out.println(empno + "\t" + name);
        System.out.println(basic + "\t" + desig + "\t" + net);
    }
    public static void main(String args[]){
        Employee emp = new Employee();
        emp.getdata();
        emp.showdata();
    }
}