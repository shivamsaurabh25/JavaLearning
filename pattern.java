/*1) Solid Rectangle
*****
*****
*****
*****
public class pattern {
    public static void main(String[] args) {
        int n = 4;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
} */

/*2) Hollow rectangle
*****
*   *
*   *
*****
public class pattern {
    public static void main(String[] args) {
        int n = 4;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 5; j++) {
                if (i == 1 || j == 1 || i == 4 || j == 5) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
} */

/*3) Half Pyramid
*
**
***
****
public class pattern {
    public static void main(String[] args) {
        int n = 4;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}*/

/*4) Inverted Half Pyramid
****
***
**
*
public class pattern {
    public static void main(String[] args) {
        int n = 4;
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}*/

/*5) Inverted Half Pyramid(Rotated by 180-deg)
   *
  **
 ***
****
public class pattern {
    public static void main(String[] args) {
        int n = 4;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}*/

/*6) Half Pyramid with number
1 
1 2 
1 2 3 
1 2 3 4 
1 2 3 4 5
public class pattern {
    public static void main(String[] args) {
        int n = 5;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}*/

/*7) Inverted Half Pyramid with number
1 2 3 4 5 
1 2 3 4
1 2 3
1 2
1
public class pattern {
    public static void main(String[] args) {
        int n = 5;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print(j + " ");   
            }
            System.out.println();
        }
    }
} */

/*8) Floyd's Triangle
1 
2 3
4 5 6
7 8 9 10
11 12 13 14 15
public class pattern {
    public static void main(String[] args) {
        int n = 5;
        int a = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(a + " ");
                a++;
            }
            System.out.println();
        }
    }
}*/

/*9) 0-1 Triangle
1 
0 1
1 0 1
0 1 0 1
1 0 1 0 1
public class pattern {
    public static void main(String[] args) {
        int n = 5;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                int sum = i + j;
                if (sum % 2 == 0) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
}*/

/*10) Butterfly Pattern
*      *
**    **
***  ***
********
********
***  ***
**    **
*      *
public class Pattern{
    public static void main(String[] args) {
        int n = 4;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }
            for (int k = 2*(n - i); k >= 1; k--) {
                System.out.print(" ");
            }
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i = n; i >= 1; i--){
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }
            for (int k = 2*(n - i); k >= 1; k--) {
                System.out.print(" ");
            }
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
*/

/*11) a) Solid Rhombus
     *****
   *****
  *****
 *****
*****
public class Pattern{
    public static void main(String[] args){
        int n = 5;
        for(int i = 1; i <= n; i++){
            for(int j = n - i; j >= 1; j--){
                System.out.print(" ");
            }
            for(int j = 1; j <= n; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
 */
/*11) b) Hollow Rhombus 
    *****
   *   *
  *   *
 *   *
*****
public class Pattern{
    public static void main(String[] args){
    int n = 5;
        for(int i = 1; i <= n; i++){
            for(int j = n - i; j >= 1; j--){
                System.out.print(" ");
            }
            for(int j = 1; j <= n; j++){
                if(i == 1 || j == 1 || i == n || j == n){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
} */

/*12) Number Pyramid
    1 
   2 2
  3 3 3
 4 4 4 4
5 5 5 5 5
public class pattern {
    public static void main(String[] args) {
        int n = 5;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");                
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}*/

/*13) Palindromic Pyramid Pattern
    1
   212
  32123
 4321234
543212345
public class pattern {
    public static void main(String[] args) {
        int n = 5;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }
            for (int j = 2; j <= i; j++) {
                System.out.print(j);    
            }
            System.out.println();
        }
    }
}*/

/*14) Diamond Pattern
   *
  ***
 *****
*******
*******
 *****
  ***
   *
public class pattern {
    public static void main(String[] args) {
        int n = 4;
        //Upper Half
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            for (int j = 2; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        //Lower Half
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            for (int j = 2; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}*/

/*15) 
1234
234
34
4
public class pattern {
    public static void main(String[] args) {
        int i, j;
        for (i = 1; i <= 4; i++) {
            for(j = i; j <= 4 ; j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
} */

/*16)
4321
432
43
4
 public class pattern {
    public static void main(String[] args) {
        int i, j;
        for(i = 1; i <= 4; i++){
            for(j = 4; j >= i; j--){
                System.out.print(j);
            }
            System.out.println();
        }
    }
} */

/*17)
4321
321
21
1
public class pattern {
    public static void main(String[] args) {
        int i, j;
        for(i = 4; i >= 1; i--){
            for(j = i; j >= 1; j--){
                System.out.print(j);
            }
            System.out.println();
        }
    }
} */

/*18)
1 
2 3
4 5 6
7 8 9 10
 public class pattern {
    public static void main(String[] args) {
        int i, j, k = 1;
        for(i = 1; i <= 4; i++){
            for(j = 1; j <= i; j++){
                System.out.print(k + " ");
                k++;
            }
            System.out.println();
        }
    }
} */

