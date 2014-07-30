public class TwoSortedArrayMedian { 
     
    // if A.length + B.length is even: 
    //     return two_array[len / 2 + 1] 
    // else  
    //     return (two_array[len / 2] + two_array[len / 2 + 1]) / 2 
     
    public double findMedianSortedArrays(int A[], int B[]) { 
        int len = A.length + B.length; 
         
        if (len % 2 == 0) { 
            return ((double) kthInTwoArray(A, 0, B, 0, len / 2) + (double) kthInTwoArray(A, 0, B, 0, len / 2 + 1)) / 2.0; 
        } else { 
            return kthInTwoArray(A, 0, B, 0, len / 2 + 1); 
        } 
         
    } 
     
    // Function: Find the kth smallest(largest if array is in descending order) number in two arrays 
     
    public int kthInTwoArray(int arr_1[], int start_1, int arr_2[], int start_2, int k) { 
        if (start_1 >= arr_1.length) { 
            return arr_2[start_2 + k - 1]; 
        } 
        if (start_2 >= arr_2.length) { 
            return arr_1[start_1 + k - 1]; 
        } 
         
        if (k == 1) { 
            return Math.min(arr_1[start_1], arr_2[start_2]); 
        } 
         
        // find the k/2th value for array_1 and array_2 
        int med_1 = (start_1 + k / 2 - 1 < arr_1.length) ? arr_1[start_1 + k / 2 - 1] 
                                                     : Integer.MAX_VALUE; 
        int med_2 = (start_2 + k / 2 - 1 < arr_2.length) ? arr_2[start_2 + k / 2 - 1] 
                                                     : Integer.MAX_VALUE; 
        // if array_1[k/2th] is smaller, it means all the entry before it is smaller than 
        // array_2[k/2th]. So we only need to search other k - k/2 numbers in  
        // array_1[start_1 + k/2 ...] AND array_2[start_2 ...] 
         
        if (med_1 < med_2) { 
            return kthInTwoArray(arr_1, start_1 + k / 2, arr_2, start_2, k - k / 2); 
        } else { 
            return kthInTwoArray(arr_1, start_1, arr_2, start_2 + k / 2, k - k / 2 ); 
        } 
         
    } 
}