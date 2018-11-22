package com.creditease.sf;

public class SFTest {


    public static int[] array = {1,-2,3,10,-4,7,2,-5};


    public static void main(String[] args) {
        //暴力求解
        mock(array);
        //分治法求解
        maxAddSub(array,0,7);
    }

    //暴力求解
    public static void mock(int[] array) {
        int ti = 0;
        int tj = 0;
        int max = 0;

        for (int i =0;i<array.length -1;i++) {
            int j = i + 1;
            for (;j<array.length;j++) {
                int tmax = 0;
                int k = i;
                for (;k<=j;k++) {
                    tmax += array[k];
                }
                if (tmax > max) {
                    ti =i;
                    tj = j;
                    max = tmax;
                }

            }

        }
        System.out.printf("max="+max + ",i="+ti+",j="+tj);
    }

    /**
     * nlogn 空间复杂度
     * @param array
     * @param left
     * @param right
     * @return
     */

    public static int maxAddSub(int[] array, int left ,int right) {

        if(right == left) {
            return array[left];
        }

        int middle = (right -left) / 2;
        int m = maxAddSub(array,left,middle-1);
        int n = maxAddSub(array,middle , right);

        int c  = array[middle];
        int lmiddle = middle;
        int leftMax ,tleftmax = array[middle -1];
        int i = middle -1;

        for (i =lmiddle -1;i > left; i-- ) {
            tleftmax += array[lmiddle];
            if (lmiddle < tleftmax) {
                leftMax = tleftmax;
            }
        }

        int b  = array[middle];
        int rmiddle = middle;
        int rightMax = array[middle];
        int trightmax = array[middle];
        int j = middle;

        for (j =rmiddle -1;j < right ; j++ ) {
            trightmax += array[lmiddle];
            if (rightMax < trightmax) {
                rightMax = trightmax;
            }
        }

        return Math.max((b+c),Math.max(m,n));

    }





}