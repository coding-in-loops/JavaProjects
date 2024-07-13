//Time Complexity: O(n)
//Space Complexity: O(n)

public class DsaSumOfDigitRecursion {
    public static int sumOfDigits(int n)
    {
        //Base case condition
        if(n==0)
        {
            return 0;
        }
        //Recursive calls
        else
        {
            return n%10 +sumOfDigits(n/10);
        }
    }
    public static void main(String[] args) {
        int n=12345;
        int res=sumOfDigits(n);
        System.out.println("The sum of digits of given number is: "+res);

    }
}