/*19)
A
AB
ABC
ABCD
public class pattern {
    public static void main(String[] args) {
        int i;
        char ch;
        for(i = 1; i <= 4; i++){
            for(ch = 'A'; ch < 'A' + i; ch++){
                System.out.print(ch);
            }
            System.out.println();
        }
    }
} */

/*20)
1234
 123
  12
   1
 public class pattern {
    public static void main(String[] args) {
        int i, j;
        for(i = 4; i >= 1; i--){
            for(j = 1; j <= (4 - i); j++){
                System.out.print(" ");
            }
            for(j = 1; j <= i; j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
} */

/*21)
4444
 333
  22
   1
public class pattern {
    public static void main(String[] args) {
        int i, j;
        for(i = 4; i >= 1; i--){
            for(j = 1; j <= (4 - i); j++){
                System.out.print(" ");
            }
            for(j = 1; j <= i; j++){
                System.out.print(i);
            }
            System.out.println();
        }
    }
} */

/*22)
1111
 111
  11
   1
public class pattern {
    public static void main(String[] args) {
        int i, j;
        for(i = 4; i >= 1; i--){
            for(j = 1; j <= (4 - i); j++){
                System.out.print(" ");
            }
            for(j = 1; j <= i; j++){
                System.out.print("1");
            }
            System.out.println();
        }
    }
} */

/*23)
4321
 432
  43
   4
 public class pattern {
    public static void main(String[] args) {
        int i, j;
        for(i = 1 ; i <= 4; i++){
            for(j = 1; j < i; j++){
                System.out.print(" ");
            }
            for(j = 4; j >= i; j--){
                System.out.print(j);
            }
            System.out.println();
        }
    }
} */

 /*24)
 ABCD
  BCD
   CD
    D
  public class pattern {
    public static void main(String[] args) {
        int i, j;
        for(i = 0 ; i < 4; i++){
            for(j = 0; j < i; j++){
                System.out.print(" ");
            }
            for(j = i; j < 4; j++){
                System.out.print((char)('A' + j));
            }
            System.out.println();
        }
    }
} */

/*25)
   1
  121
 12321
1234321
public class pattern {
    public static void main(String[] args) {
        int i, j;
        for(i = 1; i <= 4; i++){
            for(j = 1; j <= 4 - i; j++){
                System.out.print(" ");
            }
            for(j = 1; j <= i; j++){
                System.out.print(j);
            }
            for(j = i - 1; j >= 1; j--){
                System.out.print(j);
            }
            System.out.println();
        }
    }
} */

/*26)
   0
  101
 21012
3210123 
public class pattern {
    public static void main(String[] args) {
        int i, j;
        for(i = 0; i < 4; i++){
            for(j = 0; j < 3 - i; j++){
                System.out.print(" ");
            }
            for(j = i; j >= 0; j--){
                System.out.print(j);
            }
            for(j = 1; j <= i; j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
} */

/*27)
   *
  ***
 *****
*******
 *****
  ***
   * 
public class pattern {
    public static void main(String[] args) {
        int i,j;
        //Upper Half
        for (i = 1; i <= 4; i++) {
            for (j = 1; j <= 4 - i; j++) {
                System.out.print(" ");
            }
            for (j = 1; j <= i; j++) {
                System.out.print("*");
            }
            for (j = 2; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        //Lower Half
        for (i = 4 - 1; i >= 1; i--) {
            for (j = 1; j <= 4 - i; j++) {
                System.out.print(" ");
            }
            for (j = 1; j <= i; j++) {
                System.out.print("*");
            }
            for (j = 2; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
} */

/*26) Hollow Pyramid
    *
   * *
  *   *
 *     *
********* 
public class pattern {
    public static void main(String[] args) {
        int i, j;
        for (i = 1; i <= 5; i++) {
            for (j = 1; j <= 5 - i; j++) {
                System.out.print(" ");
            }
            for (j = 1; j <= (2 * i - 1); j++) {
                if(j == 1 || j == 2*i-1 || i == 5){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
} */

/*27)
ABCDEFEDCBA
ABCDE EDCBA
ABCD   DCBA
ABC     CBA
AB       BA
A         A4 
public class pattern {
    public static void main(String[] args) {
        int i, j; char ch;
        for(i = 0; i < 6; i++){
            for(ch = 'A'; ch < 'A' + 6 - i; ch++){
                System.out.print(ch);
            }
            for(j = 0; j < i * 2 -1; j++){
                System.out.print(" ");
            }
            if(i == 0){
                for(ch = (char)('A' + 6 - i - 2); ch >= 'A'; ch--){
                    System.out.print(ch);
                }
            } else {
                for(ch = (char)('A' + 6 - i - 1); ch >= 'A'; ch--){
                    System.out.print(ch);
                }
            }
            System.out.println();
        }
    }
} */