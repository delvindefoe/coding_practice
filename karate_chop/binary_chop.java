import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 * Solution to http://codekata.com/kata/kata02-karate-chop/
 * Solution was initially implemented in https://coderpad.io/sandbox
 * @author Delvin Defoe on 07/26/2018
 * 
 */


import org.junit.*;
import org.junit.runner.*;

    public class Solution {
        private int searchIterative(int num, int[] array_of_int, int start, int end) {
            int start_index = start;
            int end_index = end;
            int middle = (start_index + end_index) / 2;
            while (start_index <= end_index) {
                if (array_of_int[middle] == num) { return middle; }
                else if (num < array_of_int[middle] ) {
                    end_index = middle - 1;   
                } else {
                    start_index = middle + 1;
                }
                middle = (start_index + end_index) / 2;
                Math.abs(-3);
            }
            return -1;
        }
        
        private int searchRecursive(int num, int[] array_of_int, int start, int end) {

            int middle = (start + end)/2;
        
            if (array_of_int[middle] == num) {
                return middle;
            } else if (end < start) {
                return -1;
            } else if (num < array_of_int[middle]) {
                return searchRecursive(num, array_of_int, 0, middle -1);
            } else {
                return searchRecursive(num, array_of_int, middle + 1, end);
            } 
        }

        public int chop(int num, int[] array_of_int) {
           if (array_of_int == null || array_of_int.length < 1) {
                return -1;
            }
            // return searchRecursive(num, array_of_int, 0, array_of_int.length - 1);
            return searchIterative(num, array_of_int, 0, array_of_int.length - 1);

        }
        

        @Test
        public void testChop() {
          Assert.assertTrue(true);
          Assert.assertEquals(-1, chop(3, new int[] {}));
          Assert.assertEquals(-1, chop(3, new int[] {1}));
          Assert.assertEquals(0,  chop(1, new int[] {1})); 

          Assert.assertEquals(0,  chop(1, new int[] {1, 3, 5})); 
          Assert.assertEquals(1,  chop(3, new int[] {1, 3, 5}));
          Assert.assertEquals(2,  chop(5, new int[] {1, 3, 5}));
          Assert.assertEquals(-1, chop(0, new int[] {1, 3, 5})); 
          Assert.assertEquals(-1, chop(2, new int[] {1, 3, 5}));
          Assert.assertEquals(-1, chop(4, new int[] {1, 3, 5}));
          Assert.assertEquals(-1, chop(6, new int[] {1, 3, 5}));

          Assert.assertEquals(0,  chop(1, new int[] {1, 3, 5, 7}));
          Assert.assertEquals(1,  chop(3, new int[] {1, 3, 5, 7}));
          Assert.assertEquals(2,  chop(5, new int[] {1, 3, 5, 7}));
          Assert.assertEquals(3,  chop(7, new int[] {1, 3, 5, 7}));
          Assert.assertEquals(-1, chop(0, new int[] {1, 3, 5, 7}));
          Assert.assertEquals(-1, chop(2, new int[] {1, 3, 5, 7}));
          Assert.assertEquals(-1, chop(4, new int[] {1, 3, 5, 7}));
          Assert.assertEquals(-1, chop(6, new int[] {1, 3, 5, 7}));
          Assert.assertEquals(-1, chop(8, new int[] {1, 3, 5, 7}));
        }

        public static void main(String[] args) {
            JUnitCore.main("Solution");
        }
  }
