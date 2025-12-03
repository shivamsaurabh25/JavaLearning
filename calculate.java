import java.util.Scanner;
class calculate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d, m, y, t = 0, i;
        System.out.println("Enter day month and year: ");
        d = sc.nextInt();
        m = sc.nextInt();
        y = sc.nextInt();
        if(d <= 31 && m <= 12){
            t += d;
            for (i = 1; i < m; i++) {
                switch (i) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        t += 31;
                        break;
                    case 2:
                        if(y % 4 == 0){
                            t += 29;
                        } else {
                            t += 28;
                        }
                        break;
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        t += 30;
                        break;
                }
            }
            System.out.println("Total days: " + t);
        } else {
            System.out.println("Invalid day or month");
        }
        sc.close();
    }
}
