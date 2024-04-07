package bubblesort;

import java.util.Scanner;

public class BubbleSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Step 1: display a screen to ask users to enter a positive decimal number.
        int userInputNumber = displayInputNumber();

        //Step 2: random integer in range for each array element.
        int[] randomArr = arrayRandom(userInputNumber);
        //test bubble sort algorithm
        //int[] randomArr = {5, 1, 12, -5, 16};

        //Step 3: display random array.
        displayArr(randomArr, "Unsorted array: ", "\n");

        //Step 4: BubbleSort.
        int[] afterSortArr = bubbleSort(randomArr);

        //Step 5: display array after sorting.
        displayArr(afterSortArr, "Sorted array: ", "");

    }

    //display a screen to ask users to enter a positive decimal number.
    private static int displayInputNumber() {
        System.out.println("Enter number of array:");
        Scanner sc = new Scanner(System.in);
        //loop until user enters positive number
        while (true) {
            try {
                int posNum = Integer.parseInt(sc.nextLine().trim());
                //notice if user enters number less or equal to 0
                if (posNum <= 0) {
                    System.out.println("Must be input positive number greater than 0.");
                    System.out.println("Enter again: ");
                } //return positive nummber if user enters right
                else if (posNum > 0) {
                    return posNum;
                }
            } //notice if user enters string
            catch (NumberFormatException ex) {
                System.out.println("Must be input integer.");
                System.out.println("Enter again: ");
            }
        }
    }

    //random integer in range for each array element.
    private static int[] arrayRandom(int arrSize) {
        int[] arrRandom = new int[arrSize];
        //input random values for each element of array
        for (int i = 0; i < arrSize; i++) {
            //random each element
            arrRandom[i] = (int) (Math.random() * arrSize);
        }
        return arrRandom;
    }

    private static void displayArr(int[] arr, String arrName, String end) {
        System.out.print(arrName + "[");
        //display values of all array elements
        for (int i = 0; i < arr.length; i++) {
            if (i == (arr.length - 1)) {
                System.out.print(arr[i] + "] " + end);
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
    }

    //Sort array by bubble sort
    private static int[] bubbleSort(int[] arr) {
        //loop from beginning to the end of array
        for (int i = 0; i < arr.length; i++) {
            System.out.println();
            //not have swap yet
            boolean haveSwap = false;
            //loop from the beginning of an array to the last element of unsorted array
            for (int j = 0; j < arr.length - i - 1; j++) {
                //display array before check algorithm
                displayArr(arr, "", "\t");
                //swap two elements if the element after greater than before
                if (arr[j] > arr[j + 1]) {
                    System.out.println(arr[j] + ">" + arr[j + 1] + ", swap");
                    //swap two elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    //have swap
                    haveSwap = true;
                } 
                else if (arr[j] < arr[j + 1]) {
                    System.out.println(arr[j] + "<" + arr[j + 1] + ", ok");
                } 
                else if (arr[j] == arr[j + 1]) {
                    System.out.println(arr[j] + "=" + arr[j + 1] + ", ok");
                }
            }
            //when no swap, bubble sort stops.
            if (!haveSwap) {
                break;
            }
        }
        System.out.println();
        return arr;
    }
}
