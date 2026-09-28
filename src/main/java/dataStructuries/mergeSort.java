package dataStructuries;


public class mergeSort {


    public static int[] sortMerge(int[] array) {

        if (array == null || array.length < 2) return array;

        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        for (int i = 0; i <  mid; i++) {
            left[i] = array[i];
        }

        for (int i = mid; i < array.length; i++) {
            right[i - mid] = array[i];
        }

        return merge(sortMerge(left), sortMerge(right));
    }


    private static int[] merge(int[] arr1, int[] arr2) {

        int[] result =  new int[arr1.length + arr2.length];
        int resIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < arr1.length && rightIndex < arr2.length){
            if (arr1[leftIndex] < arr2[rightIndex]){
                result[resIndex++] = arr1[leftIndex++];
            }
            else {
                result[resIndex++] = arr2[rightIndex++];
            }
        }

        while (leftIndex < arr1.length){
            result[resIndex++] = arr1[leftIndex++];
        }

        while (rightIndex < arr2.length){
            result[resIndex++] = arr2[rightIndex++];
        }

        return result;

    }


}