
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
    
    private static int comparisons = 0;
    private static int copies = 0;
    private static int recursiveCalls = 0;
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
        for (int i =0; i < 1000; i++){
           sort2(); 
        }
        System.out.println();
        printArray(a);
    }
    
    public static void sort(){
        int []tempArray = new int[a.length];
        Recursive(tempArray,0,a.length-1);
    }
    
    public static void sort2(){
        int []tempArray = new int[a.length];
        Iterative(tempArray,0,a.length-1);
    }
    
    public static void Recursive(int []tempArray, int lowerIndex, int upperIndex){
        if(lowerIndex != upperIndex){
            int mid = (lowerIndex+upperIndex)/2;
            Recursive(tempArray, lowerIndex, mid);
            recursiveCalls ++;
            Recursive(tempArray, mid+1, upperIndex);
            recursiveCalls ++;
            merge(tempArray, lowerIndex, mid+1,upperIndex);
        }
    }
    
    public static void Iterative(int[] tempArray, int lowerIndex, int upperIndex){
        int size = 10;
        int[] arrayb = new int[size];
        for (int i = 0; i < arrayb.length; i++){
            arrayb[i] = a[i];
            copies ++;
        }

        for (int i = 0; i < a.length; i++){
            tempArray[i] = a[i];
            copies ++;    
        }
        
        for (int i = 1; i < a.length; i ++){
            for (int j = 0; j < a.length; j ++){
                merge(tempArray, Math.min(j+1, a.length)-1,(j+1), Math.min(j + 2*i, a.length)-1);
            }
        }  
        
        for (int i = 0; i < tempArray.length; i++){
             tempArray[i] = a[i];
             copies ++;
        }
        
    }
    
    public static void merge(int []tempArray,int lowerIndexCursor,int higherIndex,int upperIndex){
        int tempIndex=0;
        int lowerIndex = lowerIndexCursor;
        int midIndex = higherIndex-1;
        int totalItems = upperIndex-lowerIndex+1;
        while(lowerIndex <= midIndex && higherIndex <= upperIndex){
            comparisons ++;
            if (a[lowerIndex] < a[higherIndex]){
                comparisons ++;
                tempArray[tempIndex++] = a[lowerIndex++];
                copies ++;
            }else{
                tempArray[tempIndex++] = a[higherIndex++];
                copies ++;
            }
        }
        
        while(lowerIndex <= midIndex){
            comparisons ++;
            tempArray[tempIndex++] = a[lowerIndex++];
            copies ++;
        }
        
        while(higherIndex <= upperIndex){
            comparisons ++;
            tempArray[tempIndex++] = a[higherIndex++];
            copies ++;
        }
        
        for(int i=0;i<totalItems;i++){
            a[lowerIndexCursor+i] = tempArray[i];
            copies ++;
        }
    }
    
    public static void printArray(int []array){
        for(int i : array){
            System.out.print(i+", ");
        }
        
        System.out.println("Comparisons : " + comparisons/1000);
        System.out.println("Copies : " + copies/1000);
        System.out.println("Recursive Calls : " + recursiveCalls/1000);
    }
    
    public static int[] getArray(){
        int size= 20;
        int[] array = new int[size];
        int item = 0;
        for(int i =0 ;i<size;i++){
            item = (int)(Math.random()*100);
            array[i] = item;
        }
        return array;
    }
    
}
