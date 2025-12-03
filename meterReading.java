import java.util.Scanner;
class meterReading {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mr;
        float total = 0;
        System.out.println("Enter your meter reading: ");
        mr = sc.nextInt();
        if(mr >= 1 && mr <= 50){
            total += mr;
        } else if(mr >= 51 && mr <= 100){
            total += 50 + (mr - 50)* 1.5;
        } else if(mr >= 101 && mr <= 200){
            total += 50 + 50 * 1.5 + (mr - 100)*2;
        } else if(mr > 200) {
            total += 50 + 50 * 1.5 + 100 * 2 + (mr - 200)*5;
        } else {
            System.out.println("Enter correct meter reading");
            sc.close();
            return;
        }
        System.out.println("Your total eletricity bill: " + total);
        sc.close();
    }
}
