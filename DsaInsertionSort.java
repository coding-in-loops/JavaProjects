//Time Complexity: O(n^2)
//Space Complexity: O(1)

import java.util.Arrays;

public class DsaInsertionSort {
    public static void insertionSort(int[] a)
    {
        for(int i=0;i<a.length;i++)
        {
            int j=i;
            while(j>0 && a[j]<a[j-1])
            {
                int temp=a[j];
                a[j]=a[j-1];
                a[j-1]=temp;
                j--;
            }
        }
    }
    public static void main(String[] args) {
        int[] a={70,60,50,40,30,20,10};

        insertionSort(a);
        System.out.println("Sorted array: "+ Arrays.toString(a));

    }
}
