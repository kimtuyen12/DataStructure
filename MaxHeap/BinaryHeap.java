/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;
import java.util.NoSuchElementException;

public class BinaryHeap {
    
    private Word[] wordArray;
    private int size;

    public BinaryHeap(Word[] array){
        wordArray = array;
        size = array.length;
        buildHeap(array);
    }

    // Problem #2 (20 pts)
    // Fill in the following method with an O(n) time algorithm
    // that builds an n element complete binary heap.
    // Note: You are allowed to add helper methods.
    public void buildHeap(Word[] array){
        for (int i=array.length/2-1; i>=0; i--){
            sink(array,i);
        }
    }

    // Problem #3 (15 pts)
    // Fill in the following method with an O(log(n)) time algorithm
    // that removes the root element, restores the heap structure,
    // and finally returns the removed root element.
    public Word removeMax(){
        if (size == 0){
            throw new NoSuchElementException ("The heap is empty");
        }
        Word result = wordArray[0];
        wordArray[0] = wordArray[size-1];
        size --;
        sink (wordArray, 0);
        return result;
    }
    
    public static void sink (Word[] array, int i){
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if (left < array.length && array[left].compareTo(array[largest])>0){
            largest = left;
        } 
        if (right < array.length && array[right].compareTo(array[largest])>0){
            largest = right;
        } 
        if (largest != i){
            Word swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;
            sink (array, largest);
        }
    }
}

