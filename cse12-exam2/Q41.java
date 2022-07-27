import java.util.Arrays;

public class Q41 {
    int count;
    public Q41() {
        this.count = 0;
    }
    public static void runtime1(int n) {
        int count = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= i * i; j++) {
                if (j % i == 0) {
                    for (int k = 0; k < j; k++) {
                        System.out.println(count);
                        count++;
                    }
                }
            }
        }
    }
    public static void runtime2(int n) {
        int count = 1;
        while (n > 0) {
            if (n % 3 == 0) {
                for (int i = 0; i < n * n; i += n) {
                    for (int j = i; j > 0; j--) {
                        System.out.println(count);
                        count++;
                    }
                }
            }
            n--;
        }
    }
    public int runtime3(int n) {
        System.out.println(this.count);
        this.count++;
        if (n < 1) {
            return 0;
        }
        return this.runtime3(n-1) + this.runtime3(n / 2);
    }
    public int runtime4(int n) {
        if (n == 0) {
            return 0;
        }
        int fourths = n / 4;
        this.count += 1;
        System.out.println(this.count);

        // Split array into fourths. Assume this always works for all n
        this.count += n;
        System.out.println(this.count);

        for (int i = 0; i < fourths * fourths; i++) {
            this.count += 1;
            System.out.println(this.count);
        }
        return runtime4(fourths) + runtime4(fourths) + runtime4(fourths) + runtime4(fourths);
    }
    public static void dosth(int loc, int[] arr) {
        int j = loc;
        while (j > 0 && arr[j] < arr[j-1]){
          int temp = arr[j];
          arr[j] = arr[j-1];
          arr[j-1] = temp;
          j--;
        }
    }
    public static int[] method2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i % 3 == 0) {
                int amount = 1;

                for (int j = 0; j < arr.length / 2; j++) {
                    amount *= arr[i];
                }

                arr[i] = amount;
            }
        }

        return arr;
    }
}