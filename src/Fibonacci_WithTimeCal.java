public class Fibonacci_WithTimeCal {

    /**
     * Algorithm 1.6 Recursive method for Fibonacci
     *
     * @param n
     * @return fib(n)
     */
    private static String fib_recursive(int n) {
        if (n <= 1) return n + "";
        else return SUM(fib_recursive(n - 1), fib_recursive(n - 2));
    }

    /**
     * Algorithm 1.7 Iterative method for Fibonacci
     *
     * @param n
     * @return fib(n)
     */
    private static String fib_iterative(int n) {
        if (n <= 1) return n + "";
        String[] f = new String[n + 1];
        f[0] = "0";
        if (n > 0) {
            f[1] = "1";
            for (int i = 2; i <= n; i++) {
                f[i] = SUM(f[i - 1], f[i - 2]);
            }
        }
        return f[n];
    }

    /**
     * return a+b
     *
     * @param a
     * @param b
     * @return
     */
    private static String SUM(String a, String b) {
        // a is always >= b in the Fibonacci case.
        int len = a.length(); // maximum length between a and b
        StringBuilder builderA = new StringBuilder(a).reverse();
        StringBuilder builderB = new StringBuilder(b).reverse();
        StringBuilder result = new StringBuilder();
        int carry = 0; // if need carry-over, carry=1,else =0;
        int temp = 0; // use for temporary storage
        // make b the same size as a, fill with "0"
        while (builderB.length() < len) {
            builderB.append("0");
        }
        for (int i = 0; i < len; i++) {
            temp = builderA.charAt(i) - '0' + builderB.charAt(i) - '0' + carry;
            if (temp >= 10) {
                result.append(new StringBuilder(temp - 10 + ""));
                carry = 1;
            } else {
                result.append(new StringBuilder(temp + ""));
                carry = 0;
            }
        }
        if (carry == 1) {
            result.append(1);
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        int n = 0;
        long time_start = 0;
        // recursive
        for (; ; n++) {
            time_start = System.currentTimeMillis(); // record start time
            System.out.println("Recursive(" + n + "): " + fib_recursive(n) + "  " + (System.currentTimeMillis() - time_start) / 1000 + "s");
            if (System.currentTimeMillis() - time_start > 60000) { // output result when runtime > 60s
                System.out.println("The largest number that the recursive algorithm can accept as its argument and compute the answer within 60 seconds is: " + (n - 1));
                break;
            }
        }

        // iterative
        time_start = System.currentTimeMillis();
        System.out.println("fib_iterative(" + (n - 1) + "): " + fib_iterative(n - 1));
        System.out.println("The time the iterative algorithm takes to compute fib(" + (n - 1) + ") is: " + (System.currentTimeMillis() - time_start) / 1000 + "s");
    }

}
