import java.util.Scanner;

//Time COmplexity: O(2^n)  --> Using recursion
//Space complexity :O(n)

/* Problem statement:
 * A person a step one or two stairs at a time
 * find number of ways he can do
 * if n is the number of stairs
 */
public class CountWays {

    public static int countNum(int n) {
        if (n <= 1) {
            return n;
        } else {
            int count = countNum(n - 1) + countNum(n - 2);
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of stairs: ");
        int n = sc.nextInt();

        int result = countNum(n + 1);
        System.out.println("Number of ways is: " + result);
        sc.close();
    }
}
