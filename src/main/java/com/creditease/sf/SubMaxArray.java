package com.creditease.sf;

public class SubMaxArray {
    /**
     * 求给定一个数组的子数组的最大的值
     */

    public static int[] array = {1,-2,3,10,-4,7,2,-5};

  
    public static void main(String[] args) {
        //暴力求解
        mock(array);
        System.out.println("----------");
        //分治法求解
        System.out.println(maxAddSub(array,0,7) + "");
        //线性的时间复杂度



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

        int middle = (right+left) / 2;
        int m = maxAddSub(array,left,middle);
        int n = maxAddSub(array,middle+1 , right);

        int fmax = 0;
        int tfmax = array[middle];

        for(int i = middle -1;i>=left;--i) {
            tfmax += array[i];
            if (fmax < tfmax) {
                fmax = tfmax;
            }
        }

        int tmax = 0;
        int ttmax = array[middle + 1];
        for (int i = middle +2; i<=right;++i) {
            ttmax += array[i];
            if (tmax < ttmax) {
                tmax = ttmax;
            }
        }

        return Math.max((tmax+fmax),Math.max(m,n));

    }





}