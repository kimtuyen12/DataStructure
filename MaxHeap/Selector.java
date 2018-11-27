/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

public class Selector {
   
    private static void swap(Word[] array, int i, int j){
            if(i == j) return;

            Word temp = array[i];
            array[i] = array[j];
            array[j] = temp;
    }

    // Problem #1 (5 pts)
    // Fill in the following method with an O(n*k) time algorithm
    // that returns the k largest elements of array in order from
    // largest to smallest.
    // Note: This should return an array with k elements.
    // Hint: Your approach should be similar to selection sort.
    public static Word[] simpleSelect(Word[] array, int k){
        for (int i=0; i<k; i++){
            int max = i;
            for (int j=i+1; j<array.length; j++){
                if (array[j].compareTo(array[max])>0){                  
                    max = j;
                }
            } 
            if (max != i){
               swap (array, i, max);
            }
        }
        Word[] result = new Word[k];
        for (int i=0; i<k; i++){
            result[i] = array[i];
        }
        return result;
    }

    // Problem #4 (5 pts)
    // Fill in the following method with an O(n + klog(n)) time algorithm
    // that returns the k largest elements of array in order from
    // largest to smallest.
    // Note: This should return an array with k elements.
    // Hint: Your approach should use a BinaryHeap.
    public static Word[] heapSelect(Word[] array, int k){
        BinaryHeap heap = new BinaryHeap(array);
        Word[] result = new Word[k];
        for (int i=0; i<k; i++){
            result[i] = heap.removeMax(); 
        }
        return result;
    }
}
