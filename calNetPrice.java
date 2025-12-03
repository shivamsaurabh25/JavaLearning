import java.util.Scanner;
class calNetPrice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noi;
        double ppu, grossPrice, netPrice;
        System.out.print("Enter number of items: ");
        noi = sc.nextInt();
        System.out.print("Enter price per unit: ");
        ppu = sc.nextDouble();
        grossPrice = noi * ppu;
        if(grossPrice >= 10000){
            netPrice = grossPrice - 0.05 * grossPrice;
        } else if(grossPrice >= 5000 && grossPrice <= 9999){
            netPrice = grossPrice - 0.02 * grossPrice;
        } else {
             netPrice = grossPrice;
        }
        System.out.println("Net price is: "+ netPrice);
        sc.close();
    }
}