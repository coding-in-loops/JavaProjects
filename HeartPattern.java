public class HeartPattern {
    public static void main(String[] args) {
        int n=11;
        System.out.println();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i-j==(n-1)/2 || i+j==(n-1)/2 +n-1 || j==0 && i>0 && i<(n-1)/2 || j==n-1 && i>0 && i<(n-1)/2 || i==0 && j>0 && j<(n-1)/2 || i==0 && j>(n-1)/2 && j<n-1 || i==(n-1)/4  && j==(n-1)/2)
                {
                    System.out.print(" *+* ");
                }
                else
                {
                    System.out.print("     ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
