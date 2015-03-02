
import java.util.Arrays;
import static jdk.nashorn.internal.objects.NativeMath.min;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 1301657
 */
public class Main {

    /**
     * @param a1
     * @param left1
     * @param right1
     * @param args the command line arguments
     * @param left2
     * @param right2
     * @param a2
     * @param left
     * @param a
     */
    
    public static void merge(Comparable[] a1, int left1, int right1,
    Comparable[] a2, int left2, int right2,
    Comparable[] a, int left) {
        // Merge a1[left1...right1] and a2[left2...right2] into
        // a[left...] (where both a1 and a2 are sorted).
        int i = left1, j = left2, k = left;
        while (i <= right1 && j <= right2) {
            //both a1 and a2 contain elements to be merged
            int comp = a1[i].compareTo(a2[j]);
            if (comp <= 0) {
                //a1 contains the smallest element, so it is copied
                //into the output array a
                a[k++] = a1[i++]; 
            } else {
                //a2 contains the smallest element, so it is copied
                //into the output array a
                a[k++] = a2[j++]; 
            }
        }
        while (i <= right1) {
            // All elements in a2 have been sorted
            //Copy the remainder elements from a1
        a[k++] = a1[i++]; 
        }
        while (j <= right2) {
            // All elements in a1 have been sorted 
            //Copy the remainder elements from a2
            a[k++] = a2[j++]; 
        }
    }
    
    
    public static void sort2(Comparable[] a) {
        if(a.length <= 1){ 
            return;
        }
        
        Comparable[] a1 = null;
        Comparable[] b = null;
        for (int i =0; i < a.length; i++){
            a1[i] = a[i];
        }
        
        for (int i = 1; i < a.length; i += 2*i){
            for (int j = 0; j < a.length; j += 2*i){
                merge(a1, j, 1-(min(j +1,a.length)), a1, j+i, min(j+2*i), b, a.length);
            }
            
        }
//        Comparable[] first = new Comparable[a.length / 2];
//        Comparable[] second = new Comparable[a.length - first.length];
//        
//        for (int i = 0; i < first.length; i++){
//            first[i] = a[i];
//        }
//        for (int i =0; i < second.length; i++){
//            second[i] = a[first.length +i];
//        }
//        sort2(first);
//        sort2(second);
//        
//        merge(first, 0, (a.length / 2),second, (a.length - first.length), a.length, a, (int) a[0]);
     }
    
    //private stativc
    
    public static void sort(Comparable[] a, int left, int right){
        
    }
    
  
    
    public static void main(String[] args) {
        Comparable[] a = ArrayUtil.randomIntArray(20 , 100);
        System.out.println(Arrays.toString(a));
        
        sort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
        
        //sort(a, 0, a.length);
        //System.out.print(a);
    }
    
}
