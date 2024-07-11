//Time Complexity: O(n^2)
//Space Complexity: O(1)

import java.util.Arrays;

public class DsaSelectionSort {

    public static void selectionSort(int[] a)
    {
        for(int i=0;i<a.length;i++){
            int min_ind=i;
            for(int j=i+1;j<a.length;j++)
            {
                if(a[j]<a[min_ind])
                {
                    min_ind=j;
                }
            }
            if(min_ind!=i)
            {
                int temp=a[min_ind];
                a[min_ind]=a[i];
                a[i]=temp;
            }
        }
    }
    public static void main(String[] args) {
        int[] a={20,50,10,15,5,17};

        selectionSort(a);

        System.out.println("Sorted Array is: "+Arrays.toString(a));
    }
}
