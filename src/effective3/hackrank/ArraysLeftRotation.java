package effective3.hackrank;

import java.util.Scanner;

public class ArraysLeftRotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 5;
        int k = 2;
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = a_i+1;
        }



      /*

        a[(n-k-1)] = last;*/


      a=  rotateArray(a,k);


        for(int a_i=0; a_i < n; a_i++){
            System.out.print( a[a_i]+" ");
        }


    }

    public static int[] rotateArray(int[] arr, int d){
        // Because the constraints state d < n, we need not concern ourselves with shifting > n units.
        int n = arr.length;

        // Create new array for rotated elements:
        int[] rotated = new int[n];

        // Copy segments of shifted elements to rotated array:
        System.arraycopy(arr, d, rotated, 0, n - d);
        System.arraycopy(arr, 0, rotated, n - d, d);

        return rotated;
    }


    public static int[] myVersionRotateArray(int[] a, int k){
       int n = a.length;
        for(int i =1; i<=k;i++){
            int last = a[0];
            System.arraycopy(a,1,a,0,n-1);
            a[n-1] =last;
        }

        return a;
    }

}
