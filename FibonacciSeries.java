class FibonacciSeries {
    public static void main(String[] args) {
        int n1 = 0, n2 = 1, n3, count = 10, i = 1;
        System.out.println("Fibonacci series up to 10 terms:");
        while (i <= count) {
            System.out.print(n1 + " ");
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
            i++;
        }
    }
}