import java.util.Scanner;
class max {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num[] = new int[10];
        int a, b, i, p = 0, x;
        System.out.println("Enter 10 numbers: ");
        for(i = 0; i < 10; i++){
            num[i] = sc.nextInt();
        }
        a = num[0];
        for(i = 0; i < 10; i++){
            if(num[i] > a){
                a = num[i];
                p = i;
            }
        }
        x = num[p];
        num[p] = 0;
        b = num[0];
        for(i = 0; i < 10; i++){
            if(num[i] > b){
                b = num[i];
            }
        }
        num[p] = x;
        for(i = 0; i < 10; i++){
            System.out.println(num[i]);
        }
        System.out.println(a + "\t" + b);
    }
}