/*
 * problem statement:
 * find the majority of element in an array (high frequency element in an array)
 */
//Time Complexity: O(n)
//Space Complexity: O(1)

public class DsaMajorityElement {
    public static int majorityElement(int[] a) {
        // Approach Boyer Moore Voting Algorithm

        int count = 0;
        Integer majorityElem = null;
        for (int num : a) {
            if (count == 0) {
                majorityElem = num;
            }
            count += (num == majorityElem) ? 1 : -1;
        }
        return majorityElem;
    }

    public static void main(String[] args) {
        int[] a = { 2, 2, 1, 1, 1, 2, 2, 1, 1, 2 };
        // frquency of an element is greater than a.length/2]

        int res = majorityElement(a);
        System.out.println(res);

    }
}
