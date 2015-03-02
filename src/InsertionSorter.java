
package week2;

/**
 * The sort method of this class sorts an array, using the insertion sort
 * algorithm.
 */
public class InsertionSorter {

    /**
     * Sorts an array, using insertion sort.
     *
     * @param a the array to sort
     * @param low the left-most element to be sorted in the array
     * @param high the right-most element to be sorted in the array
     */
    public static void sort(Comparable[] a, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            // Store the value to be inserted
            Comparable val = a[i];
            // Place the value in the sorted part of the array
            int p = i;
            while (p > low && val.compareTo(a[p - 1]) < 0) {
                a[p] = a[p - 1];
                p--;
            }
            a[p] = val;
        }
    }
}
