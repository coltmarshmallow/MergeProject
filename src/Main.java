
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
    
    // count variables intialised
    private static int comparisons = 0;
    private static int copies = 0;
    private static int recursiveCalls = 0;
    
    

    private static int []a;
    public static void main(String[] args){
        //make array and start loop for sorting 1000 times
        a = getArray();
        printArray(a);
        for (int i =0; i < 1000; i++){
           sort(); 
        }
        System.out.println();
        printArray(a);
    }
    
    public static void sort(){
        //create temporary array and start recursive method with left being the start and right being the end of the array
        int []tempArray = new int[a.length];
        Recursive(tempArray,0,a.length-1);
    }
    
    public static void sort2(){
        ////create temporary array and start iterative method with left being the start and right being the end of the array
        int []tempArray = new int[a.length];
        Iterative(tempArray,0,a.length-1);
    }
    
    public static void Recursive(int []tempArray, int lowerIndex, int upperIndex){
       // set up condition left < right
       // then use call the recursive method
       //first for section split on the start (left hand side) then the right hand side
       //followed by the merge and since left != right must loop again
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
        //set size to size of array in getArray otherwise get out of bounds error
        int size = 50;
        int[] arrayb = new int[size];
        //loop to copy first array into a second array
        for (int i = 0; i < arrayb.length; i++){
            arrayb[i] = a[i];
            copies ++;
        }

        for (int i = 0; i < a.length; i++){
            tempArray[i] = a[i];
            copies ++;    
        }
        
        //loop within loop mergeing  useing the temporary array and math sums to callculate the limits
        //loop increment is ++ instead of pseudo code given becuase in this implementation it was found to work
        for (int i = 1; i < a.length; i ++){
            for (int j = 0; j < a.length; j ++){
                merge(tempArray, Math.min(j+1, a.length)-1,(j+1), Math.min(j + 2*i, a.length)-1);
            }
        }  
        
        //coping sorted array to original
        for (int i = 0; i < tempArray.length; i++){
             tempArray[i] = a[i];
             copies ++;
        }
        
    }
    
    public static void merge(int []tempArray,int lowerIndexCursor,int higherIndex,int upperIndex){
        //an algorythm to merge which uses a lot of condition statements and  and copies the fragements based on the index in the array after compared
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
        //print method which uses a loop to print the array and print the average count varibles
        for(int i : array){
            System.out.print(i+", ");
        }
        
        System.out.println("Comparisons : " + comparisons/1000);
        System.out.println("Copies : " + copies/1000);
        System.out.println("Recursive Calls : " + recursiveCalls/1000);
    }
    
    public static int[] getArray(){
        //set array size then loop to fill array with random number generator
        int size= 5;
        int[] array = new int[size];
        int item = 0;
        for(int i =0 ;i<size;i++){
            item = (int)(Math.random()*100);
            array[i] = item;
        }
        return array;
    }
    
}
