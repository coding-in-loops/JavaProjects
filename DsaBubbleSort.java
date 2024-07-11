//Time Complexity: O(n^2)
//Space Complexity: O(1)

import java.util.Scanner;
public class DsaBubbleSort {

    public static void bubbleSort(int[] a)
    {
        for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<a.length-i-1;j++)
            {
                if(a[j]>a[j+1])
                {
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
        for(int i=0;i<a.length;i++)
        {
            System.out.print(a[i]+" ");
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of elements of an array:");
        int n=sc.nextInt();
        System.out.println("Enter elements  of array:");
        int[] a=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }

        bubbleSort(a);
        sc.close();
    }
}
