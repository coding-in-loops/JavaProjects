/*
 * A fibonacci series is as follows:
 *  0 1 1 2 3 5 8 13 21 34...
 * 1.) starts from 0 then 1
 * 2.) next term is sum of previous two terms
 */
//Time Complexity: O(2^n)
//Space Complexity: O(n)

public class DsaFibonaaci {

    public static int findFibonacciSum(int n)
    {
        //Base case condition
        if(n<=1)
        {
            return n;
        }
        //Recursive calls
        else
        {
            return findFibonacciSum(n-1)+findFibonacciSum(n-2);
        }

    }
    public static void main(String[] args) {
        int n=10;
        int sum=findFibonacciSum(n);
        System.out.println("Fibonacci Sum is: "+sum);
    }
}
