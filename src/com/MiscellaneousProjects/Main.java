package com.MiscellaneousProjects;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class Main {

    /**
     *
     * @param args - takes a list of integers are input which
     *  This unsorted array of integers is then sorted using Insertion sort.  For every element starting the second
     *  element =, it compares it to previous elements and if it is less than the previous numbers finds the appropriate
     *  place to insert it.  Once it finds the appropriate place, it essentially does a swap
     *
     */
    public static void main(String[] args) {

        //int[] inarray=new int[]{5,4,3,2,1};

        ArrayList<Integer> integerArrayList = new ArrayList<>();
        try {
            for (String str : args) {
                int num=Integer.valueOf(str);
                integerArrayList.add(num);
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid argument, please try again" + e.getMessage());
            System.exit(1);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, please try again " + e.getMessage() );
            System.exit(1);
        }

        int[] inarray = new int[integerArrayList.size()];
        int i=0;
        for(Integer num:integerArrayList){
            inarray[i++]=num;
        }

        System.out.println("Input Array:\n************");
        for(int num: inarray){
            System.out.print(" " + num + " ");
        }
        int[] sortedarray=insertionSort(inarray);


        System.out.println("\n************\n\nSorted array:\n************");
        for (int num: sortedarray){
            System.out.print(" " + num + " ");
        }
        System.out.println("\n************\n");


    }


    /**
     *
     * @param inarray - takes an unsorted array of integers
     *
     * @return - returns a sorted array of integers - starts going through second element and examines the previous
     * elements and if it is small than the previous numbers, finds the right place to insert in that position and moves
     * to the third element and so on.... hence as it goes proceeds through the elements it has a sorted array to that point
     *
     */
    public static int[] insertionSort (int[] inarray){

        int moveto=0;

        for(int i=1; i<inarray.length; i++){

            int num=inarray[i];
            INNER_LOOP:
            for (int j=i-1; j>=0; j--){
                if(num<inarray[j]){
                    moveto=j;
                }
                else {
                    moveto=j+1;
                    break INNER_LOOP;
                }

            }

            for (int m=i-1; m>=moveto; m--){
                inarray[m+1]=inarray[m];
            }


            inarray[moveto]=num;


        }


        return inarray;
    }
}
