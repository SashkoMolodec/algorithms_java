package sort;

public class Recursion {
    public static void main(String[] args) {
        System.out.println(recursiveFactorial(5));
    }

    // 1! = 0! * 1
    // 2! = 2 * 1 = 2 * 1!
    // 3! = 3 * 2 * 1 = 3 * 2!

    // n! = n * (n-1)!

    // callstack

    // breaking condition - something that stops recursion

    private static int recursiveFactorial(int num) {
        if (num == 0) return 1;
        return recursiveFactorial(num - 1) * num;
    }
}
