
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
     * @param left2
     * @param right2
     * @param a2
     * @param left
     * @param a
     */
    

    private static int []a;
    public static void main(String[] args){
        a = getArray();
        printArray(a);
        sort2();
        System.out.println();
        printArray(a);
    }
    
    public static void sort(){
        int []tempArray = new int[a.length];
        mergeSort(tempArray,0,a.length-1);
    }
    
    public static void sort2(){
        int []tempArray = new int[a.length];
        Iterative(tempArray,0,a.length-1);
    }
    
    public static void mergeSort(int []tempArray, int lowerIndex, int upperIndex){
        if(lowerIndex == upperIndex){
            return;
        }else{
            int mid = (lowerIndex+upperIndex)/2;
            mergeSort(tempArray, lowerIndex, mid);
            mergeSort(tempArray, mid+1, upperIndex);
            merge(tempArray, lowerIndex, mid+1,upperIndex);
        }
    }
    
    public static void Iterative(int[] tempArray, int lowerIndex, int upperIndex){
        int size = 10;
        int[] arrayb = new int[size];
        for (int i = 0; i < arrayb.length; i++){
            arrayb[i] = a[i];
        }

        for (int i = 0; i < a.length; i++){
            tempArray[i] = a[i];
        }
        
        for (int i = 1; i < a.length; i ++){
            for (int j = 0; j < a.length; j ++){
                merge(tempArray, Math.min(j+1, a.length)-1,(j+1), Math.min(j + 2*i, a.length)-1);
            }
        }  
        
        for (int i = 0; i < tempArray.length; i++){
             tempArray[i] = a[i];
        }
        
    }
    
    public static void merge(int []tempArray,int lowerIndexCursor,int higherIndex,int upperIndex){
        int tempIndex=0;
        int lowerIndex = lowerIndexCursor;
        int midIndex = higherIndex-1;
        int totalItems = upperIndex-lowerIndex+1;
        while(lowerIndex <= midIndex && higherIndex <= upperIndex){
            if (a[lowerIndex] < a[higherIndex]){
                tempArray[tempIndex++] = a[lowerIndex++];
            }else{
                tempArray[tempIndex++] = a[higherIndex++];
            }
        }
        
        while(lowerIndex <= midIndex){
            tempArray[tempIndex++] = a[lowerIndex++];
        }
        
        while(higherIndex <= upperIndex){
            tempArray[tempIndex++] = a[higherIndex++];
        }
        
        for(int i=0;i<totalItems;i++){
            a[lowerIndexCursor+i] = tempArray[i];
        }
    }
    
    public static void printArray(int []array){
        for(int i : array){
            System.out.print(i+", ");
        }
    }
    
    public static int[] getArray(){
        int size=10;
        int[] array = new int[size];
        int item = 0;
        for(int i =0 ;i<size;i++){
            item = (int)(Math.random()*100);
            array[i] = item;
        }
        return array;
    }
    
}
