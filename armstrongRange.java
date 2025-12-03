class armstrongRange {
    public static void main(String[] args) {
        int num = 1, temp, sum = 0, digit;
        System.out.println("Armstrong numbers between 1 and 1000 are:");
        while (num <= 1000) {
            temp = num;
            sum = 0;
            while (temp > 0) {
                digit = temp % 10;
                sum += digit * digit * digit;
                temp /= 10;
            }
            if (sum == num) {
                System.out.println(num);
            }
            num++;
        }
    }    
}
