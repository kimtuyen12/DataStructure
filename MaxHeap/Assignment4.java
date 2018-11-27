/*
Tuyen Pham
TUID 915591991
Assignment 4 - CIS2168 - Section 08
This assignment is to solve the following problems
 */
package assignment4;
import java.util.Arrays;

public class Assignment4 {

    public static void main(String[] args) {
       // Testing Selection Approach
        Word[] wordArray1 = WordReader.loadWords();
        Word[] mostFrequent1 = Selector.simpleSelect(wordArray1, 500);
        System.out.println("mostFrequent1: " + Arrays.toString(mostFrequent1));

        // Testing Heap-based Approach
        Word[] wordArray2 = WordReader.loadWords();
        Word[] mostFrequent2 = Selector.heapSelect(wordArray2, 500);
        System.out.println("mostFrequent2: " + Arrays.toString(mostFrequent2));
	}
    
}
